package com.spreadsheet.standardizer.interfaces;

public interface FileProcessor {
    boolean loadFile(String filePath);
    boolean saveFile(String filePath);
    String getFileExtension(String fileName);
}