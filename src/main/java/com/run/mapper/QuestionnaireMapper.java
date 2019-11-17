package com.run.mapper;

import com.run.pojo.Questionnaire;
import org.apache.ibatis.annotations.Mapper;

import javax.swing.*;
import java.math.BigInteger;
import java.util.List;

/**
 * @Author edxuanlen
 * @PROJECT questionnaire
 * @Date 2019/11/13 上午10:52
 * @Version 1.0
 **/
@Mapper
public interface QuestionnaireMapper {

    /**
     * 通过问卷名称获取问卷实体
     * @param name
     * @return Questionnaire entity
     * @throws Exception
     */
    Questionnaire getQuestionnaireByName(String name) throws Exception;


    /**
     * 通过问卷编号获取问卷实体
     * @param id
     * @return Questionnaire entity
     * @throws Exception
     */
    Questionnaire getQuestionnaireById(BigInteger id) throws Exception;
    /**
     * 获取全部问卷信息
     * @return Questionnaire entity
     * @throws Exception
     */
    List<Questionnaire> getQuestionnaireAll() throws Exception;
    /**
     * 插入新的问卷
     * @param name
     * @return Integer
     * @throws Exception
     */
    Questionnaire insertQuestionnaire (String name) throws Exception;


}
