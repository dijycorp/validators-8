package fr.diacono.validators;

import fr.diacono.validators.controls.BooleanControl;
import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    private SimpleValidator<Boolean> validatorIsTrue;
    private SimpleValidator<Boolean> validatorIsFalse;

    @BeforeEach
    void setUp() {
        validatorIsTrue = SimpleValidator.from(BooleanControl.isTrue(), MyError.of(MyErrorLevel.MANDATORY, "not true"));
        validatorIsFalse = SimpleValidator.from(BooleanControl.isFalse(), MyError.of(MyErrorLevel.MANDATORY, "not false"));
    }

    @Test
    void should_return_a_valid_result_when_two_test_valid_with_and_method_is_call() {
        ValidationResult result = validatorIsTrue.and(validatorIsTrue).test(true);
        Assertions.assertTrue(result.isValid());
        Assertions.assertNull(result.getErrorMessage());
    }

    @Test
    void should_return_a_not_valid_result_when_the_first_test_is_invalid_with_and_method_is_call() {
        ValidationResult result = validatorIsFalse.and(validatorIsTrue).test(true);
        Assertions.assertFalse(result.isValid());
        Assertions.assertNotNull(result.getErrorMessage());
        Assertions.assertEquals("not false", result.getErrorMessage());
    }

    @Test
    void should_return_a_not_valid_result_when_the_second_test_is_invalid_with_and_method_is_call() {
        ValidationResult result = validatorIsTrue.and(validatorIsFalse).test(true);
        Assertions.assertFalse(result.isValid());
        Assertions.assertNotNull(result.getErrorMessage());
        Assertions.assertEquals("not false", result.getErrorMessage());
    }

    @Test
    void should_return_a_valid_result_when_two_test_valid_with_or_method_is_call() {
        ValidationResult result = validatorIsTrue.or(validatorIsTrue).test(true);
        Assertions.assertTrue(result.isValid());
        Assertions.assertNull(result.getErrorMessage());
    }

    @Test
    void should_return_a_not_valid_result_when_all_is_invalid_with_or_method_is_call() {
        ValidationResult result = validatorIsFalse.or(validatorIsFalse).test(true);
        Assertions.assertFalse(result.isValid());
        Assertions.assertNotNull(result.getErrorMessage());
        Assertions.assertEquals("not false", result.getErrorMessage());
    }

    @Test
    void should_return_a_valid_result_when_the_first_test_is_invalid_with_or_method_is_call() {
        ValidationResult result = validatorIsFalse.and(validatorIsTrue).test(true);
        Assertions.assertFalse(result.isValid());
        Assertions.assertNotNull(result.getErrorMessage());
        Assertions.assertEquals("not false", result.getErrorMessage());
    }

    @Test
    void should_return_a_valid_result_when_the_second_test_is_invalid_with_and_method_is_call() {
        ValidationResult result = validatorIsTrue.and(validatorIsFalse).test(true);
        Assertions.assertFalse(result.isValid());
        Assertions.assertNotNull(result.getErrorMessage());
        Assertions.assertEquals("not false", result.getErrorMessage());
    }
}
