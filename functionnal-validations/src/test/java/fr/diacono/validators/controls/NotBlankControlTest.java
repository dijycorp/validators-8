package fr.diacono.validators.controls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NotBlankControlTest {

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
}
