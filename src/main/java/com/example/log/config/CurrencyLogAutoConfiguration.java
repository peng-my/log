package com.example.log.config;

import com.example.log.logger.CurrencyLogger;
import com.example.log.event.CurrencyLogListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 日志工具自动配置
 * @author xs
 */
@Configuration
@ConditionalOnWebApplication
public class CurrencyLogAutoConfiguration {
    @Bean
    public CurrencyLogger currencyLogger() {
        return new CurrencyLogger();
    }
    @Bean
    @ConditionalOnMissingBean(name = "currencyLogListener")
    public CurrencyLogListener currencyLogListener() {
        return new CurrencyLogListener();
    }
}
