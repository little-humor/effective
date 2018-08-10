package com.humor.effective.java_8_new_speciality.lambda;

/**
 * create by humor
 * @date 2018/8/10 上午9:35
 * @describe Lambda 语法篇
 */
public class LambdaGrammar {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("lambda线程")).start();
        userInnerClass();
    }

    public static void userInnerClass(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("内部类实现的线程");
            }
        }).start();
    }



}
