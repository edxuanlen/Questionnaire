package com.run.mapper;

import com.run.pojo.Question;
import com.run.pojo.QuestionOption;
import com.run.pojo.Questionnaire;
import org.apache.ibatis.annotations.Mapper;

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
     * 通过问卷编号获取问卷实体
     * @param id questionnaire id
     * @return Questionnaire entity
     * @throws Exception error
     */
    Questionnaire getQuestionnaireById(BigInteger id) throws Exception;
    /**
     * 获取全部问卷信息
     * @return Questionnaire entity
     * @throws Exception error
     */
    List<Questionnaire> getQuestionnaireAll() throws Exception;
    /**
     * 插入新的问卷
     * @param questionnaire questionnaire
     * @return Integer questionnaire insert id
     * @throws Exception error
     */
    Integer insertQuestionnaire (Questionnaire questionnaire) throws Exception;
    /**
     * 插入新的问卷
     * @return List
     * @param id questionnaire id
     * @throws Exception error
     */
    List<Question> getAllQuestions(BigInteger id) throws Exception;

    /**
     * 根据问题id获取问题选项
     * @param qId question id
     * @return List<QuestionOption>:
     * @throws Exception error
     */
    List<QuestionOption> getQuestionOptionById(BigInteger qId) throws Exception;

    // TODO 更新Option


    // TODO 更新Question Describe

    boolean updateOfQuestionDescribeById(BigInteger qId, String qDescribe) throws Exception;


    // TODO 有必要添加更改题目type



    

}
