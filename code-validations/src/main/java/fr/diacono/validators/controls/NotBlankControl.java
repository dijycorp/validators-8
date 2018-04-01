package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;

import java.util.Optional;

public class NotBlankControl extends Control {
    private String string;
    private MyError myError;

    public NotBlankControl(String string, MyErrorLevel myErrorLevel, String message) {
        this.string = string;
        this.myError = new MyError(myErrorLevel, message);
    }

    @Override
    public Optional<MyError> check() {
        if (isActive()) {
            if (string == null || string.isEmpty()) {
                return Optional.of(myError);
            }
        }
        return Optional.empty();
    }
}
