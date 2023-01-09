package Utilities.UserInputs.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericCheckWithRange {
    public static boolean numericCheckWithRange(int userEntry, int capacity) {
        String number = String.valueOf(userEntry);
        String maxNumber = String.valueOf(capacity);
        StringBuilder maxNumberAllowed = new StringBuilder();
        if(capacity < 10){
            maxNumberAllowed.append("[^0-"+maxNumber+"]");
        }else{
            char secondNumber = maxNumber.charAt(1);
            maxNumberAllowed.append("[^0-1][^0-"+secondNumber+"]");
        }
        String range = maxNumberAllowed.toString();
        Pattern pattern = Pattern.compile(range);
        Matcher matcher = pattern.matcher(number);
        if(matcher.find()){
            return false;
        }else{
            return true;
        }
    }
}
