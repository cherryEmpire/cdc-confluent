package com.cherry.config.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/2/2 11:32
 * @Description: RabbitDirectConfig
 */
@Configuration
@ConfigurationProperties(prefix = "cherry.rabbit")
public class RabbitDirectConfig {

    @Bean
    public Queue addUserQueue() {
        return new Queue(addUserQueueName);
    }

    private String addUserQueueName;

    public String getAddUserQueueName() {
        return addUserQueueName;
    }

    public void setAddUserQueueName(String addUserQueueName) {
        this.addUserQueueName = addUserQueueName;
    }
}
