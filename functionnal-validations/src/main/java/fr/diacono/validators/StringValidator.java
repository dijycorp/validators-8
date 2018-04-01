package fr.diacono.validators;

import fr.diacono.validators.controls.StringControl;
import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;

public class StringValidator {

    public static ValidationResult isNotBlank(String value) {
        return SimpleValidator
                .from(StringControl.isNotBlank(), MyError.of(MyErrorLevel.MANDATORY, "is blank"))
                .test(value);
    }

    public static ValidationResult isSize(String value, int size) {
        Validator<String> notNullValidator = SimpleValidator
                .from(StringControl.isNotBlank(), MyError.of(MyErrorLevel.MANDATORY, "is blank"));
        Validator<String> isSizeValidator = SimpleValidator
                .from(p -> p.length() == size, MyError.of(MyErrorLevel.MANDATORY, "not the size expected"));
        return notNullValidator
                .and(isSizeValidator)
                .test(value);
    }

}
