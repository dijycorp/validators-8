package fr.diacono.validators.controls;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.function.Predicate;

public class TemporalDateControl extends ObjectControl {

    public static Predicate<Temporal> isSameDate(Temporal dateSame) {
        return d -> isNotNull().test(d)
                && isNotNull().test(dateSame)
                && LocalDate.from(d).compareTo(LocalDate.from(dateSame)) == 0;
    }

    public static Predicate<Temporal> isLess(Temporal dateLess) {
        return d -> isNotNull().test(d)
                && isNotNull().test(dateLess)
                && LocalDate.from(d).compareTo(LocalDate.from(dateLess)) > 0;
    }

    public static Predicate<Temporal> isMore(Temporal dateMore) {
        return d -> isNotNull().test(d)
                && isNotNull().test(dateMore)
                && LocalDate.from(d).compareTo(LocalDate.from(dateMore)) < 0;
    }

    public static Predicate<Temporal> isBetween(Temporal dateLess, Temporal dateMore) {
        return d -> (isMore(dateLess).test(d) || isSameDate(dateLess).test(d))
                && (isLess(dateMore).test(d) || isSameDate(dateMore).test(d));
    }
}
