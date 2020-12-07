package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelHelper {

    private final static Logger LOG = LogManager.getLogger("Обработчик Excel файлов");

    // todo Test in class SomeTest
    public static List<String> readColumnFromExcelFile(String path, int columnIndex) {
        List<String> result = new ArrayList<>();
        try {
            Workbook file = new XSSFWorkbook(path);
            Sheet sheet = file.getSheet("Лист1");
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(columnIndex);
                result.add(cell.getStringCellValue());
            }
        } catch (IOException e) {
            LOG.error(e);
        }
        return result;
    }

    // todo Test in class SomeTest
    public static List<Object[]> readDataFromExcelFile(String path, String sheetName){
        List<Object[]> result = new ArrayList<>();
        try {
            Workbook file = new XSSFWorkbook(path);
            Sheet sheet = file.getSheet(sheetName);
            LOG.info("Начинаем считывать данные из Excel файла:");
            for(int i = 0; i < sheet.getLastRowNum()+1; i++){
                LOG.debug("считываем рядок №" + i);
                Row row = sheet.getRow(i);
                String[] testData= new String[2];
                List<String> labels = new ArrayList<>();
                LOG.debug("Считываем ячейки из ряда:");
                for (int a = 0; a < row.getLastCellNum(); a++){
                    LOG.debug("считываем ячейку №" + a);
                    Cell cell = row.getCell(a);
                    if (a == 0/* || a == 1*/) {
                        LOG.debug("Ячейка №" + a + ": Название Issue");
                        testData[a]=cell.getStringCellValue();
                    }
                    else if (a == 1){
                        LOG.debug("Ячейка №" + a + ": Текст Issue");
                        testData[a]=cell.getStringCellValue();
                    }
                    else {
                        LOG.debug("Ячейка №" + a + ": Лейбл " + cell.getStringCellValue());
                        labels.add(cell.getStringCellValue());
                    }
                }
                LOG.debug("Добавляем результат");
                result.add(new Object[]{testData[0], testData[1], labels});
            }
        } catch (IOException e) {
            LOG.error(e);
        }
        LOG.debug("Заканчиваем считывание");
        return result;
    }

    // todo Test in class SomeTest
    public static void writeToExcelFile(String path, List<String> data, String sheetName, int columnIndex) {
        try {
            Workbook file = new XSSFWorkbook(path); // copy existing file

            Sheet sheet = file.createSheet(sheetName);
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(0);
                cell.setCellValue(data.get(i));
            }
            file.write(
                    new FileOutputStream(
                            new File(
                                    "C:\\Users\\Admin\\IdeaProjects\\G46Automation\\src\\test\\resources\\data\\out.xlsx")));
            file.close();
        } catch (IOException e) {
            LOG.error(e);
        }
    }
}