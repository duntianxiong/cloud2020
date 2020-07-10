package com.eiletxie.springcloud.alibaba;

import com.eiletxie.springcloud.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author EiletXie
 * @Since 2020/3/15 17:57
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "nacos-payment-provider",configuration = MySelfRule.class)
public class OrderNacosMain83 {

    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain83.class,args);
    }
}
