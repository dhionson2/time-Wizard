package timWizardTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;

import timWizardMain.TimeWizard;

public class TimeWizardTest {

    @Test
    public void testAddDays() {
        LocalDate date = LocalDate.of(2024, 3, 12);
        LocalDate expectedDate = LocalDate.of(2024, 3, 17); // Adicionando 5 dias
        assertEquals(expectedDate, TimeWizard.addDays(date, 5));
    }

    @Test
    public void testSubtractDays() {
        LocalDate date = LocalDate.of(2024, 3, 12);
        LocalDate expectedDate = LocalDate.of(2024, 3, 7); // Subtraindo 5 dias
        assertEquals(expectedDate, TimeWizard.subtractDays(date, 5));
    }
    
    @Test
    public void testAddHours() {
        LocalTime time = LocalTime.of(10, 30);
        LocalTime expectedTime = LocalTime.of(15, 30); // Adicionando 5 horas
        assertEquals(expectedTime, TimeWizard.addHours(time, 5));
    }

    @Test
    public void testSubtractHours() {
        LocalTime time = LocalTime.of(10, 30);
        LocalTime expectedTime = LocalTime.of(5, 30); // Subtraindo 5 horas
        assertEquals(expectedTime, TimeWizard.subtractHours(time, 5));
    }

    @Test
    public void testAddMonths() {
        LocalDate date = LocalDate.of(2024, 3, 12);
        LocalDate expectedDate = LocalDate.of(2024, 8, 12); // Adicionando 5 meses
        assertEquals(expectedDate, TimeWizard.addMonths(date, 5));
    }

    @Test
    public void testSubtractMonths() {
        LocalDate date = LocalDate.of(2024, 3, 12);
        LocalDate expectedDate = LocalDate.of(2023, 10, 12); // Subtraindo 5 meses
        assertEquals(expectedDate, TimeWizard.subtractMonths(date, 5));
    }

    @Test
    public void testAddYears() {
        LocalDate date = LocalDate.of(2024, 3, 12);
        LocalDate expectedDate = LocalDate.of(2034, 3, 12); // Adicionando 10 anos
        assertEquals(expectedDate, TimeWizard.addYears(date, 10));
    }

    @Test
    public void testSubtractYears() {
        LocalDate date = LocalDate.of(2024, 3, 12);
        LocalDate expectedDate = LocalDate.of(2014, 3, 12); // Subtraindo 10 anos
        assertEquals(expectedDate, TimeWizard.subtractYears(date, 10));
    }

    @Test
    public void testCalculateAge() {
        LocalDate birthDate = LocalDate.of(1990, 5, 15); // Data de nascimento
        int expectedAge = 33; // Idade esperada com base na data de nascimento
        assertEquals(expectedAge, TimeWizard.calculateAge(birthDate));
    }
    
    @Test
    public void testConvertTimeFromCustomToISO_ValidInput() {
        String customTime = "10:30:45";
        String customFormat = "HH:mm:ss";
        String expectedISOTime = "10:30:45"; // Resultado esperado em formato ISO 8601
        assertEquals(expectedISOTime, TimeWizard.convertTimeFromCustomToISO(customTime, customFormat));
    }

    @Test
    public void testConvertTimeFromCustomToISO_InvalidFormat() {
        final String customTime = "10:30"; // Formato inv�lido, n�o inclui segundos
        final String customFormat = "HH:mm:ss";
        assertThrows(DateTimeParseException.class, () -> {
            TimeWizard.convertTimeFromCustomToISO(customTime, customFormat);
        });
    }

    @Test
    public void testConvertTimeFromCustomToISO_NullInput() {
        String customTime = null;
        String customFormat = "HH:mm:ss";
        assertThrows(NullPointerException.class, () -> {
            TimeWizard.convertTimeFromCustomToISO(customTime, customFormat);
        });
    }

    @Test
    public void testConvertTimeFromCustomToISO_EmptyInput() {
        String customTime = "";
        String customFormat = "HH:mm:ss";
        assertThrows(DateTimeParseException.class, () -> {
            TimeWizard.convertTimeFromCustomToISO(customTime, customFormat);
        });
    }
    
