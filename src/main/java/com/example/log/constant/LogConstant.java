package com.example.log.constant;


import com.example.log.entity.LogEntity;
import com.example.log.thread.LogThread;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author xs
 * 日志用的常量
 */
public interface LogConstant {
    /**
     * 存放日志
     */
    List<LogEntity> LOG_LIST=new ArrayList<>();
    /**
     * 日志队列
     */
    BlockingDeque<String> LOG_BLOCKING_DEQUE = new LinkedBlockingDeque<>();
}
