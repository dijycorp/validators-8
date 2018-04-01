package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class FalseControlTest {
    @Test
    void should_raise_an_error_when_the_value_is_true() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "only false allow");
        Control control = new FalseControl(true, myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());
        Optional<MyError> error = control.check();

        Assertions.assertTrue(error.isPresent());
        Assertions.assertEquals(myErrorExpected, error.get());
    }

    @Test
    void should_not_raise_an_error_when_the_value_is_null() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "only false allow");
        Control control = new FalseControl(null, myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());
        Optional<MyError> error = control.check();

        Assertions.assertFalse(error.isPresent());
    }

    @Test
    void should_not_raise_an_error_when_the_value_is_false() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "only false allow");
        Control control = new FalseControl(false, myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());
        Optional<MyError> error = control.check();

        Assertions.assertFalse(error.isPresent());
    }
}
