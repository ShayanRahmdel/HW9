package utility;

import java.util.regex.Pattern;

public class Validation {
    public static Boolean isValidPassword(String password){
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$");
        return password.matches(pattern.pattern());
    }

    public static Boolean isValidUserName(String userName){
        Pattern pattern = Pattern.compile("^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$");
        return userName.matches(pattern.pattern());
    }

    public static Boolean isValidName(String name){
        Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z '.-]*[A-Za-z][^-]$");
        return name.matches(pattern.pattern());
    }

    public static Boolean isValidPostalCode(String postalCode){
        Pattern pattern = Pattern.compile("\\b(?!(\\d)\\1{3})[13-9]{4}[1346-9][013-9]{5}\\b");
        return postalCode.matches(pattern.pattern());
    }

}
