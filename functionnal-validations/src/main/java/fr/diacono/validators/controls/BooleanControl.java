package fr.diacono.validators.controls;

import java.util.function.Predicate;

public class BooleanControl extends ObjectControl {

    public static Predicate<Boolean> isFalse() {
        return p -> isNotNull().test(p) || !p;
    }

    public static Predicate<Boolean> isTrue() {
        return p -> isNotNull().test(p) && p;
    }
}
