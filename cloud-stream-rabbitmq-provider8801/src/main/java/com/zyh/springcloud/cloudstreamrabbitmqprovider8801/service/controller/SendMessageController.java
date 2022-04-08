package com.zyh.springcloud.cloudstreamrabbitmqprovider8801.service.controller;

import com.zyh.springcloud.cloudstreamrabbitmqprovider8801.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}

