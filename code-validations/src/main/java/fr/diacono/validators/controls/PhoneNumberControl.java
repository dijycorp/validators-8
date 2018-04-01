package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;

import java.util.Optional;

public class PhoneNumberControl extends Control {
    private static final String PHONE_NUMBER_REGEX = "^((\\+)33|0)[1-9](\\d{2}){4}$";

    private final MyError myError;
    private String phoneNumber;

    public PhoneNumberControl(final String phoneNumber, final MyErrorLevel myErrorLevel, final String message) {
        this.myError = new MyError(myErrorLevel, message);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Optional<MyError> check() {
        if (isActive()) {
            return new PatternControl(phoneNumber, PHONE_NUMBER_REGEX, myError.getMyErrorLevel(), myError.getMessage()).check();
        }
        return Optional.empty();
    }
}
