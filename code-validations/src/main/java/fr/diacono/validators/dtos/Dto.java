package fr.diacono.validators.dtos;

import fr.diacono.validators.Validable;
import fr.diacono.validators.Validators;
import fr.diacono.validators.controls.*;
import fr.diacono.validators.errors.MyErrorLevel;
import fr.diacono.validators.errors.MyErrors;

import java.util.Collection;

public class Dto implements Validable {
    public Integer integer;
    public String string;
    public String email;
    public String zipCode;
    public String phoneNumber;
    public Object nonNull;
    public Object nullObject;
    public Boolean trueValue;
    public boolean falseValue;

    @Override
    public MyErrors validate() {
        return Validators.initialize()
                .addControl(new NotZeroControl(this.integer, MyErrorLevel.NEED, "zero not allow"))
                .addControl(new NotBlankControl(this.string, MyErrorLevel.NEED, "blank not allow"))
                .addControl(new EmailControl(this.email, MyErrorLevel.NO_NEED, "email is not fill or not correct"))
                .addControl(new ZipCodeFrenchControl(this.zipCode, MyErrorLevel.NO_NEED, "zip is not fill or not correct"))
                .addControl(new PhoneNumberControl(this.phoneNumber, MyErrorLevel.NO_NEED, "phone is not fill").activate(false))
                .addControl(new NotNullControl(nonNull, MyErrorLevel.NO_NEED, "null not allow"))
                .addControl(new NullControl(nullObject, MyErrorLevel.NO_NEED, "not null not allow"))
                .addControl(new TrueControl(trueValue, MyErrorLevel.NO_NEED, "only true allow"))
                .addControl(new FalseControl(falseValue, MyErrorLevel.NO_NEED, "only false allow"))
                .validate();
    }

    @Override
    public MyErrors validate(Collection<Control> controls) {
        return Validators.initialize(controls).validate();
    }
}
