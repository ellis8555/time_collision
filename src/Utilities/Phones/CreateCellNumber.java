// each person can change their phone number using this class.
// user can type in anything but only the first 7 numeric characters are excepted
// all non-numeric entries are discarded
// less than 7 numeric characters will throw an error
// a dash is inserted to display a proper looking number
// area code is prepended automatically as that persons object knows the area code

package Utilities.Phones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateCellNumber {
    private String cellPhoneNumber;

    public CreateCellNumber(String number, String oldNumber) throws StringIndexOutOfBoundsException {
        try {
            String digits = String.valueOf(number);
            Pattern pattern = Pattern.compile("\\d");
            Matcher matcher = pattern.matcher(digits);
            StringBuilder numbers = new StringBuilder();
            while (matcher.find()) {
                numbers.append(digits.substring(matcher.start(), matcher.end()));
            }
            int numbersLength = numbers.length();
            if (numbersLength < 7) {
                throw new StringIndexOutOfBoundsException("Enter 7 digits required");
            }
            numbers.delete(7, numbersLength);
            StringBuilder cellNumber = numbers.insert(3, "-");
            cellPhoneNumber = cellNumber.toString();
        } catch (StringIndexOutOfBoundsException e) {
            cellPhoneNumber = oldNumber;
            System.out.println(e.getMessage()+"\nCall back and try again, thank you, have a good day!");
        }
    }
    public String getCellPhoneNumber(){
        return cellPhoneNumber;
    }
}
