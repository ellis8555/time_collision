package Gameplay.PlayerTurnOptions.EditOptions;

import Gameplay.PlayerTurnOptions.DisplayOptions.AllCitizensDisplay;
import Persons.PersonDesign;
import Territories.RealmDesign;
import Territories.World;
import Utilities.Population.DisplayCitizens;
import Utilities.Population.GetCitizensObjectByName;
import Utilities.UserInputs.Inputs.NameInput;

import java.util.Scanner;

public class ChangeCitizensPhonenumber {

    public void changeCitizensPhoneNumber(Integer realmId){
        // get realm
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);
        // display list of this realms citizesn
        System.out.println("List of your citizens");
        DisplayCitizens.displayCitizens(realm.getCitizensObjects());
        // get user input for which citizen
        System.out.println("Enter a citizens name..");
        try{
            String name = NameInput.nameInput();
            PersonDesign person = GetCitizensObjectByName.getCitizen(name, World.getRealmsInTheWorld().get(realmId).getCitizensObjects());
            if(person.equals(null)){
                throw new Exception();
            }else{
                System.out.println("at least 7 numbers are required in order a new number to be valid.");
                Scanner scanner = new Scanner(System.in);
                String newNumber = (String) scanner.next();
                person.setCellNumber(newNumber, person.getCellNumber());
            }
        } catch(Exception e){
            System.out.println("Here's a list of your citizens.");
            new AllCitizensDisplay().displayPlayersCitizens(realmId);
        }
    }
}
