package Utilities.UserInputs.Inputs;

import Utilities.UserInputs.Patterns.AlphaCharacterCheck;

import java.util.Scanner;

public class NameInputWithSpaces {

    public static String nameInputWithSpaces(){

        String name;
        boolean validEntry = true;

        do{
            if(!validEntry) System.out.println("Letters only and no dual naming please. Try again...");
            Scanner scanner = new Scanner(System.in);
            name = scanner.nextLine();
            validEntry = AlphaCharacterCheck.alphaCharacterWithSpacesCheck(name);
        }
        while(!validEntry);

        return name;
    }
}
