package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class NotZeroControlTest {

    @Test
    void zero_should_raise_an_error() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NEED, "zero not allow");
        Control control = new NotZeroControl(0, myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());
        Optional<MyError> error = control.check();
        Assertions.assertTrue(error.isPresent());
        Assertions.assertEquals(myErrorExpected, error.get());
    }

    @Test
    void zero_should_not_raise_an_error_when_the_control_is_deactivate() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NEED, "zero not allow");
        Control control = new NotZeroControl(0, myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());
        Optional<MyError> error = control.activate(false).check();
        Assertions.assertFalse(error.isPresent());
    }

    @Test
    void null_should_not_raise_an_error() {
        Control control = new NotZeroControl(null, MyErrorLevel.NEED, "null is allow");
        Optional<MyError> error = control.check();
        Assertions.assertFalse(error.isPresent());
    }

    @Test
    void null_should_not_raise_an_error_when_the_control_is_deactivate() {
        Control control = new NotZeroControl(null, MyErrorLevel.NEED, "null is allow");
        Optional<MyError> error = control.activate(false).check();
        Assertions.assertFalse(error.isPresent());
    }
}
