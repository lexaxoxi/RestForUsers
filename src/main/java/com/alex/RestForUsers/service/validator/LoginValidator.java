package com.alex.RestForUsers.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String LOGIN_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public LoginValidator() {
        pattern = Pattern.compile(LOGIN_PATTERN);
    }

    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }

}
