package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class NullControlTest {

    @Test
    void null_value_should_raise_an_error_when_control_is_activated() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "not null not allow");
        Control control = new NullControl(null, myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.check();

        Assertions.assertFalse(error.isPresent());
    }

    @Test
    void not_null_value_should_raise_an_error_when_control_is_activated() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "not null not allow");
        Control control = new NullControl("", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.check();

        Assertions.assertTrue(error.isPresent());
    }

    @Test
    void not_null_value_should_not_raise_an_error_when_control_is_deactivated() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "not null not allow");
        Control control = new NullControl("", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.activate(false).check();

        Assertions.assertFalse(error.isPresent());
    }

    @Test
    void null_value_should_not_raise_an_error_when_control_is_deactivated() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "not null not allow");
        Control control = new NullControl(null, myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.check();

        Assertions.assertFalse(error.isPresent());
    }
}
