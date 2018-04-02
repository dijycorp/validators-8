package fr.diacono.validators.controls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DateControlTest {

    private LocalDate localDate = LocalDate.of(2000, 12, 15);
    private LocalDate localDateLess = LocalDate.of(2000, 12, 1);
    private LocalDate localDateGreater = LocalDate.of(2000, 12, 31);

    @Test
    void should_match_when_the_date_is_same_as_given() {
        Assertions.assertTrue(DateControl.isDateSame(localDate).test(localDate));
    }

    @Test
    void should_match_when_the_date_given_is_less() {
        Assertions.assertTrue(DateControl.isDateLess(localDate).test(localDateLess));
    }

    @Test
    void should_match_when_the_date_given_is_greater() {
        Assertions.assertTrue(DateControl.isDateGreater(localDate).test(localDateGreater));
    }

    @Test
    void should_match_when_the_date_is_between() {
        Assertions.assertTrue(DateControl.isDateBetween(localDateLess, localDateGreater).test(localDate));
    }
}
