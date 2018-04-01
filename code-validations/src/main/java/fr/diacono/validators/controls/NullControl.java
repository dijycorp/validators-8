package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;

import java.util.Optional;

public class NullControl extends Control {
    private final MyError myError;
    private Object object;

    public NullControl(Object object, MyErrorLevel myErrorLevel, String message) {
        this.myError = new MyError(myErrorLevel, message);
        this.object = object;
    }

    @Override
    public Optional<MyError> check() {
        if (isActive()) {
            if (object != null) {
                return Optional.of(myError);
            }
        }
        return Optional.empty();
    }
}
