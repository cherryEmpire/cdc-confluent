package com.cherry.service;

import com.cherry.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/2/2 14:32
 * @Description: RabbitReceiveService
 */
public interface RabbitReceiveService {

    public void receive(User user) throws JsonProcessingException;
}
