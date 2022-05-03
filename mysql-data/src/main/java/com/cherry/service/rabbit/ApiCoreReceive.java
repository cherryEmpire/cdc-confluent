package com.cherry.service.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/2/2 16:09
 * @Description: ApiCoreReceive
 */
@Component
@Slf4j
public class ApiCoreReceive {
    @RabbitHandler
    @RabbitListener(queues = "api.core")
    public void user(String msg) {
        log.info("api.core receive message: " + msg);
    }
}
