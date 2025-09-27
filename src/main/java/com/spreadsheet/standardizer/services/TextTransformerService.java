package com.spreadsheet.standardizer.services;

import com.spreadsheet.standardizer.interfaces.DataTransformer;

public class TextTransformerService implements DataTransformer {

    @Override
    public String removeAccents(String text) {
        if (text == null) return null;

        //Remove ALL control characters (0x00-0x1F and 0x7F-0x9F)
        text = text.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F]", "");

        //Remove Latin-1 Supplement characters (0x80-0xFF)
        text = text.replaceAll("[\\u0080-\\u00FF]", "");

        //Remove problematic Unicode blocks
        text = text.replaceAll("[\\u0100-\\u017F]", ""); // Latin Extended-A
        text = text.replaceAll("[\\u0180-\\u024F]", ""); // Latin Extended-B
        text = text.replaceAll("[\\u1E00-\\u1EFF]", ""); // Latin Extended Additional
        text = text.replaceAll("[\\u2000-\\u206F]", ""); // General Punctuation
        text = text.replaceAll("[\\u2070-\\u209F]", ""); // Superscripts and Subscripts
        text = text.replaceAll("[\\u20A0-\\u20CF]", ""); // Currency Symbols
        text = text.replaceAll("[\\u2100-\\u214F]", ""); // Letterlike Symbols
        text = text.replaceAll("[\\u2150-\\u218F]", ""); // Number Forms
        text = text.replaceAll("[\\u2190-\\u21FF]", ""); // Arrows
        text = text.replaceAll("[\\u2200-\\u22FF]", ""); // Mathematical Operators
        text = text.replaceAll("[\\u2300-\\u23FF]", ""); // Miscellaneous Technical
        text = text.replaceAll("[\\u2460-\\u24FF]", ""); // Enclosed Alphanumerics
        text = text.replaceAll("[\\u25A0-\\u25FF]", ""); // Geometric Shapes
        text = text.replaceAll("[\\u2600-\\u26FF]", ""); // Miscellaneous Symbols
        text = text.replaceAll("[\\u27C0-\\u27EF]", ""); // Miscellaneous Mathematical Symbols-A
        text = text.replaceAll("[\\u2980-\\u29FF]", ""); // Miscellaneous Mathematical Symbols-B
        text = text.replaceAll("[\\u2A00-\\u2AFF]", ""); // Supplemental Mathematical Operators

        //Remove anything above extended ASCII
        text = text.replaceAll("[^\\u0020-\\u007E\\u00A0-\\u00FF]", "");

        //Normalize spaces
        text = text.replaceAll("\\s+", " ").trim();

        return text;
    }

    @Override
    public String convertToUpperCase(String text) {
        if (text == null) return null;
        return text.toUpperCase();
    }

    @Override
    public String normalizeUtf8(String text) {
        if (text == null) return null;
        // Remove problematic UTF-8 special characters
        return text.replaceAll("[\\u0080-\\uFFFF]", "") // Remove extra spaces
                .replaceAll("\\s+", " ")
                .trim();
    }

    @Override
    public String processText(String text) {
        if (text == null) return text;

        String result = convertToUpperCase(text);
        result = convertToUpperCase(text);
        result = normalizeUtf8(text);

        return result;
    }
}

