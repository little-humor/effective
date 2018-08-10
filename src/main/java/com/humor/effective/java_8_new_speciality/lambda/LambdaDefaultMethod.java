package com.humor.effective.java_8_new_speciality.lambda;

/**
 * @author zhangshaoze
 * @create 2018-08-10 上午9:45
 * @describe lambda 接口默认方法
 */
public interface LambdaDefaultMethod {

    default void test(){
        System.out.println("interface default method test ...");
    }

    default void test1(){
        System.out.println("--");
    }

}
