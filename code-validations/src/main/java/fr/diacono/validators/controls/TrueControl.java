package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;

import java.util.Optional;

public class TrueControl extends Control {
    private final Boolean bool;
    private final MyError myError;

    public TrueControl(boolean bool, MyErrorLevel myErrorLevel, String message) {
        this.bool = bool;
        this.myError = new MyError(myErrorLevel, message);
    }

    public TrueControl(Boolean object, MyErrorLevel myErrorLevel, String message) {
        this.bool = object;
        this.myError = new MyError(myErrorLevel, message);
    }

    @Override
    public Optional<MyError> check() {
        if (isActive()) {
            if (bool == null || !bool) {
                return Optional.of(myError);
            }
        }
        return Optional.empty();
    }
}
