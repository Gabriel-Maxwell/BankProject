package br.com.maxwell.bank.utils;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatterUtils {

    public static String formatDateToString(LocalDateTime date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return date.format(fmt);
    }
}