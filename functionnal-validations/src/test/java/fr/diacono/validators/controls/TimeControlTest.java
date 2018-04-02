package fr.diacono.validators.controls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class TimeControlTest {

    private LocalTime localTime = LocalTime.of(11, 0, 0);
    private LocalTime localTimeLess = LocalTime.of(10, 0, 0);
    private LocalTime localTimeGreater = LocalTime.of(12, 0, 0);

    @Test
    void should_match_when_the_date_is_same_as_given() {
        Assertions.assertTrue(TimeControl.isTimeSame(localTime).test(localTime));
    }

    @Test
    void should_match_when_the_date_given_is_less() {
        Assertions.assertTrue(TimeControl.isTimeLess(localTime).test(localTimeLess));
    }

    @Test
    void should_match_when_the_date_given_is_greater() {
        Assertions.assertTrue(TimeControl.isTimeGreater(localTime).test(localTimeGreater));
    }

    @Test
    void should_match_when_the_date_is_between() {
        Assertions.assertTrue(TimeControl.isTimeBetween(localTimeLess, localTimeGreater).test(localTime));
    }
}
