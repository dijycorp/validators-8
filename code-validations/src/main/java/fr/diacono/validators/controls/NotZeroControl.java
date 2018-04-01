package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;

import java.util.Optional;

public class NotZeroControl extends Control {
    private Integer integer;
    private MyError myError;

    public NotZeroControl(Integer integer, MyErrorLevel myErrorLevel, String message) {
        this.integer = integer;
        this.myError = new MyError(myErrorLevel, message);
    }

    public NotZeroControl(int integer, MyErrorLevel myErrorLevel, String message) {
        this.integer = integer;
        this.myError = new MyError(myErrorLevel, message);
    }

    public Optional<MyError> check() {
        if (isActive()) {
            if (integer != null && integer == 0) {
                return Optional.of(myError);
            }
        }
        return Optional.empty();
    }
}
