package com.humor.effective.effective_java;

import com.humor.effective.effective_java.model.User;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * create by humor
 * @date 2018/8/9 下午1:35
 */
@Slf4j
public class UserTest {

    public static void main(String[] arg){

        /**
         * field超过四五个以上的建议使用builder构建器构建对象
         */
        User user = User.builder().username("humor")
                .password("******")
                .email("guxingyin@live.cn")
                .phone("17091921952")
                .role(1)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        log.info(user.toString());
    }



}
