package com.run.mapper;

import com.run.pojo.Questionnaire;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

/**
 * @Author edxuanlen
 * @PROJECT questionnaire
 * @Date 2019/11/13 上午10:52
 * @Version 1.0
 **/
@Mapper
public interface QuestionnaireMapper {

    /**
     * @param name
     * @return Questionnaire entity
     * 通过问卷名称获取问卷实体
     */

    Questionnaire getQuestionnaireByName(String name);
    Questionnaire getQuestionnaireById(BigInteger id);






}
