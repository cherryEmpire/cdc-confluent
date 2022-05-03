package com.cherry.service.impl;

import com.cherry.dtos.ELKDocumentDto;
import com.cherry.entities.User;
import com.cherry.service.RabbitReceiveService;
import com.cherry.service.elastic.ElasticSearchDocumentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/2/2 14:32
 * @Description: RabbitReceiveServiceImpl
 */
@Service
@RabbitListener(queues = "${cherry.rabbit.addUserQueueName}")
@Slf4j
public class RabbitReceiveServiceImpl implements RabbitReceiveService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ElasticSearchDocumentService elasticSearchDocumentService;

    @Override
    @RabbitHandler
    public void receive(User user) throws JsonProcessingException {
        ELKDocumentDto test = new ELKDocumentDto("test", user);
        elasticSearchDocumentService.createDocument(test);
        log.info("receive {}", objectMapper.writeValueAsString(user));
    }
}
