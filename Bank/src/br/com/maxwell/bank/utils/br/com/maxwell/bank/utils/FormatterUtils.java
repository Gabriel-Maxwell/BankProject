package br.com.maxwell.bank.utils;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FormatterUtils {

    public static String formatValueToString(LocalDateTime date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return date.format(fmt);
    }

    public static String formatValueToString(double value) {
        DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0.00",dfs);
        return df.format(value);

    } 
}