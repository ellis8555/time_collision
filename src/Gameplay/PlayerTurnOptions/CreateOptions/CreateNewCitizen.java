package Gameplay.PlayerTurnOptions.CreateOptions;

import Enums.Gender;
import Territories.RealmDesign;
import Territories.World;
import Utilities.UserInputs.Inputs.NameInput;
import Utilities.UserInputs.Inputs.NumberWithRangeInput;

public class CreateNewCitizen {

    public void createNewCitizen(Integer realmId){
        RealmDesign myRealm = World.getRealmsInTheWorld().get(realmId);
        System.out.println("Enter your citizens name");
        String name = NameInput.nameInput();
        System.out.println("Pick a gender\n1. Male\n2.Female");
        int genderChoice = NumberWithRangeInput.numberWithRangeInput(2);
        switch(genderChoice){
            case 1:
                myRealm.addCitizen(name, Gender.MALE);
                break;
            default:
                myRealm.addCitizen(name, Gender.FEMALE);
        }
    }

}
