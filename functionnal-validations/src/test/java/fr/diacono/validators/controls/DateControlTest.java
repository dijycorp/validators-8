package fr.diacono.validators.controls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DateControlTest {

    private LocalDate localDate = LocalDate.of(2000, 12, 15);
    private LocalDate localDateLess = LocalDate.of(2000, 12, 1);
    private LocalDate localDateMore = LocalDate.of(2000, 12, 31);

    @Test
    void should_match_when_the_date_is_same_as_given() {
        Assertions.assertTrue(TemporalDateControl.isSameDate(localDate).test(localDate));
    }

    @Test
    void should_match_when_the_date_given_is_less() {
        Assertions.assertTrue(TemporalDateControl.isLess(localDateLess).test(localDate));
    }

    @Test
    void should_match_when_the_date_given_is_more() {
        Assertions.assertTrue(TemporalDateControl.isMore(localDateMore).test(localDate));
    }

    @Test
    void should_match_when_the_date_is_between() {
        Assertions.assertTrue(TemporalDateControl.isBetween(localDateLess, localDateMore).test(localDate));
    }
}
