package Gameplay.PlayerTurnOptions.CreateOptions;

import Buildings.Germanic.BuildingTypes.Barn;
import Buildings.Germanic.BuildingTypes.MeadHall;
import Buildings.Germanic.BuildingTypes.StoreRoom;
import Buildings.Roman.BuildingTypes.Notary;
import Buildings.Roman.BuildingTypes.School;
import Buildings.Roman.BuildingTypes.Stable;
import Persons.PersonDesign;
import Territories.GermanicRegion.GermanicRealm;
import Territories.RealmDesign;
import Territories.World;
import Utilities.Population.DisplayCitizens;
import Utilities.Population.GetCitizensObjectByName;
import Utilities.UserInputs.Inputs.NameInput;
import Utilities.UserInputs.Inputs.NameInputWithSpaces;
import Utilities.UserInputs.Inputs.NumberWithRangeInput;

public class CreateNewBuilding {

    public void createNewBuilding(Integer realmId){

        // get realm objects
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);

        // begin by selecting building type
        System.out.println("Types of buildings to choose from,");

        // user input variables
        String businessName;
        PersonDesign ownersObject;

        // check which realm type to create proper building type

        if(realm instanceof GermanicRealm){ // if germanic realm

            // list building types
            System.out.println("1. Mead Hall\n2. Barn\n3. Storage shed");
            // collect users choice of building type
            System.out.println("Choose your building type from the list above");
            int buildingChoice = NumberWithRangeInput.numberWithRangeInput(3);
            // collect users choice of name for building
            System.out.println("Enter a name for your building");
            businessName = NameInputWithSpaces.nameInputWithSpaces();
            // collect users choice for which citizen will own the building
            DisplayCitizens.displayCitizens(realm.getCitizensObjects());
            System.out.println("Type the name of which citizen will be the owner of this building");
            String citizenNameInput = NameInput.nameInput();
            // get citizens object who owns the building
            ownersObject = GetCitizensObjectByName.getCitizen(citizenNameInput, realm.getCitizensObjects());
            int citizensId = ownersObject.getId();
            // construct appropriate building depending on users choice for building type
            switch(buildingChoice){
                case 1:
                    new MeadHall(businessName, citizensId, realmId);
                    break;
                case 2:
                    new Barn(businessName, citizensId, realmId);
                    break;
                case 3:
                    new StoreRoom(businessName, citizensId, realmId);
                    break;
            }
            // end if true
        } else {    // if roman realm

            // list building types
            System.out.println("1. Stable\n2. Notary\n3. School");
            // collect users choice of building type
            System.out.println("Choose your building type from the list above");
            int buildingChoice = NumberWithRangeInput.numberWithRangeInput(4);
            // collect users choice of name for building
            System.out.println("Enter a name for your building");
            businessName = NameInputWithSpaces.nameInputWithSpaces();
            // collect users choice for which citizen will own the building
            DisplayCitizens.displayCitizens(realm.getCitizensObjects());
            System.out.println("Type the name of which citizen will be the owner of this building");
            String citizenNameInput = NameInput.nameInput();
            // get citizens object who owns the building
            ownersObject = GetCitizensObjectByName.getCitizen(citizenNameInput, realm.getCitizensObjects());
            int citizensId = ownersObject.getId();
            // construct appropriate building depending on users choice for building type
            switch(buildingChoice){
                case 1:
                    new Stable(businessName, citizensId, realmId);
                    break;
                case 2:
                    new Notary(businessName, citizensId, realmId);
                    break;
                case 3:
                    new School(businessName, citizensId, realmId);
                    break;
            }
            // end  if true
        }

        // output message completing building creation
        System.out.println(ownersObject.getName()+" is the owner of "+businessName);
        // end method
    }
    // end class
}
