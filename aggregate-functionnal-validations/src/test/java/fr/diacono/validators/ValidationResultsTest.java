package fr.diacono.validators;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class ValidationResultsTest {

    @Test
    void should_return_a_new_instance_of_validation_result_with_errors_empty_when_collection_is_null() {
        ValidationResults validationResults = ValidationResults.from(null);
        Assertions.assertEquals(0, validationResults.getErrors().size());
    }

    @Test
    void should_return_a_new_instance_of_validation_result_with_errors_empty_when_collection_is_empty() {
        ValidationResults validationResults = ValidationResults.from(new ArrayList<>());
        Assertions.assertEquals(0, validationResults.getErrors().size());
    }

    @Test
    void should_return_a_new_instance_of_validation_result_with_two_errors_empty_when_collection_contains_two_elements() {
        MyError error1 = MyError.of(MyErrorLevel.MANDATORY, "test1");
        MyError error2 = MyError.of(MyErrorLevel.OPTIONAL, "test2");
        ValidationResults validationResults = ValidationResults.from(Arrays.asList(error1, error2));
        Assertions.assertEquals(2, validationResults.getErrors().size());
    }

    @Test
    void should_be_valid_when_not_error_exist() {
        ValidationResults validationResults = ValidationResults.from(new ArrayList<>());
        Assertions.assertTrue(validationResults.isValid());
    }

    @Test
    void should_not_be_valid_when_error_exist() {
        MyError error1 = MyError.of(MyErrorLevel.MANDATORY, "test1");
        MyError error2 = MyError.of(MyErrorLevel.OPTIONAL, "test2");
        ValidationResults validationResults = ValidationResults.from(Arrays.asList(error1, error2));
        Assertions.assertFalse(validationResults.isValid());
    }

    @Test
    void should_add_an_error_when_she_is_not_null() {
        ValidationResults validationResults = ValidationResults.from(new ArrayList<>());
        validationResults.addError(MyError.of(MyErrorLevel.MANDATORY, "test"));
        Assertions.assertEquals(1, validationResults.getErrors().size());
    }

    @Test
    void should_not_add_an_error_when_she_null() {
        ValidationResults validationResults = ValidationResults.from(new ArrayList<>());
        validationResults.addError(null);
        Assertions.assertEquals(0, validationResults.getErrors().size());
    }

    @Test
    void should_add_the_errors_when_the_collection_is_not_empty() {
        ValidationResults validationResults = ValidationResults.from(new ArrayList<>());
        MyError error1 = MyError.of(MyErrorLevel.MANDATORY, "test1");
        MyError error2 = MyError.of(MyErrorLevel.OPTIONAL, "test2");
        validationResults.addErrors(Arrays.asList(error1, error2));
        Assertions.assertEquals(2, validationResults.getErrors().size());
    }


    @Test
    void should_not_add_the_errors_when_the_collection_is_empty() {
        ValidationResults validationResults = ValidationResults.from(new ArrayList<>());
        validationResults.addErrors(new ArrayList<>());
        Assertions.assertEquals(0, validationResults.getErrors().size());
    }

    @Test
    void should_not_add_the_errors_when_the_collection_is_null() {
        ValidationResults validationResults = ValidationResults.from(new ArrayList<>());
        validationResults.addErrors(null);
        Assertions.assertEquals(0, validationResults.getErrors().size());
    }

    @Test
    void should_not_add_an_error_by_reference() {
        ValidationResults validationResults = ValidationResults.from(new ArrayList<>());
        validationResults.getErrors().add(MyError.of(MyErrorLevel.MANDATORY, "test1"));
        Assertions.assertEquals(0, validationResults.getErrors().size());
    }

    @Test
    void should_be_only_one_error_with_same_message_and_level() {
        MyError error1 = MyError.of(MyErrorLevel.MANDATORY, "test1");
        MyError error2 = MyError.of(MyErrorLevel.MANDATORY, "test1");
        ValidationResults validationResults = ValidationResults.from(Arrays.asList(error1, error2));
        Assertions.assertEquals(1, validationResults.getErrors().size());
    }

    @Test
    void should_be_only_two_error_with_same_message_and_different_level() {
        MyError error1 = MyError.of(MyErrorLevel.MANDATORY, "test1");
        MyError error2 = MyError.of(MyErrorLevel.OPTIONAL, "test1");
        ValidationResults validationResults = ValidationResults.from(Arrays.asList(error1, error2));
        Assertions.assertEquals(2, validationResults.getErrors().size());
    }

    @Test
    void should_be_only_two_error_with_different_message_and_same_level() {
        MyError error1 = MyError.of(MyErrorLevel.MANDATORY, "test1");
        MyError error2 = MyError.of(MyErrorLevel.MANDATORY, "test2");
        ValidationResults validationResults = ValidationResults.from(Arrays.asList(error1, error2));
        Assertions.assertEquals(2, validationResults.getErrors().size());
    }

}