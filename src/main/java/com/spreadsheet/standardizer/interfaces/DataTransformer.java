package com.spreadsheet.standardizer.interfaces;

public interface DataTransformer {
    String removeAccents(String text);
    String convertToUpperCase(String text);
    String normalizeUtf8(String text);
    String processText(String text);
}
