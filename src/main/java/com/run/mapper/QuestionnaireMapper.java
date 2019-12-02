package com.run.mapper;

import com.run.pojo.Question;
import com.run.pojo.QuestionOption;
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
     * @param questionnaire
     * @return Integer
     * @throws Exception
     */
    void insertQuestionnaire (Questionnaire questionnaire) throws Exception;
    /**
     * 插入新的问卷
     * @return List
     * @throws Exception
     * @param id
     */
    List<Question> getAllQuestions(BigInteger id) throws Exception;

    /**
     * 根据问题id获取问题选项
     * @param qId
     * @return List<QuestionOption>
     * @throws Exception
     */
    List<QuestionOption> getQuestionOptionById(BigInteger qId) throws Exception;
}
