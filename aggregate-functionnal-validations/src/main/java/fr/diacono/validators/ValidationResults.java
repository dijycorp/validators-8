package fr.diacono.validators;

import fr.diacono.validators.errors.MyError;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class ValidationResults {

    private Collection<MyError> errors;

    private ValidationResults(Collection<MyError> errors) {
        this.errors = Optional.ofNullable(errors).orElse(new ArrayList<>());
    }

    public static ValidationResults from(Collection<MyError> errors) {
        return new ValidationResults(errors);
    }

    public boolean isValid() {
        return errors != null && !errors.isEmpty();
    }

    public Collection<MyError> getErrors() {
        return this.errors;
    }

    public ValidationResults addError(MyError error) {
        if (error != null)
            this.errors.add(error);
        return this;
    }

    public ValidationResults addErrors(Collection<MyError> errors) {
        if (errors != null && !errors.isEmpty()) {
            this.errors.addAll(errors);
        }
        return this;
    }
}
