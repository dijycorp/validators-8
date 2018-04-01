package fr.diacono.validators;

@FunctionalInterface
public interface Validator<K> {

    ValidationResult test(K param);

    default Validator<K> and(Validator<K> other) {
        return (param) -> {
            ValidationResult firstResult = this.test(param);
            return !firstResult.isValid() ? firstResult : other.test(param);
        };
    }

    default Validator<K> or(Validator<K> other) {
        return (param) -> {
            ValidationResult firstResult = this.test(param);
            return firstResult.isValid() ? firstResult : other.test(param);
        };
    }

}
