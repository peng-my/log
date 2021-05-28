
package com.example.log.event;


import ch.qos.logback.classic.spi.LoggingEvent;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.log.constant.LogConstant;
import com.example.log.entity.LogEntity;
import com.example.log.thread.LogThread;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 异步监听日志事件
 * @author xs
 */
@Slf4j
@AllArgsConstructor
public class CurrencyLogListener {




	@Async
	@Order
	@EventListener(CurrencyLogEvent.class)
	public void saveApiLog(CurrencyLogEvent event) {
		log.info("日志事件接收");
		Object source = event.getSource();
		Map<String,Object> map = JSONObject.parseObject(JSON.toJSONString(source));
		LogEntity entity = JSON.parseObject(JSON.toJSONString(map.get("logEntity")), LogEntity.class);
		LogConstant.LOG_LIST.add(entity);
		LogThread logThread = new LogThread();
		logThread.setName("log-async");
		logThread.start();
		LogThread.getLogSize(logThread);
	}

}
