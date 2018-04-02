package fr.diacono.validators.controls;

import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.function.Predicate;

class TimeControl extends ObjectControl {

    static Predicate<Temporal> isTimeSame(Temporal time) {
        return d -> isNotNull().test(d)
                && isNotNull().test(time)
                && LocalTime.from(d).compareTo(LocalTime.from(time)) == 0;
    }

    static Predicate<Temporal> isTimeLess(Temporal timeLess) {
        return d -> isNotNull().test(d)
                && isNotNull().test(timeLess)
                && LocalTime.from(d).compareTo(LocalTime.from(timeLess)) < 0;
    }

    static Predicate<Temporal> isTimeGreater(Temporal timeGreater) {
        return d -> isNotNull().test(d)
                && isNotNull().test(timeGreater)
                && LocalTime.from(d).compareTo(LocalTime.from(timeGreater)) > 0;
    }

    static Predicate<Temporal> isTimeBetween(Temporal timeLess, Temporal timeGreater) {
        return d -> (isTimeGreater(timeLess).test(d) || isTimeSame(timeLess).test(d))
                && (isTimeLess(timeGreater).test(d) || isTimeSame(timeGreater).test(d));
    }
}
