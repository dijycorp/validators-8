package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;

import java.util.Optional;
import java.util.regex.Pattern;

public class EmailControl extends Control {
    private String email;
    private MyError myError;

    public static final Pattern REGEX_EMAIL_ADDRESS_VALID =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public EmailControl(String email, MyErrorLevel myErrorLevel, String message) {
        this.email = email;
        this.myError = new MyError(myErrorLevel, message);
    }

    @Override
    public Optional<MyError> check() {
        if (isActive()) {
            if (email == null || !REGEX_EMAIL_ADDRESS_VALID.matcher(email).find()) {
                return Optional.of(myError);
            }
        }
        return Optional.empty();
    }
}
