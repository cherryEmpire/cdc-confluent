package com.cherry.service.impl;

import com.cherry.config.rabbit.RabbitDirectConfig;
import com.cherry.entities.User;
import com.cherry.service.RabbitSendService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/2/2 14:29
 * @Description: RabbitServiceImpl
 */
@Service
public class RabbitSendServiceImpl implements RabbitSendService {

    @Autowired
    private RabbitDirectConfig rabbitDirectConfig;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public void sender(User user) {
        rabbitTemplate.convertAndSend(rabbitDirectConfig.getAddUserQueueName(), user);
    }
}
