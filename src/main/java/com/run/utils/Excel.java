package com.run.utils;

import com.run.mapper.QuestionMapper;
import com.run.mapper.QuestionOptionMapper;
import com.run.pojo.Question;
import com.run.pojo.QuestionOption;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Excel相关操作
 * @author edxuanlen
 * @version 1.0
 */


public class Excel {

    private QuestionMapper questionMapper =
            SpringUtil.getBean(QuestionMapper.class);

    private QuestionOptionMapper questionOptionMapper =
            SpringUtil.getBean(QuestionOptionMapper.class);

    //  TODO 定义文件存放的根目录dir

    String pathName = "./temp/";
    static String filename = new String();
    /**
     * 上传文件
     * @param file 文件
     * @return 是否成功上传
     */
    public boolean upload(MultipartFile file){
        //获取文件名（包括后缀）
        String pname = file.getOriginalFilename();
        pathName += pname;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(pathName);
            filename = pathName;
            // 写入文件
            fos.write(file.getBytes());
            //System.out.println("文件上传成功");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 读取Excel表格中的数据
     * @param questionnaireId the id of new questionnaire
     * @throws IOException read 失败
     */

    public void read(BigInteger questionnaireId) throws Exception {
        FileInputStream inputStream = new FileInputStream(new File(filename));
        //读取工作簿
        HSSFWorkbook workBook = new HSSFWorkbook(inputStream);
        //读取工作表
        HSSFSheet sheet = workBook.getSheetAt(0);
        //读取行
//        HSSFRow row = sheet.getRow(2);

        int rowCnt =  1;
        for (HSSFRow row = sheet.getRow(rowCnt); row.getCell(rowCnt) != null; rowCnt ++ ){
            row = sheet.getRow(rowCnt);
            String questionType = row.getCell(0).getStringCellValue();
            String qDescribe = row.getCell(1).getStringCellValue();

            if ( !"主观题".equals(questionType) ) {
                if ("单选".equals(questionType)){
                    questionType = "radio";
                } else {
                    questionType = "checkbox";
                }
            } else {
                questionType = "subjective";
            }

            Question question = new Question(qDescribe, questionnaireId, questionType);
            System.out.println(question.toString());
            System.out.println(questionMapper);
            questionMapper.insertQuestion(question);
            BigInteger qId = question.getQId();

            int colCnt = 2;

            while ( row.getCell(colCnt) != null ){


                String opDescribe = row.getCell(colCnt).getStringCellValue();
                QuestionOption questionOption =
                        new QuestionOption(opDescribe, qId);

                questionOptionMapper.insertQuestionOption(questionOption);
                System.out.println(questionOption.toString());
                colCnt ++;
            }

            System.out.println();
        }

        inputStream.close();
        workBook.close();
    }
}
