package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class NotNullValidatorsTest {

    @Test
    void should_not_raise_an_error_when_the_value_is_null_and_the_validator_is_deactivate() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "null is acceptable");
        Control control = new NotNullControl(null, myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.activate(false).check();

        Assertions.assertFalse(error.isPresent());
    }

    @Test
    void should_raise_an_error_when_the_value_is_null() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "null is acceptable");
        Control control = new NotNullControl(null, myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.check();

        Assertions.assertTrue(error.isPresent());
    }

    @Test
    void should_not_raise_an_error_when_the_value_is_not_null() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "null is acceptable");
        Control control = new NotNullControl("", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.check();

        Assertions.assertFalse(error.isPresent());
    }
}
