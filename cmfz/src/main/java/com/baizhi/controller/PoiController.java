package com.baizhi.controller;

import com.baizhi.entity.Picture;
import com.baizhi.entity.User;
import com.baizhi.poi.PictureAnnoation;
import com.baizhi.poi.UserAnnoation;
import com.baizhi.service.PictureService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/6/4.
 */
//自定义导入、导出数据
@Controller
@RequestMapping("/poi")
public class PoiController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/customerExport")
    @ResponseBody
    public void customerExport(String titles, String fields, HttpServletResponse response){

        //标题行
        String[] title = titles.split(",");  //中文标题行
        String[] allfield = fields.split(",");  //英文标题行

        //建工作簿
        Workbook workbook = new HSSFWorkbook();

        //建工作表
        Sheet sheet = workbook.createSheet("工作表");

        //建标题行  下标从0开始
        Row row = sheet.createRow(0);

        //转日期格式（String---->）
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy-MM-dd");
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);

        //填充标题行
        for (int i = 0; i < title.length; i++) {
            String s = title[i];//得到标题行的各个属性
            //建单元格
            Cell cell = row.createCell(i);
            cell.setCellValue(s);
        }

        //数据行
        List<Picture> pictures = pictureService.findAll();

        //拿到每个picture对象
        for (int i = 0; i < pictures.size(); i++) {
            //填充每行数据
            Row dataRow = sheet.createRow(i + 1);//要去掉标题行（从下标1开始）
            //遍历填充每个对象（每行）的每个属性
            for (int j = 0; j < allfield.length; j++) {
                //创建单元格
                Cell cell = dataRow.createCell(j);
                //反射   获得Picture类对象
                Class<? extends Picture> pictureClass = pictures.get(i).getClass();
                //获得每个属性的get方法名（反射）
                String methodName = "get" + allfield[j].substring(0, 1).toUpperCase() + allfield[j].substring(1);
                //运行get方法(并得到方法的返回值)

                try {
                    Object invoke = pictureClass.getDeclaredMethod(methodName, null).invoke(pictures.get(i), null);

                    //判断这个属性是否是日期类型，如果是转格式
                    if( invoke instanceof Date){
                        sheet.setColumnWidth(j,18*256);//调列宽   进制256
                        cell.setCellStyle(cellStyle);//单元格添加日期样式
                        cell.setCellValue((Date) invoke);//将object---->Date
                    }else{
                        //如果不是日期格式    object---->String
                        cell.setCellValue(invoke.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        //将数据写入到文件中
        String name="图片自定义导出的数据.xls";
        String fileName="";

        //设置响应头   响应类型
        try {
            fileName = new String(name.getBytes("UTF-8"), "ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        response.setHeader("content-disposition","attachment;fileName="+fileName);
        response.setContentType("application/vnd.ms-excel");  //excel格式（tomcat的web.xml中可以找到）

        try {
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping("/inport")
    @ResponseBody
    public void inport() throws IOException {
        ArrayList<Picture> ps = new ArrayList<Picture>();
        Workbook workbook = new HSSFWorkbook(new FileInputStream("g:/图片.xls"));
        Sheet sheet = workbook.getSheet("图片表");
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Picture picture = new Picture();
            Row row = sheet.getRow(i);

            Cell cell = row.getCell(0);
            Integer numericCellValue =(int) cell.getNumericCellValue();
            picture.setId(numericCellValue);

            Cell cell1 = row.getCell(1);
            String stringCellValue = cell1.getStringCellValue();
            picture.setTitle(stringCellValue);

            Cell cell2 = row.getCell(2);
            String stringCellValue1 = cell2.getStringCellValue();
            picture.setImgPath(stringCellValue1);

            Cell cell3 = row.getCell(3);
            String stringCellValue2 = cell3.getStringCellValue();
            picture.setPdesc(stringCellValue2);

            Cell cell4 = row.getCell(4);
            String stringCellValue3 = cell4.getStringCellValue();
            picture.setStatus(stringCellValue3);

            Cell cell5 = row.getCell(5);
            Date dateCellValue = cell5.getDateCellValue();
            picture.setPdate(dateCellValue);

            ps.add(picture);

        }

        for (Picture p : ps) {
            System.out.println(p);
        }

    }
}
