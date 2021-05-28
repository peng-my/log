package com.example.log.controller;

import com.example.log.logger.CurrencyLogger;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 * @author xs
 */
@RestController
@AllArgsConstructor
public class TestController {
    private final CurrencyLogger currencyLogger;
    @GetMapping("/test")
    public String getTest(String data){
        currencyLogger.info(data);
        return data;
    }
}
