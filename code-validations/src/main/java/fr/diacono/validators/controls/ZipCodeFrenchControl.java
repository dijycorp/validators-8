package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;

import java.util.Optional;

public class ZipCodeFrenchControl extends Control {
    private static final String ZIP_CODE_REGEX = "^\\d{5}$";

    private final MyError myError;
    private String zipCode;

    public ZipCodeFrenchControl(String zipCode, MyErrorLevel myErrorLevel, String message) {
        this.zipCode = zipCode;
        this.myError = new MyError(myErrorLevel, message);
    }

    @Override
    public Optional<MyError> check() {
        if (isActive()) {
            return new PatternControl(zipCode, ZIP_CODE_REGEX, myError.getMyErrorLevel(), myError.getMessage()).check();
        }
        return Optional.empty();
    }
}
