package fr.diacono.validators.controls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailControlTest {

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
