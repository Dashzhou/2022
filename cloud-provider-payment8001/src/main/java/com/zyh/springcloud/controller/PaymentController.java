package com.zyh.springcloud.controller;

import com.zyh.springcloud.service.impl.PaymentServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import zyh.springcloud.entities.CommonResult;
import zyh.springcloud.entities.Payment;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@RestController
@Log4j2
public class PaymentController {
    @Resource
    PaymentServiceImpl paymentServiceimpl;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi ,i'am paymentzipkin server fall back，welcome to here, O(∩_∩)O哈哈~";
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment paymentById = paymentServiceimpl.getPaymentById(id);
        if (paymentById != null) {
            CommonResult<Payment> commonResult = new CommonResult<Payment>(100, "查询成功+serverPor=" + serverPort, paymentById);

            return commonResult;
        }
        CommonResult<Payment> commonResult = new CommonResult<Payment>(200, "查询失败");
        return commonResult;
    }

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int creat = paymentServiceimpl.creat(payment);

        if (creat > 0) {
            return new CommonResult(100, "新增成功serverPort=" + serverPort);
        }
        return new CommonResult(200, "新增失败");
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId());
        }
        return this.discoveryClient;
    }

}
