package com.run.pojo;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @Author edxuanlen
 * @PROJECT questionnaire
 * @Date 2019/11/13 上午8:49
 * @Version 1.0
 **/

@Data
public class Questionnaire {
    private BigInteger id;
    private String name;
    private String qnDescribe;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String status;
}
