package com.cherry.service;

import com.cherry.entities.User;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/2/2 14:29
 * @Description: RabbitService
 */
public interface RabbitSendService {

    public void sender(User user);
}
