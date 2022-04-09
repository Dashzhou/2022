package com.zyh.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import zyh.springcloud.entities.CommonResult;
import zyh.springcloud.entities.Payment;

/**
 *
 */

@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymenService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
