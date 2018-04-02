package fr.diacono.validators.controls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObjectControlTest {

    @Test
    void should_match_when_the_value_is_null() {
        Assertions.assertTrue(ObjectControl.isNull().test(null));
    }

    @Test
    void should_not_match_when_the_value_is_not_null() {
        Assertions.assertFalse(ObjectControl.isNull().test("a not null object"));
    }

    @Test
    void should_match_when_the_object_is_not_null() {
        Assertions.assertTrue(ObjectControl.isNotNull().test("a new string object"));
    }

    @Test
    void should_not_match_when_the_object_is_null() {
        Assertions.assertFalse(ObjectControl.isNotNull().test(null));
    }
}
