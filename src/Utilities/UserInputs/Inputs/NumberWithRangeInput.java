package Utilities.UserInputs.Inputs;

import Utilities.UserInputs.Patterns.NumericCheckWithRange;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberWithRangeInput {

    private static int number;
    public static int numberWithRangeInput(int range){

        int selectionNumber;
        boolean validEntry = true;

        do{
            if(!validEntry) System.out.println("You must choose a corresponding number. Try again...");
            try{
                Scanner scanner = new Scanner(System.in);
                selectionNumber = scanner.nextInt();
                number = selectionNumber;
                validEntry =  NumericCheckWithRange.numericCheckWithRange(selectionNumber, range);
            }catch(InputMismatchException e){
                validEntry = false;
            }
        }
        while(!validEntry);

        return number;
    }
    }

