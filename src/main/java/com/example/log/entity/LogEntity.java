package com.example.log.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xs
 * @description 日志实体
 */
@Data
public class LogEntity implements Serializable {
    /**
     * 反序列Id
     */
    private static final long serialVersionUID = 1L;
    /**
     * 日志级别
     */
    private String level;
    /**
     * 数据
     */
    private String data;
}
