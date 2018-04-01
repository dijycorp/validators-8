package fr.diacono.validators.controls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class NumberControlTest {

    @Test
    void should_match_when_the_given_number_is_less_then_expected() {
        Assertions.assertTrue(NumberControl.isLess(10).test(9));
        Assertions.assertTrue(NumberControl.isLess(10.00000d).test(9.99999d));
        Assertions.assertTrue(NumberControl.isLess(10.00f).test(9.00f));
        Assertions.assertTrue(NumberControl.isLess(BigDecimal.valueOf(10)).test(BigDecimal.valueOf(9.9999999999)));
        Assertions.assertTrue(NumberControl.isLess(Short.valueOf("10")).test(Short.valueOf("9")));
        Assertions.assertTrue(NumberControl.isLess(Byte.valueOf("10")).test(Byte.valueOf("9")));
    }

    @Test
    void should_match_when_the_given_number_is_more_has_expected() {
        Assertions.assertTrue(NumberControl.isMore(10).test(11));
        Assertions.assertTrue(NumberControl.isMore(10.00000d).test(10.000001d));
        Assertions.assertTrue(NumberControl.isMore(10.00f).test(10.01f));
        Assertions.assertTrue(NumberControl.isMore(BigDecimal.valueOf(10)).test(BigDecimal.valueOf(10.00000000001)));
        Assertions.assertTrue(NumberControl.isMore(Short.valueOf("10")).test(Short.valueOf("11")));
        Assertions.assertTrue(NumberControl.isMore(Byte.valueOf("10")).test(Byte.valueOf("11")));
    }

    @Test
    void should_match_when_the_given_number_is_same_has_expected() {
        Assertions.assertTrue(NumberControl.isSame(10).test(10));
        Assertions.assertTrue(NumberControl.isSame(10.00000d).test(10.00000d));
        Assertions.assertTrue(NumberControl.isSame(10.00f).test(10.00f));
        Assertions.assertTrue(NumberControl.isSame(BigDecimal.valueOf(10)).test(BigDecimal.valueOf(10.0000000000)));
        Assertions.assertTrue(NumberControl.isSame(Short.valueOf("10")).test(Short.valueOf("10")));
        Assertions.assertTrue(NumberControl.isSame(Byte.valueOf("10")).test(Byte.valueOf("10")));
    }

    @Test
    void should_match_when_then_given_numbers_are_between_has_expected() {
        Assertions.assertTrue(NumberControl.isBetween(10, 12).test(12));
        Assertions.assertTrue(NumberControl.isBetween(10.00000d, 10.00002d).test(10.00001d));
        Assertions.assertTrue(NumberControl.isBetween(10.00f, 10.02f).test(10.01f));
        Assertions.assertTrue(NumberControl.isBetween(BigDecimal.valueOf(10), BigDecimal.valueOf(11)).test(BigDecimal.valueOf(10.0000000001)));
        Assertions.assertTrue(NumberControl.isBetween(Short.valueOf("10"), Short.valueOf("12")).test(Short.valueOf("11")));
        Assertions.assertTrue(NumberControl.isBetween(Byte.valueOf("10"), Byte.valueOf("11")).test(Byte.valueOf("10")));
    }
}
