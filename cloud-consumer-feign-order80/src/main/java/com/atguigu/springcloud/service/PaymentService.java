package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment>getPaymentById(@PathVariable("id") Long id);

    @PostMapping(value = "/payment/create")
    CommonResult create(@RequestBody Payment payment);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimout();

}
