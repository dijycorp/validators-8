package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;

import java.util.Optional;

public class FalseControl extends Control {
    private final MyError myError;
    private Boolean bool;

    public FalseControl(boolean bool, MyErrorLevel myErrorLevel, String message) {
        this.myError = new MyError(myErrorLevel, message);
        this.bool = bool;
    }

    public FalseControl(Boolean bool, MyErrorLevel myErrorLevel, String message) {
        this.myError = new MyError(myErrorLevel, message);
        this.bool = bool;
    }

    @Override
    public Optional<MyError> check() {
        if (isActive()) {
            if (bool != null && bool) {
                return Optional.of(myError);
            }
        }
        return Optional.empty();
    }
}
