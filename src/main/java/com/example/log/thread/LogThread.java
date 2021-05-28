package com.example.log.thread;

import com.example.log.constant.LogConstant;
import com.example.log.entity.LogEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

/**
 * @author xs
 * 日志线程
 */
@Slf4j
public class LogThread extends Thread {
    private static Integer SIZE=10;
    private static Thread thread;
    private static List<LogEntity> infoList=new ArrayList<>();
    @Override
    public void run() {
        if (LogConstant.LOG_LIST.size()==SIZE){
            setLog();
        }
        super.run();
    }
    public static void getLogSize(Thread logThread){
        thread=logThread;
        int size = LogConstant.LOG_LIST.size();
        if (size>SIZE){
            LockSupport.park();
        }
    }
    private static void setLog(){
        log.info("当前线程名："+Thread.currentThread().getName());
        LockSupport.unpark(thread);
        System.out.println("数组"+LogConstant.LOG_LIST);
       for (LogEntity logEntity:LogConstant.LOG_LIST){
           if (logEntity.getLevel().equals("info")){
               infoList.add(logEntity);

           }
       }
        LogConstant.LOG_LIST.clear();
        System.out.println("数组长度"+LogConstant.LOG_LIST.size());

    }

    public static void main(String[] args) {
        LogThread logThread=new LogThread();
        logThread.setName("log");
        logThread.start();
        System.out.println(Thread.currentThread().getName());
    }
}
