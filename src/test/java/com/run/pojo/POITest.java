//package com.run.pojo;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.CellType;
//import org.junit.Test;
//
//public class POITest {
//    @Test
//    public void writeExcel03() throws IOException{
//        //创建工作簿
//        HSSFWorkbook workBook = new HSSFWorkbook();
//        //创建工作表  工作表的名字叫helloWorld
//        HSSFSheet sheet = workBook.createSheet("helloWorld");
//        //创建行,第3行
//        HSSFRow row = sheet.createRow(2);
//        //创建单元格，操作第三行第三列
//        HSSFCell cell = row.createCell(2, CellType.STRING);
//        cell.setCellValue("helloWorld");
//
//        workBook.write(new File("C:\\Users\\victor\\测试.xls"));
//
//        workBook.close();//最后记得关闭工作簿
//    }
//
//    @Test
//    public void readExcel03() throws IOException{
//        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\victor\\测试.xls"));
//        //读取工作簿
//        HSSFWorkbook workBook = new HSSFWorkbook(inputStream);
//        //读取工作表
//        HSSFSheet sheet = workBook.getSheetAt(0);
//        //读取行
////        HSSFRow row = sheet.getRow(2);
//
//        int rowCnt =  1;
//        for ( HSSFRow row = sheet.getRow(rowCnt); row.getCell(rowCnt) != null; rowCnt ++ ){
//            row = sheet.getRow(rowCnt);
//            String QuestionType = row.getCell(0).getStringCellValue();
//            String QDescribe = row.getCell(1).getStringCellValue();
//
////            System.out.println(QDescribe + QuestionType);
//            int colCnt = 2;
//            if ( !QuestionType.equals("主观题") ) {
//                while ( row.getCell(colCnt) != null ){
//                    String OpDescribe = row.getCell(colCnt).getStringCellValue();
//                        
////                    System.out.println(OpDescribe);
//                    colCnt ++;
//                }
//            }
//            System.out.println();
//
//        }
//
//        //读取单元格
////        HSSFCell cell = row.getCell(2);
////        String value = cell.getStringCellValue();
//
////        System.out.println(value);
//
//        inputStream.close();
//        workBook.close();//最后记得关闭工作簿
//    }
//}