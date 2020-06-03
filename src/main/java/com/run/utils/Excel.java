package com.run.utils;

import com.run.mapper.QuestionMapper;
import com.run.mapper.QuestionOptionMapper;
import com.run.mapper.QuestionnaireMapper;
import com.run.pojo.Question;
import com.run.pojo.QuestionOption;
import io.swagger.annotations.Api;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

/**
 * Excel相关操作
 * @author edxuanlen
 * @version 1.0
 */

//@Component
public class Excel {

//    @Resource
//    private QuestionnaireMapper questionnaireMapper;
//
//    @Autowired
//    private QuestionMapper questionMapper;
//
//    @Autowired
//    private QuestionOptionMapper questionOptionMapper;

    private QuestionnaireMapper questionnaireMapper =
            SpringUtil.getBean(QuestionnaireMapper.class);

    private QuestionMapper questionMapper =
            SpringUtil.getBean(QuestionMapper.class);

    private QuestionOptionMapper questionOptionMapper =
            SpringUtil.getBean(QuestionOptionMapper.class);

    //  TODO 定义文件存放的根目录dir
//    String pathName = "./temp/";

    String pathName = "/tmp/";

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
        int RowNum = sheet.getLastRowNum();
        HSSFRow row = sheet.getRow(rowCnt);
//        for ( ; row.getCell(rowCnt) != null; rowCnt ++ ){
            for ( ; rowCnt <= RowNum; rowCnt ++ ){
            row = sheet.getRow(rowCnt);
            System.out.println(rowCnt);
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

    
    public HSSFWorkbook export(BigInteger id) throws Exception{
        List<Question> questions = questionnaireMapper.getAllQuestions(id);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();

        Sheet sheet = hssfWorkbook.createSheet(questionnaireMapper.getQuestionnaireById(id).getName());

        int col = 0;

        for (Question question: questions){

            if(question.getQuestionType().equals("subjective")) {
                continue;
            }

            BigInteger qId = question.getQId();

            List<QuestionOption> questionOptions = questionOptionMapper.getAllQuestionOptionsByQuestionId(qId);

            String questionDescribe = question.getQDescribe();

            Row row = sheet.createRow(col);
            col = col + 1;
            row.createCell(0).setCellValue(questionDescribe);

            for (QuestionOption questionOption: questionOptions){

                String opDescribe = questionOption.getOpDescribe();
                String opSelected = String.valueOf(questionOption.getSelectedNum());

                row = sheet.createRow(col);
                col = col + 1;
                row.createCell(0).setCellValue(opDescribe);
                row.createCell(1).setCellValue(opSelected);
//                System.out.println(opDescribe + ": " + opSelected);
            }

        }

        return hssfWorkbook;
    }

}
