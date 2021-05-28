package com.example.log.event;

import org.springframework.context.ApplicationEvent;

import java.util.Map;

/**
 * 通用日志事件
 * @author xs
 */
public class CurrencyLogEvent extends ApplicationEvent {

	public CurrencyLogEvent(Map<String, Object> source) {
		super(source);
	}

}
