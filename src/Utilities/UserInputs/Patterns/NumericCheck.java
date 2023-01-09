package Utilities.UserInputs.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericCheck {

    public static boolean numericCheck(int userEntry) {
        String number = String.valueOf(userEntry);
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(number);
        if(matcher.find()){
            return true;
        }else{
            return false;
        }
    }
}
