package com.spreadsheet.standardizer.interfaces;

import java.util.List;

public interface SpreadsheetHandler {
    List<List<String>> readSpreadsheet(String filePath);
    boolean writeSpreadsheet(String filePath, List<List<String>> data);
    int getRowCount();
    int getColumnCount();
}
