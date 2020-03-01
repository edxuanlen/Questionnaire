package com.run.utils;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Excel {

    static String pathName = "C:\\Users\\victor\\Documents\\";

    public boolean upload(MultipartFile file){
        String pname = file.getOriginalFilename();//获取文件名（包括后缀）
        pathName += pname;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(pathName);
            fos.write(file.getBytes()); // 写入文件
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

    public void read() throws IOException{
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\victor\\测试.xls"));
        //读取工作簿
        HSSFWorkbook workBook = new HSSFWorkbook(inputStream);
        //读取工作表
        HSSFSheet sheet = workBook.getSheetAt(0);
        //读取行
//        HSSFRow row = sheet.getRow(2);

        int rowCnt =  1;
        for (HSSFRow row = sheet.getRow(rowCnt); row.getCell(rowCnt) != null; rowCnt ++ ){
            row = sheet.getRow(rowCnt);
            String QuestionType = row.getCell(0).getStringCellValue();
            String QDescribe = row.getCell(1).getStringCellValue();

            System.out.println(QDescribe + QuestionType);
            int colCnt = 2;
            if ( !QuestionType.equals("主观题") ) {
                while ( row.getCell(colCnt) != null ){
                    String OpDescribe = row.getCell(colCnt).getStringCellValue();
                    System.out.println(OpDescribe);
                    colCnt ++;
                }
            }
            System.out.println();

        }

        inputStream.close();
        workBook.close();//最后记得关闭工作簿
    }
}
