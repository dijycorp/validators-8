package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class PatternControlTest {

    @Test
    void should_raise_an_error_when_the_pattern_is_null() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "pattern is null");
        Control control = new PatternControl("value", null, myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());
        Optional<MyError> error = control.check();

        Assertions.assertTrue(error.isPresent());
    }

    @Test
    void should_raise_an_error_when_the_pattern_not_match() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "pattern is null");
        Control control = new PatternControl("value", "\\d{5}", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());
        Optional<MyError> error = control.check();

        Assertions.assertTrue(error.isPresent());
    }

    @Test
    void should_not_raise_an_error_when_the_pattern_match_with_the_value() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "pattern is null");
        Control control = new PatternControl("value", "[value]", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());
        Optional<MyError> error = control.check();

        Assertions.assertFalse(error.isPresent());
    }
}
