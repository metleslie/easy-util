package com.easy.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.util.ConverterUtils;
import com.easy.util.StrUtils;
import lombok.Getter;

import java.util.*;

/**
 *
 * @author daimao
 * @date 2024/11/27
 */
public class NoModeDataListener extends AnalysisEventListener<Map<String, String>> {

    /**
     * -- GETTER --
     * 获得表格数据
     */
    @Getter
    private final List<Map<String, Object>> dataList = new ArrayList<>();
    private Map<Integer, String> head = null;

    @Override
    public void invoke(Map<String, String> data, AnalysisContext context) {
        // 这里可以获取到每行的数据，data是一个Map，key是列名，value是单元格值
        Map<String, Object> rowMap = new LinkedHashMap<>();
        for (Object key : data.keySet()) {
            String headValue = head.get(key);
            if (StrUtils.isNotBlank(headValue)){
                rowMap.put(headValue, data.get(key));
                rowMap.remove(key);
            }
        }
        dataList.add(rowMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 所有数据解析完成后的回调，可以在这里做后续处理
    }

    /**
     * 这里会一行行的返回头
     *
     * @param headMap 表头
     * @param context S上下文
     */
    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        this.head = ConverterUtils.convertToStringMap(headMap, context);
    }

}