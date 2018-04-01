package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;

import java.util.Optional;

public abstract class Control {
    abstract public Optional<MyError> check();

    private boolean isActive = true;

    public Control activate(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }
}
