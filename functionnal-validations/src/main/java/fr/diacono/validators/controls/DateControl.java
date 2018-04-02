package fr.diacono.validators.controls;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.function.Predicate;

public class DateControl extends ObjectControl {

    public static Predicate<Temporal> isDateSame(Temporal dateSame) {
        return d -> isNotNull().test(d)
                && isNotNull().test(dateSame)
                && LocalDate.from(d).compareTo(LocalDate.from(dateSame)) == 0;
    }

    public static Predicate<Temporal> isSameLess(Temporal dateLess) {
        return d -> isNotNull().test(d)
                && isNotNull().test(dateLess)
                && LocalDate.from(d).compareTo(LocalDate.from(dateLess)) > 0;
    }

    public static Predicate<Temporal> isDateMore(Temporal dateMore) {
        return d -> isNotNull().test(d)
                && isNotNull().test(dateMore)
                && LocalDate.from(d).compareTo(LocalDate.from(dateMore)) < 0;
    }

    public static Predicate<Temporal> isDateBetween(Temporal dateLess, Temporal dateMore) {
        return d -> (isDateMore(dateLess).test(d) || isDateSame(dateLess).test(d))
                && (isSameLess(dateMore).test(d) || isDateSame(dateMore).test(d));
    }
}
