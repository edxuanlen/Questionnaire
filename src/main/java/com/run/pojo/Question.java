package com.run.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;

/**
 * @author ruiyi
 * 问卷实体
 */
@Data
public class Question {
    private BigInteger qId;
//    @NotEmpty(message="问题描述不能为空！")
    private String qDescribe;
    private BigInteger id;
    private String questionType;

    public Question(String qDescribe, BigInteger id,
                    String questionType) {
        this.qDescribe = qDescribe;
        this.id = id;
        this.questionType = questionType;
    }

    public Question(){}
}
