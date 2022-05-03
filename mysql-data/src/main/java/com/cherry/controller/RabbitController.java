package com.cherry.controller;

import com.cherry.common.dtos.CommonResult;
import com.cherry.entities.User;
import com.cherry.service.RabbitSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/2/2 11:21
 * @Description: RabbitController
 */
@RestController
@RequestMapping({"/rabbit"})
public class RabbitController {

    @Autowired
    private RabbitSendService rabbitSendService;

    @RequestMapping(value = {"/send"}, method = {RequestMethod.POST})
    public CommonResult<String> send(@RequestBody User user) {
        rabbitSendService.sender(user);
        return CommonResult.succeed("Message send success");
    }
}
