package com.spreadsheet.standardizer.services;

import com.spreadsheet.standardizer.interfaces.SpreadsheetHandler;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelHandleService implements SpreadsheetHandler {

    private int rowCount;
    private int columnCount;


    @Override
    public List<List<String>> readSpreadsheet(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook workbook = null;

            if(filePath.endsWith(".xlsx")){
                workbook = new XSSFWorkbook(fileInputStream);
            }else if(filePath.endsWith(".xls")){
                workbook = new HSSFWorkbook(fileInputStream);
            }
            Sheet sheet = workbook.getSheetAt(0);
            List<List<String>> allData = new ArrayList<>();

            this.rowCount = sheet.getPhysicalNumberOfRows();
            this.columnCount = 0;

            for (int i = 0; i < rowCount; i++){
                Row row = sheet.getRow(i);
                List<String> rowsData = new ArrayList<>();

                if(row != null){
                    int cellCount = row.getLastCellNum();
                    if(cellCount > this.columnCount){
                        this.columnCount = cellCount;
                        }
                    }
                allData.add(rowsData);
            }


        } catch (IOException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public boolean writeSpreadsheet(String filePath, List<List<String>> data) {
        return false;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }
}
