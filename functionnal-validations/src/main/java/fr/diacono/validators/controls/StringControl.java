package fr.diacono.validators.controls;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class StringControl extends ObjectControl {

    private static final String regexEmail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    public static Predicate<String> isContains(String container) {
        return p -> isNotNull().test(p)
                && isNotNull().test(container)
                && container.contains(p);
    }

    public static Predicate<String> isSame(String sameAs) {
        return s -> isNotNull().test(s)
                && isNotNull().test(sameAs)
                && s.equals(sameAs) ||
                (isNull().test(s) && isNull().test(sameAs));
    }

    public static Predicate<String> isNotBlank() {
        return s -> isNotNull().test(s) && !s.isEmpty();
    }

    public static Predicate<String> isAnEmail() {
        return s -> isNotNull().test(s)
                && Pattern.compile(regexEmail, Pattern.CASE_INSENSITIVE).matcher(s).find();
    }

    public static Predicate<String> isBefore(String isBefore) {
        return s -> isNotNull().test(s)
                && isNotNull().test(isBefore)
                && s.compareTo(isBefore) < 0;
    }

    public static Predicate<String> isAfter(String isAfter) {
        return s -> isNotNull().test(s)
                && isNotNull().test(isAfter)
                && s.compareTo(isAfter) > 0;
    }

    public static Predicate<String> isBetween(String isBefore, String isAfter) {
        return s -> (isBefore(isAfter).test(s) || isSame(isAfter).test(s))
                && (isAfter(isBefore).test(s) || isSame(isBefore).test(s));
    }
}
