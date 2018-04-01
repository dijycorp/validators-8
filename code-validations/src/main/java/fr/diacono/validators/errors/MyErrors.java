package fr.diacono.validators.errors;

import java.util.ArrayList;
import java.util.Collection;

public class MyErrors {
    public Collection<MyError> myErrors;

    public MyErrors() {
        myErrors = new ArrayList<>();
    }

    public void add(MyError myError) {
        myErrors.add(myError);
    }

    public boolean containError(MyError myError) {
        return myError != null && myErrors.contains(myError);
    }

    public boolean containError() {
        return !myErrors.isEmpty();
    }

    public boolean containError(MyErrorLevel myErrorLevel) {
        return myErrors.stream().anyMatch(error -> error.getMyErrorLevel().equals(myErrorLevel));
    }

    public int getNumberOfErrors() {
        return myErrors.size();
    }

}
