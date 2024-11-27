package com.easy.excel;


import com.alibaba.excel.EasyExcelFactory;
import com.easy.util.CollUtils;

import java.io.File;
import java.io.InputStream;
import java.util.*;

/**
 * Excel导入导出工具类
 *
 * @author daimao
 * @date 2024/12/17
 */
@SuppressWarnings("all")
public class ExcelUtils {
    /**
     * 解析excel文件
     *
     * @param filePath 文件路径
     * @return 解析后的数据
     */
    public static List<Map<String, Object>> parseExcel(String filePath) {
        NoModeDataListener noModeDataListener = new NoModeDataListener();
        EasyExcelFactory.read(filePath, noModeDataListener).sheet().doRead();
        //获得解析后的内容
        return noModeDataListener.getDataList();
    }

    /**
     * 解析excel文件
     *
     * @param file 文件
     * @return 解析后的数据
     */
    public static List<Map<String, Object>> parseExcel(File file) {
        NoModeDataListener noModeDataListener = new NoModeDataListener();
        EasyExcelFactory.read(file, noModeDataListener).sheet().doRead();
        return noModeDataListener.getDataList();
    }

    /**
     * 解析excel文件
     *
     * @param inputStream 输入流
     * @return 解析后的数据
     */
    public static List<Map<String, Object>> parseExcel(InputStream inputStream) {
        NoModeDataListener noModeDataListener = new NoModeDataListener();
        EasyExcelFactory.read(inputStream, noModeDataListener).sheet().doRead();
        return noModeDataListener.getDataList();
    }

    /**
     * 写excel文件到本地
     *
     * @param data     表
     * @param filePath 文件路径
     */
    public static void writeExcel(List<Map<String, Object>> data, String filePath) {
        if (CollUtils.isEmpty(data)) {
            return;
        }
        Set<String> headKeys = data.get(0).keySet();
        //表头
        List<List<String>> head = new ArrayList<>();
        for (String headKey : headKeys) {
            head.add(Collections.singletonList(headKey));
        }
        //表格
        List<List<Object>> table = new ArrayList<>();
        data.forEach(row -> table.add(new ArrayList<>(row.values())));
        EasyExcelFactory.write(filePath)
                .head(head)
                .sheet()
                .doWrite(table);
    }

}