package fr.diacono.validators;

import fr.diacono.validators.controls.Control;
import fr.diacono.validators.errors.MyErrors;

import java.util.ArrayList;
import java.util.Collection;

public class Validators {
    private Collection<Control> controls;
    private MyErrors myErrors;

    private Validators() {
        controls = new ArrayList<>();
        myErrors = new MyErrors();
    }

    public static Validators initialize() {
        return new Validators();
    }

    public static Validators initialize(Collection<Control> controls) {
        return Validators.initialize().addControl(controls);
    }

    public Validators addControl(Control control) {
        controls.add(control);
        return this;
    }

    public Validators addControl(Collection<Control> controls) {
        if (controls != null && !controls.isEmpty()) {
            this.controls.addAll(controls);
        }
        return this;
    }

    public MyErrors validate() {
        for (Control control : controls) {
            control.check().ifPresent(error -> myErrors.add(error));
        }
        return myErrors;
    }
}
