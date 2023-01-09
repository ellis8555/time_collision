package Utilities.UserInputs.Inputs;

import Utilities.UserInputs.Patterns.NumericCheck;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberInput {

    private static int number;
    public static int numberInput(){

        int selectionNumber;
        boolean validEntry = true;

        do{
            if(!validEntry) System.out.println("You must choose a corresponding number. Try again...");
            try{
                Scanner scanner = new Scanner(System.in);
                selectionNumber = scanner.nextInt();
                number = selectionNumber;
                validEntry = NumericCheck.numericCheck(selectionNumber);
            }catch(InputMismatchException e){
                validEntry = false;
            }
        }
        while(!validEntry);

        return number;
    }
}
