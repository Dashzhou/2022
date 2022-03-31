package com.zyh.springcloud.service;

import org.apache.ibatis.annotations.Param;
import zyh.springcloud.entities.Payment;

/**
 *
 */
public interface PaymentService {
    public int creat(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
