package com.run.pojo;

import lombok.Data;

import java.math.BigInteger;

/**
 * @author ruiyi
 * 问卷选项实体
 */
@Data
public class QuestionOption {
    private BigInteger opId;
    private String opDescribe;
    private BigInteger qId;
    private Integer selectedNum;
}

