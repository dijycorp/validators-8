package fr.diacono.validators.errors;

import java.util.Objects;

public class MyError {
    private MyErrorLevel myErrorLevel;
    private String message;

    public MyError(MyErrorLevel myErrorLevel, String message) {
        this.myErrorLevel = myErrorLevel;
        this.message = message;
    }

    public static MyError of(MyErrorLevel myErrorLevel, String message) {
        return new MyError(myErrorLevel, message);
    }

    public MyErrorLevel getMyErrorLevel() {
        return myErrorLevel;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyError myError = (MyError) o;
        return myErrorLevel == myError.myErrorLevel &&
                Objects.equals(message, myError.message);
    }

    @Override
    public int hashCode() {

        return Objects.hash(myErrorLevel, message);
    }
}
