package fr.diacono.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringValidatorTest {

    @Test
    void should_not_return_an_error_when_the_string_is_not_null() {
        ValidationResult result = StringValidator.isNotBlank("jeremie");
        Assertions.assertTrue(result.isValid());
        Assertions.assertNull(result.getMyError());
        Assertions.assertNull(result.getErrorMessage());
    }

    @Test
    void should_not_return_an_error_when_the_string_is_with_the_size_expected() {
        ValidationResult result = StringValidator.isSize("jeremie", 7);
        Assertions.assertTrue(result.isValid());
        Assertions.assertNull(result.getMyError());
        Assertions.assertNull(result.getErrorMessage());
    }

    @Test
    void should_return_an_error_when_the_string_is_null_in_place_of_not_blank() {
        ValidationResult blankResult = StringValidator.isNotBlank(null);
        Assertions.assertFalse(blankResult.isValid());
        Assertions.assertNotNull(blankResult.getMyError());
        Assertions.assertNotNull(blankResult.getErrorMessage());
        Assertions.assertEquals("is blank", blankResult.getErrorMessage());
    }

    @Test
    void should_return_an_error_when_the_string_is_null_in_place_of_size() {
        ValidationResult sizeResult = StringValidator.isSize(null, 7);

    }
}