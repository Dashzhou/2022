package com.zyh.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 *
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() throws InterruptedException {

        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.info("TestD-----------");
        return "------testD";
    }


    @GetMapping("/testE")
    public String testE() throws InterruptedException {
        int a = 10 / 0;
        log.info("TestE-----------");
        return "------testE";
    }
}
