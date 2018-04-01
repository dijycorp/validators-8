package fr.diacono.dtos;

import fr.diacono.validators.Validable;
import fr.diacono.validators.Validator;
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
        return null;
    }

    @Override
    public MyErrors validate(Collection<Validator> controls) {
        return null;
    }
}
