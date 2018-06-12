package com.baizhi.test;

import com.baizhi.entity.Picture;
import com.baizhi.poi.PictureAnnoation;
import com.baizhi.poi.User;
import com.baizhi.poi.UserAnnoation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/6/4.
 */
public class TestP {
   /* private Field[] getD;*/

    @Test
    public void test(){
     /*   Class<User> userClass = User.class;
        Field[] fields = userClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String name = field.getName();
            String type = field.getGenericType().toString();
            System.out.println(name);
            System.out.println(type);
        }*/
    }


    @Test
    public void test4(){
       /* List<Picture> pictures = new ArrayList<Picture>();
        ArrayList list = new ArrayList();
        //将文件读入
        Workbook workbook = null;
        try {
            workbook = new HSSFWorkbook(new FileInputStream("g:/图片.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取工作簿中的表
        Sheet sheet = workbook.getSheet("图片表");

        //获取表中的第一行数据
        Row row  = sheet.getRow(0);
        //获取第一行中所有的单元格   将单元格数据添加到list      编号    名称。。。
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            Cell cell = row.getCell(i);
            list.add(cell);
        }

        //获取自定义注解
        String[] titles = new String[6];
        String[] name = new String[6];
        String[] type = new String[6];
        Class<Picture> pictureClass = Picture.class;
        Field[] fields = pictureClass.getDeclaredFields();
        for (int j = 0; j < fields.length; j++) {
            Field field = fields[j];  //获取属性（类型+名）
            PictureAnnoation annotation = field.getAnnotation(PictureAnnoation.class);
            String aname = annotation.name();
            titles[j] = aname;
            name[j]=field.getName();//获取属性名
            type[j] = field.getGenericType().toString(); //获取属性类型
        }


        for (int m = 0; m < list.size(); m++) {   //标题
            for(int n=0; n < titles.length; n++){  //注解
                System.out.println(list.get(0).equals(titles[0]));
                System.out.print(list.get(0));
                System.out.print(titles[0]);
                if(list.get(m).equals(titles[n])){   //注解=标题

                    //获取属性名
                    String methodName1 = "set" + name[m].substring(0, 1).toUpperCase() + name[m].substring(1);


                    //遍历表中的数据(排除标题行  从下标1开始)
                    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                        Picture p = new Picture();
                        //获取每行的数据
                        Row row1 = sheet.getRow(i);
                        //获取单元格的数据
                        Cell cell = row.getCell(i);
                        if(cell instanceof Number){
                            double numericCellValue = cell.getNumericCellValue();
                        }else if(cell instanceof Date){
                            Date dateCellValue = cell.getDateCellValue();
                        }else{
                            String stringCellValue = cell.getStringCellValue();
                        }
                        try {
                            pictureClass.getDeclaredMethod(methodName1,null).invoke(p,null);
                            pictures.add(p);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                }

            }

        }

        for (Picture p : pictures) {
            System.out.println(p);
        }*/

    }


    @Test
    public void test2(){
     /*   String[] titles = new String[4];
        Class<User> userClass = User.class;
        Field[] declaredFields = userClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            UserAnnoation annotation = declaredField.getAnnotation(UserAnnoation.class);
            String name = annotation.name();
            titles[i] = name;
        }

        for (int i = 0; i < titles.length; i++) {
            String title = titles[i];
            System.out.println(title);

        }*/
    }


    @Test
    public void test1(){
       /* //将文件读入
        Workbook workbook = null;
        try {
            workbook = new HSSFWorkbook(new FileInputStream("g:/图片.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取工作簿中的表
        Sheet sheet = workbook.getSheet("图片表");

        //获取表中的第一行数据
        Row row  = sheet.getRow(0);

        String s="";

        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                Cell cell = row.getCell(i);
                s = s+cell;

        }
*/


    }

}
