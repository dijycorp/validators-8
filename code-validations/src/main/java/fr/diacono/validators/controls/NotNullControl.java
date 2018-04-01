package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;

import java.util.Optional;

public class NotNullControl extends Control {
    private Object object;
    private MyError myError;

    public NotNullControl(Object object, MyErrorLevel myErrorLevel, String message) {
        this.object = object;
        this.myError = new MyError(myErrorLevel, message);
    }

    @Override
    public Optional<MyError> check() {
        if (isActive()) {
            if (object == null) {
                return Optional.of(myError);
            }
        }
        return Optional.empty();
    }
}
