package fr.diacono.validators;

import fr.diacono.validators.errors.MyError;
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
        ValidationResults validationResults = ValidationResults.from(Arrays.asList(new MyError(), new MyError()));
        Assertions.assertEquals(2, validationResults.getErrors().size());
    }

}