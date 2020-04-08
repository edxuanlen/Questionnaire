package com.run.mapper;

import com.run.pojo.QuestionOption;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

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


}