    @Test
    public void testConvertTimeFromISOToCustom_ValidInput() {
        String isoTime = "10:30:45";
        String customFormat = "HH:mm:ss";
        String expectedCustomTime = "10:30:45"; // Resultado esperado no formato personalizado
        assertEquals(expectedCustomTime, TimeWizard.convertTimeFromISOToCustom(isoTime, customFormat));
    }

    @Test
    public void testConvertTimeFromISOToCustom_NullInput() {
        String isoTime = null;
        String customFormat = "HH:mm:ss";
        assertThrows(NullPointerException.class, () -> {
            TimeWizard.convertTimeFromISOToCustom(isoTime, customFormat);
        });
    }

    @Test
    public void testConvertTimeFromISOToCustom_EmptyInput() {
        String isoTime = "";
        String customFormat = "HH:mm:ss";
        assertThrows(DateTimeParseException.class, () -> {
            TimeWizard.convertTimeFromISOToCustom(isoTime, customFormat);
        });
    }
    
    @Test
    public void testConvertDateFromCustomToISO_ValidInput() {
        String customDate = "2024-03-12";
        String customFormat = "yyyy-MM-dd";
        String expectedISODate = "2024-03-12";
        assertEquals(expectedISODate, TimeWizard.convertDateFromCustomToISO(customDate, customFormat));
    }

    @Test
    public void testConvertDateFromCustomToISO_InvalidFormat() {
        String customDate = "12/03/2024"; // Formato inv�lido, diferente do padr�o especificado
        String customFormat = "yyyy-MM-dd"; // Formato ISO 8601 esperado
        assertThrows(DateTimeParseException.class, () -> {
            TimeWizard.convertDateFromCustomToISO(customDate, customFormat);
        });
    }

    @Test
    public void testConvertDateFromCustomToISO_NullInput() {
        String customDate = null;
        String customFormat = "yyyy-MM-dd";
        assertThrows(NullPointerException.class, () -> {
            TimeWizard.convertDateFromCustomToISO(customDate, customFormat);
        });
    }

    @Test
    public void testConvertDateFromCustomToISO_EmptyInput() {
        String customDate = "";
        String customFormat = "yyyy-MM-dd";
        assertThrows(DateTimeParseException.class, () -> {
            TimeWizard.convertDateFromCustomToISO(customDate, customFormat);
        });
    }
    
    @Test
    public void testConvertDateFromISOToCustom_ValidInput() {
        String isoDate = "2024-03-12";
        String customFormat = "dd/MM/yyyy";
        String expectedCustomDate = "12/03/2024";
        assertEquals(expectedCustomDate, TimeWizard.convertDateFromISOToCustom(isoDate, customFormat));
    }

    @Test
    public void testConvertDateFromISOToCustom_InvalidFormat() {
        String isoDate = "2024/03/12"; // Formato inv�lido, diferente do padr�o ISO 8601
        String customFormat = "dd/MM/yyyy";
        assertThrows(DateTimeParseException.class, () -> {
            TimeWizard.convertDateFromISOToCustom(isoDate, customFormat);
        });
    }

    @Test
    public void testConvertDateFromISOToCustom_NullInput() {
        String isoDate = null;
        String customFormat = "dd/MM/yyyy";
        assertThrows(NullPointerException.class, () -> {
            TimeWizard.convertDateFromISOToCustom(isoDate, customFormat);
        });
    }

    @Test
    public void testConvertDateFromISOToCustom_EmptyInput() {
        String isoDate = "";
        String customFormat = "dd/MM/yyyy";
        assertThrows(DateTimeParseException.class, () -> {
            TimeWizard.convertDateFromISOToCustom(isoDate, customFormat);
        });
    }
    
    @Test
    public void testAreTimesEqual_EqualTimes() {
        LocalTime time1 = LocalTime.of(10, 30);
        LocalTime time2 = LocalTime.of(10, 30);
        assertTrue(TimeWizard.areTimesEqual(time1, time2));
    }

    @Test
    public void testAreTimesEqual_DifferentTimes() {
        LocalTime time1 = LocalTime.of(10, 30);
        LocalTime time2 = LocalTime.of(11, 45);
        assertFalse(TimeWizard.areTimesEqual(time1, time2));
    }
    
