package com.humor.effective.java_8_new_speciality.lambda;

import com.humor.effective.effective_java.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * create by humor
 * @date 2018/8/10 上午10:01
 * @describe lambda 集合 批量数据操作
 * JSR是Java Specification Requests的缩写，意思是Java 规范请求,
 * Java 8 版本的主要改进是 Lambda 项目（JSR 335），
 * 其目的是使 Java 更易于为多核处理器编写代码。
 * JSR 335=lambda表达式+接口改进（默认方法）+批量数据操作
 */
@Slf4j
public class LambdaCollectionOperation {

    public static void main(String[] args) {
        User a = User.builder().email("a").build();
        User b = User.builder().email("b").build();
        List<User> list = Arrays.asList(a,b);
//        list.forEach(user ->  user.setEmail("lambda"));
//        System.out.println(a);
//        System.out.println(b);

        long b1 = list.stream().filter(user -> user.getEmail().equals("b")).count();
        System.out.println(b1);
        List<User> userList = list.stream().filter(user -> user.getEmail().equals("a")).collect(Collectors.toList());
        userList.forEach(user -> System.out.println(user.getEmail()));

    }

}
