// auto generates a phone number for a person upon person object creation
// number can be custom changed using "setCellNumber()" on a person object

package Utilities.Phones;

import java.util.Random;

public class GeneratePhoneNumber {

    public static String createNumber (int areaCode){
        // random used to generate phone number sequences
        Random random = new Random();
        // phone numbers first three numbers
        int firstThreeNumbers = random.nextInt(1000);
        // phone numbers next four numbers
        int lastFourNumbers = random.nextInt(10000);
        // convert numbers to strings to display full number as string

        String myFirstThreeNumbers = String.format("%03d", firstThreeNumbers);
        String myLastFourNumbers = String.format("%04d", lastFourNumbers);
        String thisAreaCode = String.valueOf(areaCode);
        // phone number displayed as string with dashes added
        String myCellNumber = thisAreaCode + "-" + myFirstThreeNumbers + "-" + myLastFourNumbers;
        return myCellNumber;
    }
}
