package com.baizhi.poi;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */

public class POIExport {
    @Test
    public void export() throws IOException {
        Workbook workbook = new HSSFWorkbook();

        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd日");


        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setDataFormat(format);
        Sheet sheet = workbook.createSheet("第一个");
        String[] titles = new String[4];
        Class<User> userClass = User.class;
        Field[] declaredFields = userClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            UserAnnoation annotation = declaredField.getAnnotation(UserAnnoation.class);
            String name = annotation.name();
            titles[i] = name;
        }
        Row row = sheet.createRow(0);
        sheet.setColumnWidth(3, 18 * 256);
        for (int i = 0; i < titles.length; i++) {
            String title = titles[i];
            Cell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(title);
        }
//      数据库操作
        List<User> users = Arrays.asList(new User(0, "小黑0", "1234560", new Date()), new User(1, "小黑1", "1234561", new Date()), new User(2, "小黑2", "1234562", new Date()), new User(3, "小黑3", "1234563", new Date()), new User(4, "小黑4", "1234564", new Date()));
        for (int i = 0; i < users.size(); i++) {
            Row dataRow = sheet.createRow(i + 1);
            Cell cell = dataRow.createCell(0);
            cell.setCellValue(users.get(i).getId());
            Cell cell1 = dataRow.createCell(1);
            cell1.setCellValue(users.get(i).getName());
            Cell cell2 = dataRow.createCell(2);
            cell2.setCellValue(users.get(i).getPassword());
            Cell cell3 = dataRow.createCell(3);
            cell3.setCellStyle(cellStyle);
            cell3.setCellValue(users.get(i).getDate());

        }


        workbook.write(new FileOutputStream(new File("f:/用户.xls")));

    }

    @Test
    public void importUser() throws IOException {
        List<User> users = new ArrayList<User>();
        Workbook workbook = new HSSFWorkbook(new FileInputStream("f:/用户.xls"));
        Sheet sheet = workbook.getSheet("第一个");
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            User user = new User();
            Row row = sheet.getRow(i);

            Cell cell = row.getCell(0);
            Integer numericCellValue = (int) cell.getNumericCellValue();
            user.setId(numericCellValue);


            Cell cell1 = row.getCell(1);
            String stringCellValue1 = cell1.getStringCellValue();
            user.setName(stringCellValue1);


            Cell cell2 = row.getCell(2);
            String stringCellValue2 = cell2.getStringCellValue();
            user.setPassword(stringCellValue2);


            Cell cell3 = row.getCell(3);
            Date date1 = cell3.getDateCellValue();
            user.setDate(date1);
            users.add(user);
        }

        for (User user : users) {
            System.out.println(user);
        }


    }
}
