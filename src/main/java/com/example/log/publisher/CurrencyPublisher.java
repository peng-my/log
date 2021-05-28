package com.example.log.publisher;


import com.example.log.constant.LogConstant;
import com.example.log.entity.LogEntity;
import com.example.log.event.CurrencyLogEvent;
import com.example.log.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;


/**
 * @author xs
 * 日志信息事件发送
 */
@Slf4j
public class CurrencyPublisher {

    public static void publishEvent(String level,  String data) {
        log.info("日志信息事件发送");
        //这个队列实际上可用可不用
        LogConstant.LOG_BLOCKING_DEQUE.offer(data);
        String logData = LogConstant.LOG_BLOCKING_DEQUE.poll();
        LogEntity logEntity=new LogEntity();
        logEntity.setLevel(level);
        logEntity.setData(logData);
        Map<String, Object> event = new HashMap<>(16);
        event.put("logEntity",logEntity);
        SpringUtils.publishEvent(new CurrencyLogEvent(event));
    }
}
