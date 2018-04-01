package fr.diacono.validators.controls;

import fr.diacono.validators.Validators;
import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;
import fr.diacono.validators.errors.MyErrors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class EmailControlTest {

    @Test
    void email_format_correctly_should_not_raise_an_error_when_is_not_active() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NEED, "email format is not correct or not fill");
        Control control = new EmailControl("abc@abc.com", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.activate(false).check();

        Assertions.assertFalse(error.isPresent());
    }

    @Test
    void email_format_correctly_should_not_raise_an_error() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NEED, "email format is not correct or not fill");
        Control control = new EmailControl("abc@abc.com", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.check();

        Assertions.assertFalse(error.isPresent());
    }

    @Test
    void email_not_format_correctly_should_raise_an_error() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NEED, "email format is not correct or not fill");
        Control control1 = new EmailControl("abcabc.com", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());
        Control control2 = new EmailControl("abc@abc@com", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());
        Control control3 = new EmailControl("abc", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());
        Control control4 = new EmailControl("abc.com", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        MyErrors myErrors = Validators.initialize().addControl(control1).addControl(control2).addControl(control3).addControl(control4).validate();

        Assertions.assertTrue(myErrors.containError(myErrorExpected));
        Assertions.assertTrue(myErrors.containError());
        Assertions.assertTrue(myErrors.containError(MyErrorLevel.NEED));
        Assertions.assertEquals(4, myErrors.getNumberOfErrors());
    }

    @Test
    void email_not_format_correctly_should_not_raise_an_error_when_is_deactivate() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NEED, "email format is not correct or not fill");
        Control control1 = new EmailControl("abcabc.com", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage()).activate(false);
        Control control2 = new EmailControl("abc@abc@com", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage()).activate(false);
        Control control3 = new EmailControl("abc", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage()).activate(false);
        Control control4 = new EmailControl("abc.com", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage()).activate(false);

        MyErrors myErrors = Validators.initialize()
                .addControl(control1)
                .addControl(control2)
                .addControl(control3)
                .addControl(control4)
                .validate();

        Assertions.assertFalse(myErrors.containError());
    }

    @Test
    void null_should_raise_an_error() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NEED, "email format is not correct or not fill");
        Control control = new EmailControl(null, myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.check();

        Assertions.assertTrue(error.isPresent());
    }

    @Test
    void null_should_not_raise_an_error_when_the_control_is_deactivate() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NEED, "email format is not correct or not fill");
        Control control = new EmailControl(null, myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control.activate(false).check();

        Assertions.assertFalse(error.isPresent());
    }
}
