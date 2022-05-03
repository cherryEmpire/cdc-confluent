package com.cherry.service.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/2/2 16:09
 * @Description: ApiPaymentReceive
 */
@Component
@Slf4j
public class ApiPaymentReceive {
    @RabbitHandler
    @RabbitListener(queues = "api.payment")
    public void order(String msg) {
        log.info("api.payment.order receive message: " + msg);
    }
}
