package fr.diacono.validators.controls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FalseControlTest {

    @Test
    void should_match_when_the_primitive_value_is_false() {
        Assertions.assertTrue(BooleanControl.isFalse().test(false));
    }

    @Test
    void should_not_match_when_the_primitive_value_is_true() {
        Assertions.assertFalse(BooleanControl.isFalse().test(true));
    }

    @Test
    void should_match_when_the_Object_value_is_true() {
        Assertions.assertFalse(BooleanControl.isFalse().test(Boolean.TRUE));
    }

    @Test
    void should_not_match_when_the_primitive_Object_is_false() {
        Assertions.assertTrue(BooleanControl.isFalse().test(Boolean.FALSE));
    }

    @Test
    void should_match_when_the_primitive_Object_is_null() {
        Assertions.assertTrue(BooleanControl.isFalse().test(null));
    }
}