package com.lm.tobacco;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.lm.tobacco.model.Employee;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// @RunWith(SpringRunner.class)
// @SpringBootTest
public class TobaccoApplicationTests {

  public static void main(String[] args) throws Exception {
    // toExcelEasy();
    toExcelPoi();
  }

  public static void setCellValue(
      Workbook wb, Row row, int cellIndex, String fontName, int fontSize, String cellContent) {
    Font font = wb.createFont();
    font.setFontName(fontName);
    font.setFontHeightInPoints((short) fontSize);

    CellStyle cellStyle = wb.createCellStyle();
    // cellStyle.setWrapText(true);// 换行
    cellStyle.setFont(font);
    cellStyle.setAlignment(HorizontalAlignment.CENTER);

    Cell cell = row.createCell(cellIndex);
    cell.setCellValue(cellContent);
    cell.setCellStyle(cellStyle);
  }

  public static void toExcelEasy() throws IOException {

    List<Employee> list = new ArrayList<>();
    list.add(
        new Employee(
            "wangwu",
            "1233213112123",
            32,
            new Date(),
            "13212344321",
            "guji",
            "bumen",
            "leibie",
            "gangwei",
            new Date()));
    ExportParams exportParams = new ExportParams();
    // exportParams.setSheetName("名单");
    Workbook workbook = ExcelExportUtil.exportExcel(exportParams, Employee.class, list);

    FileOutputStream output = new FileOutputStream("E:\\员工表.xls");
    workbook.write(output);
    output.flush();
    output.close();
  }

  public static void toExcelPoi() throws Exception {
    // 获取d://test.xls
    FileInputStream fs = new FileInputStream("E:\\人员签到 - 副本.xlsx");
    // 使用POI提供的方法得到excel的信息
    Workbook wb = new XSSFWorkbook(fs);
    // POIFSFileSystem ps=new POIFSFileSystem(fs);

    // HSSFWorkbook wb = new HSSFWorkbook(ps);
    // 获取到工作表，因为一个excel可能有多个工作表
    Sheet sheet = wb.getSheetAt(0);
    // 获取第4行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即，字段列头，便于赋值
    Row row = sheet.getRow(3);

    // 分别得到最后一行的行号，和一条记录的最后一个单元格
    System.out.println(sheet.getLastRowNum() + " " + row.getLastCellNum());

    // 向d://test.xls中写数据
    FileOutputStream out = new FileOutputStream("E://人员签到 - 副本.xlsx");
    // 在现有行号后追加数据
    row = sheet.createRow((short) (sheet.getLastRowNum() + 1));

    // 设置第一个（从0开始）单元格的数据
    setCellValue(wb, row, 0, "宋体", 11, "张三");

    // 设置第二个（从0开始）单元格的数据
    setCellValue(wb, row, 1, "宋体", 11, "|");
    out.flush();
    wb.write(out);
    out.close();
    System.out.println(row.getPhysicalNumberOfCells() + " " + row.getLastCellNum());
  }
}
