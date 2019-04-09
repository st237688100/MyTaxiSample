package com.st.practice.mytaxi;

/**
 * @Author: shiteng
 * @Date: 2019/4/9 10:55
 */
public class StudentService implements UserService {


    @Override
    public void work(String workContent) {
        System.out.println("StudentService work:" + workContent);
    }

}
