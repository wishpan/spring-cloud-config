package com.atguigu.springcloud;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignClientController {
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }
    @PostMapping(value = "/consumer/payment/create")
    public CommonResult create(Payment payment){
        return paymentService.create(payment);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String getFeign(){
        return paymentService.paymentFeignTimout();
    }
}

