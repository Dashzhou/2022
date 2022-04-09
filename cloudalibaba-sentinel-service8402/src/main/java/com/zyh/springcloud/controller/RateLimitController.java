package com.zyh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zyh.springcloud.myHandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zyh.springcloud.entities.CommonResult;
import zyh.springcloud.entities.Payment;

/**
 *
 */
@RestController
public class RateLimitController {
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }

    @GetMapping("/rateLimit/CustomerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public CommonResult CustomerBlockHandler() {
        return new CommonResult(200, "CustomerBlockHandler", new Payment(2020L, "serial002"));
    }
}
