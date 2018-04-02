package fr.diacono.validators;

import fr.diacono.validators.errors.MyError;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class ValidationResults {

    private Set<MyError> errors;

    private ValidationResults(Collection<MyError> errors) {
        this.errors = new HashSet<>();
        if (errors != null && !errors.isEmpty()) this.errors.addAll(errors);
    }

    static ValidationResults from(Collection<MyError> errors) {
        return new ValidationResults(errors);
    }

    boolean isValid() {
        return errors.isEmpty();
    }

    Set<MyError> getErrors() {
        return new HashSet<>(errors);
    }

    ValidationResults addError(MyError error) {
        if (error != null)
            this.errors.add(error);
        return this;
    }

    ValidationResults addErrors(Collection<MyError> errors) {
        if (errors != null && !errors.isEmpty()) {
            this.errors.addAll(errors);
        }
        return this;
    }
}
