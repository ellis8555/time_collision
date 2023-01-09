package Gameplay.PlayerTurnOptions.DisplayOptions;

import Territories.RealmDesign;
import Territories.World;
import Utilities.Population.DisplayCitizens;
import Utilities.Population.GetCitizensObjectByName;
import Utilities.UserInputs.Inputs.NameInput;

public class SingleCitizenDisplay {

    public void displayASingleCitizen(Integer realmId){
        // get realm
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);
        // display list of this realms citizesn
        System.out.println("List of your citizens");
        DisplayCitizens.displayCitizens(realm.getCitizensObjects());
        // get user input for which citizen
        System.out.println("Type in a name for one of your citizens...");
        String citizensName = NameInput.nameInput();
        System.out.println(GetCitizensObjectByName.getCitizen(citizensName, World.getRealmsInTheWorld().get(realmId).getCitizensObjects()));
    }

}
