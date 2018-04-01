package fr.diacono.validators;

import fr.diacono.validators.errors.MyError;

public class ValidationResult {
    private MyError myError;
    private boolean valid;

    private ValidationResult(MyError myError, boolean valid) {
        this.myError = myError;
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public static ValidationResult ok() {
        return new ValidationResult(null, true);
    }

    public static ValidationResult fail(MyError myError) {
        return new ValidationResult(myError, false);
    }

    public MyError getMyError() {
        return myError;
    }

    public String getErrorMessage() {
        return myError != null ? myError.getMessage() : null;
    }
}
