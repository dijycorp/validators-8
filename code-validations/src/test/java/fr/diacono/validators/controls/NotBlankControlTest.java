package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class NotBlankControlTest {

    @Test
    void string_blank_should_raise_an_error() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NEED, "blank is not allow");
        Control control = new NotBlankControl("", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.check();

        Assertions.assertTrue(error.isPresent());
        Assertions.assertEquals(myErrorExpected, error.get());
    }

    @Test
    void string_blank_should_not_raise_an_error_when_the_control_is_deactivate() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NEED, "blank is not allow");
        Control control = new NotBlankControl("", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.activate(false).check();

        Assertions.assertFalse(error.isPresent());
    }

    @Test
    void null_should_raise_an_error() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NEED, "null is not allow");
        Control control = new NotBlankControl(null, myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.check();

        Assertions.assertTrue(error.isPresent());
        Assertions.assertEquals(myErrorExpected, error.get());
    }

    @Test
    void null_should_not_raise_an_error_when_the_control_is_deactivate() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NEED, "null is not allow");
        Control control = new NotBlankControl(null, myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.activate(false).check();

        Assertions.assertFalse(error.isPresent());
    }
}