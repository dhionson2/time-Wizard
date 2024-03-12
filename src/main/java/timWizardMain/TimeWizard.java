package timWizardMain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeWizard {
	
	 // Formato padr�o ISO 8601 para data
    private static final DateTimeFormatter ISO_DATE_FORMATTER = DateTimeFormatter.ISO_DATE;

    // Formato padr�o ISO 8601 para hora
    private static final DateTimeFormatter ISO_TIME_FORMATTER = DateTimeFormatter.ISO_TIME;

    // Adicionar dias a uma data
    public static LocalDate addDays(LocalDate date, long daysToAdd) {
        return date.plusDays(daysToAdd);
    }

    // Subtrair dias de uma data
    public static LocalDate subtractDays(LocalDate date, long daysToSubtract) {
        return date.minusDays(daysToSubtract);
    }

    // Adicionar horas a uma hora espec�fica
    public static LocalTime addHours(LocalTime time, long hoursToAdd) {
        return time.plusHours(hoursToAdd);
    }

    // Subtrair horas de uma hora espec�fica
    public static LocalTime subtractHours(LocalTime time, long hoursToSubtract) {
        return time.minusHours(hoursToSubtract);
    }

    // Adicionar meses a uma data
    public static LocalDate addMonths(LocalDate date, long monthsToAdd) {
        return date.plusMonths(monthsToAdd);
    }

    // Subtrair meses de uma data
    public static LocalDate subtractMonths(LocalDate date, long monthsToSubtract) {
        return date.minusMonths(monthsToSubtract);
    }

    // Adicionar anos a uma data
    public static LocalDate addYears(LocalDate date, long yearsToAdd) {
        return date.plusYears(yearsToAdd);
    }

    // Subtrair anos de uma data
    public static LocalDate subtractYears(LocalDate date, long yearsToSubtract) {
        return date.minusYears(yearsToSubtract);
    }

    // Verificar se uma data � anterior a outra
    public static boolean isDateBefore(LocalDate date1, LocalDate date2) {
        return date1.isBefore(date2);
    }

    // Verificar se uma data � posterior a outra
    public static boolean isDateAfter(LocalDate date1, LocalDate date2) {
        return date1.isAfter(date2);
    }

    // Verificar se duas datas s�o iguais
    public static boolean areDatesEqual(LocalDate date1, LocalDate date2) {
        return date1.isEqual(date2);
    }

    // Verificar se uma hora � anterior a outra
    public static boolean isTimeBefore(LocalTime time1, LocalTime time2) {
        return time1.isBefore(time2);
    }

    // Verificar se uma hora � posterior a outra
    public static boolean isTimeAfter(LocalTime time1, LocalTime time2) {
        return time1.isAfter(time2);
    }

    // Verificar se duas horas s�o iguais
    public static boolean areTimesEqual(LocalTime time1, LocalTime time2) {
        return time1.equals(time2);
    }
    
    // Converter uma data de formato ISO 8601 para um formato personalizado
    public static String convertDateFromISOToCustom(String isoDate, String customFormat) {
        LocalDate date = LocalDate.parse(isoDate, ISO_DATE_FORMATTER);
        return date.format(DateTimeFormatter.ofPattern(customFormat));
    }

    // Converter uma data de um formato personalizado para ISO 8601
    public static String convertDateFromCustomToISO(String customDate, String customFormat) {
        LocalDate date = LocalDate.parse(customDate, DateTimeFormatter.ofPattern(customFormat));
        return date.format(ISO_DATE_FORMATTER);
    }

    // Converter uma hora de formato ISO 8601 para um formato personalizado
    public static String convertTimeFromISOToCustom(String isoTime, String customFormat) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(customFormat);
            LocalTime time = LocalTime.parse(isoTime, ISO_TIME_FORMATTER);
            return time.format(formatter);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Formato de hora inv�lido", isoTime, 0, e);
        }
    }





    // Converter uma hora de um formato personalizado para ISO 8601
    public static String convertTimeFromCustomToISO(String customTime, String customFormat) {
        LocalTime time = LocalTime.parse(customTime, DateTimeFormatter.ofPattern(customFormat));
        return time.format(ISO_TIME_FORMATTER);
    }
    
    // Calcular idade com base na data de nascimento
    public static int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}
