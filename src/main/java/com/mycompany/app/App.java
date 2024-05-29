package com.mycompany.app;

import javax.annotation.Resource;
import com.bitget.openapi.common.client.BitgetRestClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.bitget.openapi.dto.response.ResponseResult;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //orderService.placeLimitOrder("BTCUSDT", "buy", "limit", "GTC", "77012.1", "0.001");
        //orderService.placeStopBuyOrder("BTCUSDT", "buy", "limit", "GTC", "77012.1", "0.001");
        //orderService.limitBuyDemoFutures();
        orderService.stopBuyDemoFutures();
    }
}