    @Test
    public void testIsTimeAfter_Time1AfterTime2() {
        LocalTime time1 = LocalTime.of(12, 30);
        LocalTime time2 = LocalTime.of(10, 30);
        assertTrue(TimeWizard.isTimeAfter(time1, time2));
    }

    @Test
    public void testIsTimeAfter_Time1BeforeTime2() {
        LocalTime time1 = LocalTime.of(8, 30);
        LocalTime time2 = LocalTime.of(10, 30);
        assertFalse(TimeWizard.isTimeAfter(time1, time2));
    }

    @Test
    public void testIsTimeAfter_Time1EqualsTime2() {
        LocalTime time1 = LocalTime.of(10, 30);
        LocalTime time2 = LocalTime.of(10, 30);
        assertFalse(TimeWizard.isTimeAfter(time1, time2));
    }
    
    @Test
    public void testIsTimeBefore_Time1BeforeTime2() {
        LocalTime time1 = LocalTime.of(8, 30);
        LocalTime time2 = LocalTime.of(10, 30);
        assertTrue(TimeWizard.isTimeBefore(time1, time2));
    }

    @Test
    public void testIsTimeBefore_Time1AfterTime2() {
        LocalTime time1 = LocalTime.of(12, 30);
        LocalTime time2 = LocalTime.of(10, 30);
        assertFalse(TimeWizard.isTimeBefore(time1, time2));
    }

    @Test
    public void testIsTimeBefore_Time1EqualsTime2() {
        LocalTime time1 = LocalTime.of(10, 30);
        LocalTime time2 = LocalTime.of(10, 30);
        assertFalse(TimeWizard.isTimeBefore(time1, time2));
    }
    
    @Test
    public void testIsDateAfter_Date1AfterDate2() {
        LocalDate date1 = LocalDate.of(2024, 3, 15);
        LocalDate date2 = LocalDate.of(2024, 3, 12);
        assertTrue(TimeWizard.isDateAfter(date1, date2));
    }

    @Test
    public void testIsDateAfter_Date1BeforeDate2() {
        LocalDate date1 = LocalDate.of(2024, 3, 10);
        LocalDate date2 = LocalDate.of(2024, 3, 12);
        assertFalse(TimeWizard.isDateAfter(date1, date2));
    }

    @Test
    public void testIsDateAfter_Date1EqualsDate2() {
        LocalDate date1 = LocalDate.of(2024, 3, 12);
        LocalDate date2 = LocalDate.of(2024, 3, 12);
        assertFalse(TimeWizard.isDateAfter(date1, date2));
    }

    @Test
    public void testAreDatesEqual_DatesEqual() {
        LocalDate date1 = LocalDate.of(2024, 3, 12);
        LocalDate date2 = LocalDate.of(2024, 3, 12);
        assertTrue(TimeWizard.areDatesEqual(date1, date2));
    }

    @Test
    public void testAreDatesEqual_DatesNotEqual() {
        LocalDate date1 = LocalDate.of(2024, 3, 12);
        LocalDate date2 = LocalDate.of(2024, 3, 15);
        assertFalse(TimeWizard.areDatesEqual(date1, date2));
    }
    
    @Test
    public void testIsDateBefore_Date1BeforeDate2() {
        LocalDate date1 = LocalDate.of(2024, 3, 10);
        LocalDate date2 = LocalDate.of(2024, 3, 12);
        assertTrue(TimeWizard.isDateBefore(date1, date2));
    }

    @Test
    public void testIsDateBefore_Date1AfterDate2() {
        LocalDate date1 = LocalDate.of(2024, 3, 15);
        LocalDate date2 = LocalDate.of(2024, 3, 12);
        assertFalse(TimeWizard.isDateBefore(date1, date2));
    }

    @Test
    public void testIsDateBefore_Date1EqualsDate2() {
        LocalDate date1 = LocalDate.of(2024, 3, 12);
        LocalDate date2 = LocalDate.of(2024, 3, 12);
        assertFalse(TimeWizard.isDateBefore(date1, date2));
    }
}
