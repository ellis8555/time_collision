package Utilities.UserInputs.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlphaCharacterCheck {

    public static boolean alphaCharacterCheck(String userEntry) {
        String string = String.valueOf(userEntry);
        Pattern pattern = Pattern.compile("[^a-zA-Z]");
        Matcher matcher = pattern.matcher(string);
        if(matcher.find()){
            return false;
        }else{
            return true;
        }
    }

    public static boolean alphaCharacterWithSpacesCheck(String userEntry) {
        String string = String.valueOf(userEntry);
        Pattern pattern = Pattern.compile("[^a-zA-Z\\s\\.']");
        Matcher matcher = pattern.matcher(string);
        if(matcher.find()){
            return false;
        }else{
            return true;
        }
    }
}
