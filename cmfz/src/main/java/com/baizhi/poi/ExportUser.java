package com.baizhi.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2018/6/4.
 */
public class ExportUser {
    public static void main(String[] args) throws IOException {
        //创建execle文件
        Workbook workbook = new HSSFWorkbook();

        /*
        * 时间格式的调整
        *
        * */
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd日");
        /*
        * 样式调节
        *
        * */
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);
        //调节字体
        Font font = workbook.createFont();
        font.setColor(Font.COLOR_RED);
        cellStyle.setFont(font);
        //居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 创建工作表
        Sheet sheet = workbook.createSheet("第一个");

        /*第一个参数是第几列  第二个参数列宽  进制256*/
        sheet.setColumnWidth(0, 7680);
        //创建行   下标从0开始
        Row row = sheet.createRow(0);
        //创建单元格
        Cell cell = row.createCell(0);
        cell.setCellStyle(cellStyle);
        //填充单元格内容
        cell.setCellValue(new Date());
        workbook.write(new FileOutputStream(new File("f:/第一个.xls")));

    }

}
