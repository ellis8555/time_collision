package Gameplay.PlayerTurnOptions.EditOptions;

import Persons.PersonDesign;
import Territories.RealmDesign;
import Territories.World;
import Utilities.Population.DisplayCitizens;
import Utilities.Population.GetCitizensObjectByName;
import Utilities.UserInputs.Inputs.NameInput;

public class ChangeCitizensName {

    public void changeCitizensName(Integer realmId){
        // get realm
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);
        // display list of this realms citizesn
        System.out.println("List of your citizens");
        DisplayCitizens.displayCitizens(realm.getCitizensObjects());
        // get user input for which citizen
        System.out.println("Enter name of which citizen is changing their name");
        String nameToChange = NameInput.nameInput();
        try{
            PersonDesign person = GetCitizensObjectByName.getCitizen(nameToChange, World.getRealmsInTheWorld().get(realmId).getCitizensObjects());
            System.out.println("Enter a new name for this citizen");
            String newName = NameInput.nameInput();
            String originalName = person.getName();
            person.setName(newName);
            System.out.println(originalName+" is now known as "+newName+".");
        }catch(Exception e){
            System.out.println("That person doesn't exist.");
        }
    }
}
