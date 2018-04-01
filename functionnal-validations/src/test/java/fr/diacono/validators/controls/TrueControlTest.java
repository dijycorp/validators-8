package fr.diacono.validators.controls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrueControlTest {

    @Test
    void should_match_when_the_primitive_value_is_true() {
        Assertions.assertTrue(BooleanControl.isTrue().test(true));
    }

    @Test
    void should_match_when_the_Object_value_is_true() {
        Assertions.assertTrue(BooleanControl.isTrue().test(Boolean.TRUE));
    }

    @Test
    void should_not_match_when_the_primitive_value_is_false() {
        Assertions.assertFalse(BooleanControl.isTrue().test(false));
    }

    @Test
    void should_not_match_when_the_Object_value_is_false() {
        Assertions.assertFalse(BooleanControl.isTrue().test(Boolean.FALSE));
    }

    @Test
    void should_not_match_when_the_Object_value_is_null() {
        Assertions.assertFalse(BooleanControl.isTrue().test(null));
    }
}
