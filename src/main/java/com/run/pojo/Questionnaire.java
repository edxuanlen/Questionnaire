package com.run.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message="问卷名称不能为空！")
    private String name;
    @NotEmpty(message="问卷描述不能为空！")
    private String qnDescribe;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String status;

    public void setId(String id) {
        this.id = BigInteger.valueOf(Long.parseLong(id));
    }

}
