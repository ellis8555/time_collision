package Utilities.UserInputs.Inputs;

import Utilities.UserInputs.Patterns.AlphaCharacterCheck;

import java.util.Scanner;

public class NameInput {
    public static String nameInput(){

        String name;
        boolean validEntry = true;

        do{
            if(!validEntry) System.out.println("Letters only and no dual naming please. Try again...");
            Scanner scanner = new Scanner(System.in);
            name = scanner.nextLine();
            validEntry = AlphaCharacterCheck.alphaCharacterCheck(name);
        }
        while(!validEntry);

        StringBuilder validatedName = new StringBuilder();
        validatedName.append(name);
        return validatedName.toString();
    }
}
