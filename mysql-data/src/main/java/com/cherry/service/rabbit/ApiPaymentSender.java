package com.cherry.service.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/2/2 16:11
 * @Description: ApiPaymentSender
 */
@Component
@Slf4j
public class ApiPaymentSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void order(String msg) {
        log.info("api.payment.order send message: " + msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order", msg);
    }

    public void orderQuery(String msg) {
        log.info("api.payment.order.query send message: " + msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order.query", msg);
    }

    public void orderDetailQuery(String msg) {
        log.info("api.payment.order.detail.query send message: " + msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order.detail.query", msg);
    }
}
