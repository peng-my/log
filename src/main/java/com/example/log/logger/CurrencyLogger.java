package com.example.log.logger;

import com.example.log.publisher.CurrencyPublisher;
import org.springframework.beans.factory.InitializingBean;

/**
 *日志工具类
 * @author xs
 */
public class CurrencyLogger implements InitializingBean {
    public void info(String data) { CurrencyPublisher.publishEvent("info", data); }

    public void debug( String data) {
        CurrencyPublisher.publishEvent("debug",  data);
    }

    public void warn( String data) {
        CurrencyPublisher.publishEvent("warn",  data);
    }

    public void error( String data) {
        CurrencyPublisher.publishEvent("error", data);
    }
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
