package fr.diacono.validators.controls;

import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;

import java.util.Optional;
import java.util.regex.Pattern;

public class PatternControl extends Control {
    private final String pattern;
    private final MyError myError;
    private CharSequence value;

    public PatternControl(CharSequence value, String pattern, MyErrorLevel myErrorLevel, String message) {
        this.value = value;
        this.pattern = pattern;
        this.myError = new MyError(myErrorLevel, message);
    }

    @Override
    public Optional<MyError> check() {
        if (isActive()) {
            if (pattern == null || !Pattern.compile(pattern).matcher(value).find()) {
                return Optional.of(myError);
            }
        }
        return Optional.empty();
    }
}
