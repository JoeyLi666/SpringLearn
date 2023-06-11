package cn.lsc.spring_mybatis.demo.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadMultipleSheets {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("D:\\workspaces\\spring_projecks\\SpringLearn\\java_demo_project\\src\\main\\resources\\excel\\神经网络模型性能度量.xlsx"));

            // 创建Workbook实例，对应于Excel文件
            Workbook workbook = new XSSFWorkbook(fileInputStream);

            // 获取工作表数量
            int numberOfSheets = workbook.getNumberOfSheets();

            // 遍历每个工作表
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);

                System.out.println("Reading sheet: " + sheet.getSheetName());

                // 遍历行
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();

                    // 遍历单元格
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        String cellValue = "";

                        // 根据单元格类型获取值
                        switch (cell.getCellType()) {
                            case STRING:
                                cellValue = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                cellValue = String.valueOf(cell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case FORMULA:
                                cellValue = cell.getCellFormula();
                                break;
                            default:
                                break;
                        }

                        System.out.print(cellValue + "\t");
                    }
                    System.out.println();
                }
            }

            workbook.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
