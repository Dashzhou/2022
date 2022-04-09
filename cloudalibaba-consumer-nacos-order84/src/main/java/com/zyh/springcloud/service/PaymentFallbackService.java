package com.zyh.springcloud.service;


import org.springframework.stereotype.Service;
import zyh.springcloud.entities.CommonResult;
import zyh.springcloud.entities.Payment;

/**
 *
 */
@Service
public class PaymentFallbackService implements PaymenService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<Payment>(444, "服务降级返回----PaymentFallbackService");
    }
}
