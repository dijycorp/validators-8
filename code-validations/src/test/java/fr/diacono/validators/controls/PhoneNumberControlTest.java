package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class PhoneNumberControlTest {

    @Test
    void should_not_check_the_phone_when_the_control_is_deactivated() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "phone is not fill");
        Control control = new PhoneNumberControl("01", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.activate(false).check();

        Assertions.assertFalse(error.isPresent());
    }

    @Test
    void should_not_check_the_phone_when_the_optional_control_is_deactivated_and_the_phone_is_valid_0102040506() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "phone is not fill");
        Control control = new PhoneNumberControl("0102030405", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.activate(false).check();

        Assertions.assertFalse(error.isPresent());
    }

    @Test
    void should_raise_an_error_when_the_phone_number_is_incorrect_and_the_control_is_activate() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "phone is not fill");
        Control control = new PhoneNumberControl("01", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.activate(true).check();

        Assertions.assertTrue(error.isPresent());
        Assertions.assertEquals(myErrorExpected, error.get());
    }
}
