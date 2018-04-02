package fr.diacono.validators;

import fr.diacono.validators.controls.StringControl;
import fr.diacono.validators.errors.MyError;
import fr.diacono.validators.errors.MyErrorLevel;

import static fr.diacono.validators.SimpleValidator.from;

class StringValidator {

    static ValidationResult isNotBlank(String value) {
        return from(StringControl.isNotBlank(), MyError.of(MyErrorLevel.MANDATORY, "is blank")).test(value);
    }

    static ValidationResult isSize(String value, int size) {
        return from(StringControl.isNotBlank(), MyError.of(MyErrorLevel.MANDATORY, "is blank"))
                .and(from(StringControl.isSize(size), MyError.of(MyErrorLevel.MANDATORY, "not the size expected")))
                .test(value);
    }

}
