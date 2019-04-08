package com.st.practice.mytaxi.network;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.SPCookieStore;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.OkHttpClient;

/**
 *
 */
public class MyClient extends BaseHttpClient<BaseRequest,BaseResponse>{

    public void init(Application context){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkGo");
        //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        //log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setColorLevel(Level.INFO);
        builder.addInterceptor(loggingInterceptor);
        //非必要情况，不建议使用，第三方的开源库，使用通知显示当前请求的log，不过在做文件下载的时候，这个库好像有问题，对文件判断不准确
        //builder.addInterceptor(new ChuckInterceptor(context));

        //全局的读取超时时间
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        //全局的写入超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        //全局的连接超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        //使用sp保持cookie，如果cookie不过期，则一直有效
        builder.cookieJar(new CookieJarImpl(new SPCookieStore(context)));
        //使用数据库保持cookie，如果cookie不过期，则一直有效
        //builder.cookieJar(new CookieJarImpl(new DBCookieStore(context)));
        //使用内存保持cookie，app退出后，cookie消失
        //builder.cookieJar(new CookieJarImpl(new MemoryCookieStore()));

        // SSL

        try {
            //方法一：信任所有证书,不安全有风险
            HttpsUtils.SSLParams sslParams1 = HttpsUtils.getSslSocketFactory();
            //方法二：自定义信任规则，校验服务端证书
            //HttpsUtils.SSLParams sslParams2 = HttpsUtils.getSslSocketFactory(new SafeTrustManager());
            //方法三：使用预埋证书，校验服务端证书（自签名证书）
                HttpsUtils.SSLParams sslParams3 = HttpsUtils.getSslSocketFactory(context.getAssets().open("srca.cer"));
            //方法四：使用bks证书和密码管理客户端证书（双向认证），使用预埋证书，校验服务端证书（自签名证书）
            HttpsUtils.SSLParams sslParams4 = HttpsUtils.getSslSocketFactory(context.getAssets().open("xxx.bks"), "123456", context.getAssets().open("yyy.cer"));
            builder.sslSocketFactory(sslParams1.sSLSocketFactory, sslParams1.trustManager);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // header
        HttpHeaders headers = new HttpHeaders();
        headers.put("commonHeaderKey1", "commonHeaderValue1");    //header不支持中文，不允许有特殊字符
        HttpParams params = new HttpParams();
        params.put("commonParamsKey1", "commonParamsValue1");     //param支持中文,直接传,不要自己编码
        params.put("commonParamsKey2", "支持中文参数");

        OkGo.getInstance().init(context)                       //必须调用初始化
            .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置将使用默认的
            .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
            .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)   //全局统一缓存时间，默认永不过期，可以不传
            .setRetryCount(1)                               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
            .addCommonHeaders(headers)                      //全局公共头
            .addCommonParams(params);                       //全局公共参数
    }

    public BaseResponse call(BaseRequest request) {
        String url = baseUrl + request.getUrl();
        HttpParams params = new HttpParams();
        params.put(request.getParams(),true);
        if ("GET".equals(request.getMethod())) {
            OkGo.get(url).params(params).execute(new AbsCallback<Object>() {
                @Override
                public Object convertResponse(okhttp3.Response response) throws Throwable {
                    return null;
                }

                @Override
                public void onSuccess(Response<Object> response) {

                }
            });
        } else if ("POST".equals(request.getMethod())) {
            OkGo.post(url).params(params).execute(new AbsCallback<Object>() {
                @Override
                public Object convertResponse(okhttp3.Response response) throws Throwable {
                    return null;
                }

                @Override
                public void onSuccess(Response<Object> response) {

                }
            });
        }

        return null;
    }

    public BaseRequest get(String url){
        BaseRequest request = new BaseRequest();
        return null;
    }

    public BaseResponse post(BaseRequest request){

        return null;
    }

}
