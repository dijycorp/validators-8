package fr.diacono.validators.controls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NullControlTest {

    @Test
    void should_match_when_the_value_is_null() {
        Assertions.assertTrue(ObjectControl.isNull().test(null));
    }

    @Test
    void should_not_match_when_the_value_is_not_null() {
        Assertions.assertFalse(ObjectControl.isNull().test("a not null object"));
    }
}
