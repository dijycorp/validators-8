package fr.diacono.validators.errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyErrorsTest {

    private MyErrors myErrors;

    @BeforeEach
    void setUp() {
        myErrors = new MyErrors();
    }

    @Test
    void should_find_an_error() {
        myErrors.add(new MyError(MyErrorLevel.MANDATORY, "is needed"));
        Assertions.assertTrue(myErrors.containError());
    }

    @Test
    void should_find_an_error_of_level_need() {
        myErrors.add(new MyError(MyErrorLevel.MANDATORY, "is needed"));
        Assertions.assertTrue(myErrors.containError(MyErrorLevel.MANDATORY));
    }

    @Test
    void should_find_the_specified_error_with_level_need_and_message_is_nedded() {
        myErrors.add(new MyError(MyErrorLevel.MANDATORY, "is needed"));
        Assertions.assertTrue(myErrors.containError(new MyError(MyErrorLevel.MANDATORY, "is needed")));
    }

    @Test
    void should_found_five_errors() {
        myErrors.add(new MyError(MyErrorLevel.MANDATORY, "is needed"));
        myErrors.add(new MyError(MyErrorLevel.MANDATORY, "is needed"));
        myErrors.add(new MyError(MyErrorLevel.MANDATORY, "is needed"));
        myErrors.add(new MyError(MyErrorLevel.MANDATORY, "is needed"));
        myErrors.add(new MyError(MyErrorLevel.MANDATORY, "is needed"));
        Assertions.assertEquals(5, myErrors.getNumberOfErrors());
    }
}
