package com.ekip.KVMK.Validation;

import org.springframework.security.core.parameters.P;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

    public static boolean validate(String email) {
        boolean status = false;
        String email_Pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(email_Pattern);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches())
        {
            status =true;
        }
        else
        {
            status = false;
        }
        return status;

    }

}
