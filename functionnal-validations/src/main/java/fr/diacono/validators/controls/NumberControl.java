package fr.diacono.validators.controls;

import java.math.BigDecimal;
import java.util.function.Predicate;

/*
 * Is possible has some value not match well (infinity/nan)
 */
public class NumberControl extends ObjectControl {

    public static Predicate<Number> isLess(Number lessNumber) {
        return n -> isNotNull().test(lessNumber)
                && isNotNull().test(n)
                && new BigDecimal(n.toString()).compareTo(new BigDecimal(lessNumber.toString())) < 0;

    }

    public static Predicate<Number> isMore(Number moreNumber) {
        return n -> isNotNull().test(moreNumber)
                && isNotNull().test(n)
                && new BigDecimal(n.toString()).compareTo(new BigDecimal(moreNumber.toString())) > 0;
    }

    public static Predicate<Number> isSame(Number sameNumber) {
        return n -> isNotNull().test(sameNumber)
                && isNotNull().test(n)
                && new BigDecimal(n.toString()).compareTo(new BigDecimal(sameNumber.toString())) == 0;
    }

    public static Predicate<Number> isBetween(Number lessNumber, Number moreNumber) {
        return n -> (isLess(moreNumber).test(n) || isSame(moreNumber).test(n))
                && (isMore(lessNumber).test(n) || isSame(lessNumber).test(n));
    }
}
