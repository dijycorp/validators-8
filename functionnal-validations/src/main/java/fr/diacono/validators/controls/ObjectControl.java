package fr.diacono.validators.controls;

import java.util.Objects;
import java.util.function.Predicate;

public class ObjectControl {

    // can be use directly with the return method in place of a new one
    public static Predicate<Object> isNotNull() {
        return Objects::nonNull;
    }

    // could is the method below in pace of build a new one
    public static Predicate<Object> isNull() {
        return Objects::isNull;
    }
}
