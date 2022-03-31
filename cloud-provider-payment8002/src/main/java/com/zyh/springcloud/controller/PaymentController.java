package com.zyh.springcloud.controller;

import com.zyh.springcloud.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import zyh.springcloud.entities.CommonResult;
import zyh.springcloud.entities.Payment;

import javax.annotation.Resource;

/**
 *
 */
@RestController
public class PaymentController {
    @Resource
    PaymentServiceImpl paymentServiceimpl;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment paymentById = paymentServiceimpl.getPaymentById(id);
        if (paymentById != null) {
            CommonResult<Payment> commonResult = new CommonResult<Payment>(100, "查询成功serverPort="+serverPort, paymentById);

            return commonResult;
        }
        CommonResult<Payment> commonResult = new CommonResult<Payment>(200, "查询失败");
        return commonResult;
    }

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int creat = paymentServiceimpl.creat(payment);

        if (creat > 0) {
            return new CommonResult(100, "新增成功serverPort="+serverPort);
        }
        return new CommonResult(200, "新增失败");
    }

}
