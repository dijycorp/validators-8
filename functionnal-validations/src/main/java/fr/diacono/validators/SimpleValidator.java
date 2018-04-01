package fr.diacono.validators;

import fr.diacono.validators.errors.MyError;

import java.util.function.Predicate;

public class SimpleValidator<K> implements Validator<K> {

    private Predicate<K> predicate;
    private MyError myError;

    public static <K> SimpleValidator<K> from(Predicate<K> predicate, MyError onErrorMessage) {
        return new SimpleValidator<>(predicate, onErrorMessage);
    }

    private SimpleValidator(Predicate<K> predicate, MyError myError) {
        this.predicate = predicate;
        this.myError = myError;
    }

    @Override
    public ValidationResult test(K param) {
        return predicate.test(param) ? ValidationResult.ok() : ValidationResult.fail(myError);
    }
}
