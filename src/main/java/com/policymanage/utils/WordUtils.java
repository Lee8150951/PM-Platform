package com.policymanage.utils;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WordUtils {
    /**
     * 读取文档中表格
     * @param filePath
     */
    public static void parseWord(String filePath) throws Exception {
        Iterator<XWPFTable> it = getWordContent(filePath);
        while(it.hasNext()){
            XWPFTable table = it.next();
            List<XWPFTableRow> rows = table.getRows();
            //读取每一行数据
            for (int i = 0; i < rows.size(); i++) {
                XWPFTableRow row = rows.get(i);
                //读取每一列数据
                List<XWPFTableCell> cells = row.getTableCells();
                for (int j = 0; j < cells.size(); j++) {
                    XWPFTableCell cell = cells.get(j);
                    //输出当前的单元格的数据
                    System.out.print(cell.getText() + "\t");
                }
                System.out.println();
            }
        }
    }

    public static List<String> completeWordParse(String filePath) throws Exception {
        Iterator<XWPFTable> it = getWordContent(filePath);
        List<String> list = new ArrayList<>();
        while(it.hasNext()){
            XWPFTable table = it.next();
            List<XWPFTableRow> rows = table.getRows();
            // 企业名称
            list.add(getRowText(rows, 0, 1));
            // 企业法人
            list.add(getRowText(rows, 0, 3));
            // 联系电话
            list.add(getRowText(rows, 0, 5));
            // 企业类型
            list.add(getRowText(rows, 1, 1));
            // 企业类地址
            list.add(getRowText(rows, 1, 3));
            // 申请政策
            list.add(getRowText(rows, 2, 1));
            // 扶持金额
            list.add(getRowText(rows, 2, 3));
            // 实施时间
            list.add(getRowText(rows, 3, 1));
            // 完成时间
            list.add(getRowText(rows, 3, 3));
            // 工作内容
            list.add(getRowText(rows, 5, 0));
            // 完成情况
            list.add(getRowText(rows, 6, 1));
            // 项目经理人
            list.add(getRowText(rows, 6, 3));
            // 备注
            list.add(getRowText(rows, 8, 0));
        }
        return list;
    }

    /**
     * 读取表格内容
     * @param filePath
     * @return
     * @throws Exception
     */
    public static Iterator<XWPFTable> getWordContent(String filePath) throws Exception {
        // 载入文档
        FileInputStream in = new FileInputStream(filePath);
        // 处理docx格式, 得到word文档的信息
        XWPFDocument xwpf = new XWPFDocument(in);
        //得到word中的表格并输出
        return xwpf.getTablesIterator();
    }

    /**
     * 获取单元格内容
     * @param rows
     * @param i 行
     * @param j 列
     * @return
     */
    public static String getRowText(List<XWPFTableRow> rows, Integer i, Integer j) {
        XWPFTableRow row = rows.get(i);
        List<XWPFTableCell> cells = row.getTableCells();
        XWPFTableCell content = cells.get(j);
        return content.getText();
    }
}
