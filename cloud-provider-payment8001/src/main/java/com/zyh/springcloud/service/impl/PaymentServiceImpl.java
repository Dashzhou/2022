package com.zyh.springcloud.service.impl;


import com.zyh.springcloud.dao.PaymentMapper;
import com.zyh.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import zyh.springcloud.entities.Payment;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentMapper paymentMapper;

    @Override
    public int creat(Payment payment) {
        return paymentMapper.creat(payment);

    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
