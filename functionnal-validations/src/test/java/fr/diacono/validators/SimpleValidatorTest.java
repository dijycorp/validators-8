package fr.diacono.validators;

import fr.diacono.validators.controls.BooleanControl;
import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleValidatorTest {

    private SimpleValidator<Boolean> validator;

    @BeforeEach
    void setUp() {
        validator = SimpleValidator.from(BooleanControl.isTrue(), MyError.of(MyErrorLevel.MANDATORY, "not true"));
    }

    @Test
    void should_return_a_valid_result_when_the_validation_is_ok() {
        ValidationResult result = validator.test(true);
        Assertions.assertTrue(result.isValid());
        Assertions.assertNull(result.getErrorMessage());
        Assertions.assertNull(result.getMyError());

    }

    @Test
    void should_return_a_not_valid_result_when_the_validation_is_ko() {
        ValidationResult result = validator.test(false);
        Assertions.assertFalse(result.isValid());
        Assertions.assertNotNull(result.getErrorMessage());
        Assertions.assertNotNull(result.getMyError());
        Assertions.assertEquals("not true", result.getErrorMessage());
    }
}