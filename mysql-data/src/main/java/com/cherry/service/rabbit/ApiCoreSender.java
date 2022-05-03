package com.cherry.service.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/2/2 16:10
 * @Description: ApiCoreSender
 */
@Component
@Slf4j
public class ApiCoreSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void user(String msg) {
        log.info("api.core.user send message: " + msg);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user", msg);
    }

    public void userQuery(String msg) {
        log.info("api.core.user.query send message: " + msg);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user.query", msg);
    }
}
