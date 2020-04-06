package com.run.utils;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Stream;

public class Excel {

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
     * @throws IOException
     */
    public void read(Integer questionnaireId) throws IOException{
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


            int colCnt = 2;
            if ( !questionType.equals("主观题") ) {
                if (questionType.equals("单选")){
                    questionType = "radio";
                } else {
                    questionType = "checkbox";
                }

                // insert qDescribe questionType where id = questionnaireId



                while ( row.getCell(colCnt) != null ){
                    String OpDescribe = row.getCell(colCnt).getStringCellValue();
                    System.out.println(OpDescribe);
                    colCnt ++;
                }
            } else {
                questionType = "subjective";
            }

            System.out.println();

        }

        inputStream.close();
        workBook.close();
    }
}
