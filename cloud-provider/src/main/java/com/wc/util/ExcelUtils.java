package com.wc.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author 王创
 * @Description Excel模板
 * @Date 10:40 2020/6/30
 **/
public class ExcelUtils {
    /**
     * @param file       文件
     * @param headerRows 忽略头行数
     * @param pojoClass  转换的实体
     * @return List<User>  返回的集合
     * @Title: importData
     * @Description: 导入excle 数据
     */
    public static <T> List<T> importData(MultipartFile file, Integer headerRows,
                                         Class<T> pojoClass) {
        if (file == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param list      导出的数据
     * @param title     文件标题
     * @param sheetName sheet名称
     * @param pojoClass 集合的类
     * @param fileName  文件名
     * @param response
     * @return void
     * @Title: exportExcel
     * @Description: 导出excel
     */
    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, HttpServletResponse response) {
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(title, sheetName), pojoClass, list);
        if (workbook != null) {
            try {
                response.setCharacterEncoding("UTF-8");
                response.setHeader("content-Type", "application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
                workbook.write(response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
