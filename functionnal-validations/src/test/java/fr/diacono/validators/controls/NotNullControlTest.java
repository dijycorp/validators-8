package fr.diacono.validators.controls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NotNullControlTest {

    @Test
    void should_match_when_the_object_is_not_null() {
        Assertions.assertTrue(ObjectControl.isNotNull().test("a new string object"));
    }

    @Test
    void should_not_match_when_the_object_is_null() {
        Assertions.assertFalse(ObjectControl.isNotNull().test(null));
    }
}
