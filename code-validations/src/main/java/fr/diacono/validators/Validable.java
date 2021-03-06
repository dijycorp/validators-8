package fr.diacono.validators;

import fr.diacono.validators.controls.Control;
import fr.diacono.validators.errors.MyErrors;

import java.util.Collection;

public interface Validable {
    MyErrors validate();

    MyErrors validate(Collection<Control> controls);
}
