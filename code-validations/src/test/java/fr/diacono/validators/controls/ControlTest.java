package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class ControlTest {

    @Test
    void should_initialize_the_field_activated_to_true() {
        Control control = new Control() {
            @Override
            public Optional<MyError> check() {
                return Optional.empty();
            }
        };

        Assertions.assertTrue(control.isActive());
    }
}
