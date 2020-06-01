package com.run.mapper;

import com.run.pojo.QuestionOption;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

/**
 * @author: edxuanlen
 * @date: 2020-04-07 17:09
 * @version: 1.0
 **/
@Mapper
public interface SubjectiveQuestionAnswerMapper {


    /**
     * 主观题回答的答案
     * @param qId question id
     * @param content answer
     * @return insert status
     * @throws Exception insert Error
     */
    boolean insertNewSubjectiveQuestionAnswer(BigInteger qId,
                                           String content) throws Exception;


    /**
     * delete Subjective Question answer bu question id
     * @param qId question id
     * @throws Exception error
     */
    void deleteSubjectiveQuestionAnswerByQuestionId(BigInteger qId) throws Exception;

    List<String> getSubjectiveQuestionAnswerByQuestionId(BigInteger qId) throws Exception;
}
