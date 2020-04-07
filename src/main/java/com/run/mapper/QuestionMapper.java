package com.run.mapper;

import com.run.pojo.Question;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

/**
 * @author: edxuanlen
 * @date: 2020-04-07 15:37
 * @version 1.0
 **/
@Mapper
public interface QuestionMapper {

    /**
     * 插入一个问题
     * @param question 问题
     * @return 返回插入的id
     * @throws Exception 查询异常
     */
    Integer insertQuestion(Question question) throws Exception;

}
