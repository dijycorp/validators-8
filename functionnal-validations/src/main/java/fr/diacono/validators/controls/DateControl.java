package fr.diacono.validators.controls;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.function.Predicate;

class DateControl extends ObjectControl {

    static Predicate<Temporal> isDateSame(Temporal dateSame) {
        return d -> isNotNull().test(d)
                && isNotNull().test(dateSame)
                && LocalDate.from(d).compareTo(LocalDate.from(dateSame)) == 0;
    }

    static Predicate<Temporal> isDateLess(Temporal dateLess) {
        return d -> isNotNull().test(d)
                && isNotNull().test(dateLess)
                && LocalDate.from(d).compareTo(LocalDate.from(dateLess)) < 0;
    }

    static Predicate<Temporal> isDateGreater(Temporal dateGreater) {
        return d -> isNotNull().test(d)
                && isNotNull().test(dateGreater)
                && LocalDate.from(d).compareTo(LocalDate.from(dateGreater)) > 0;
    }

    static Predicate<Temporal> isDateBetween(Temporal dateLess, Temporal dateGreater) {
        return d -> (isDateGreater(dateLess).test(d) || isDateSame(dateLess).test(d))
                && (isDateLess(dateGreater).test(d) || isDateSame(dateGreater).test(d));
    }
}
