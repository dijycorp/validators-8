package fr.diacono.validators.controls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringControlTest {

    @Test
    void should_match_when_is_contain_the_string_given() {
        Assertions.assertTrue(StringControl.isContains("jeremie").test("jeremie"));
    }

    @Test
    void should_not_match_when_is_not_contains_the_string_given() {
        Assertions.assertFalse(StringControl.isContains("jeremie").test("pas jeremie"));
    }

    @Test
    void should_not_match_as_contains_when_the_string_given_is_null() {
        Assertions.assertFalse(StringControl.isContains(null).test("pas jeremie"));
    }

    @Test
    void should_not_match_as_contains_when_the_string_to_compare_is_null() {
        Assertions.assertFalse(StringControl.isContains("jeremie").test(null));
    }

    @Test
    void should_match_as_same_when_the_strings_are_same() {
        Assertions.assertTrue(StringControl.isSame("jeremie").test("jeremie"));
        Assertions.assertTrue(StringControl.isSame(null).test(null));
    }

    @Test
    void should_not_match_as_same_when_the_string_given_is_null() {
        Assertions.assertFalse(StringControl.isSame(null).test("pas jeremie"));
    }

    @Test
    void should_not_match_as_same_when_the_string_to_compare_is_null() {
        Assertions.assertFalse(StringControl.isSame("jeremie").test(null));
    }

    @Test
    void should_match_when_the_string_given_is_before() {
        Assertions.assertTrue(StringControl.isBefore("jeremie").test("alain"));
    }

    @Test
    void should_match_when_the_string_given_is_after() {
        Assertions.assertTrue(StringControl.isAfter("jeremie").test("xavier"));
    }

    @Test
    void should_match_when_the_string_given_is_between() {
        Assertions.assertTrue(StringControl.isBetween("daniel", "jeremie").test("geremie"));
    }

    @Test
    void should_match_when_the_string_is_not_blank() {
        Assertions.assertTrue(StringControl.isNotBlank().test("a not blank value"));
    }

    @Test
    void should_not_match_when_the_string_is_blank() {
        Assertions.assertFalse(StringControl.isNotBlank().test(""));
    }

    @Test
    void should_not_match_when_the_string_is_null() {
        Assertions.assertFalse(StringControl.isNotBlank().test(null));
    }

    @Test
    void should_match_when_the_email_is_valid() {
        Assertions.assertTrue(StringControl.isAnEmail().test("jeremie@diacono.fr"));
    }

    @Test
    void should_not_match_when_the_email_is_not_valid() {
        Assertions.assertFalse(StringControl.isAnEmail().test("jeremie"));
    }

    @Test
    void should_not_match_when_the_value_is_null() {
        Assertions.assertFalse(StringControl.isAnEmail().test(null));
    }

}
