package fr.diacono.validators.controls;

import fr.diacono.validators.Validators;
import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;
import fr.diacono.validators.errors.MyErrors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class ZipCodeControlTest {

    @Test
    void should_raise_an_error_when_the_code_not_match_pattern_of_zip_code_as_five_digit() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "is not five chart");
        Control control1 = new ZipCodeFrenchControl("4444", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());
        Control control2 = new ZipCodeFrenchControl("666666", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        MyErrors myErrors = Validators.initialize()
                .addControl(control1)
                .addControl(control2)
                .validate();

        Assertions.assertEquals(2, myErrors.getNumberOfErrors());
        Assertions.assertTrue(myErrors.containError());
        Assertions.assertTrue(myErrors.containError(myErrorExpected));
    }

    @Test
    void should_not_raise_an_error_when_the_code_not_match_pattern_of_zip_code_as_five_digit_when_the_control_is_deactivate() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "is not five chart");
        Control control1 = new ZipCodeFrenchControl("4444", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        Optional<MyError> error = control1.activate(false).check();

        Assertions.assertFalse(error.isPresent());
    }

    @Test
    void should_not_raise_an_error_when_the_code_match_pattern_of_zip_code_as_five_digit() {
        MyError myErrorExpected = new MyError(MyErrorLevel.NO_NEED, "is not five chart");
        Control control1 = new ZipCodeFrenchControl("55555", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());
        Control control2 = new ZipCodeFrenchControl("12345", myErrorExpected.getMyErrorLevel(), myErrorExpected.getMessage());

        MyErrors myErrors = Validators.initialize()
                .addControl(control1)
                .addControl(control2)
                .validate();

        Assertions.assertEquals(0, myErrors.getNumberOfErrors());
        Assertions.assertFalse(myErrors.containError());
        Assertions.assertFalse(myErrors.containError(myErrorExpected));
    }

}
