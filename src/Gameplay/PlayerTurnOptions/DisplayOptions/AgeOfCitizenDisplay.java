package Gameplay.PlayerTurnOptions.DisplayOptions;

import Persons.PersonDesign;
import Territories.RealmDesign;
import Territories.World;
import Utilities.Population.DisplayCitizens;
import Utilities.Population.GetCitizensObjectByName;
import Utilities.UserInputs.Inputs.NameInput;

public class AgeOfCitizenDisplay {

    public void displayAgeOfCitizen(Integer realmId){
        // get realm
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);
        // display list of this realms citizesn
        System.out.println("List of your citizens");
        DisplayCitizens.displayCitizens(realm.getCitizensObjects());
        // get user input for which citizen
        System.out.println("Enter name of citizen");
        String nameForAge = NameInput.nameInput();
        PersonDesign person = GetCitizensObjectByName.getCitizen(nameForAge, World.getRealmsInTheWorld().get(realmId).getCitizensObjects());
        try{
            System.out.println(person.displayAge());
        }catch(NullPointerException e){
            System.out.println("You can create that person ya know!");
        }
    }

}
