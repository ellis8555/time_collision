package Gameplay.PlayerTurnOptions.EditOptions;

import Buildings.BuildingDesign;
import Gameplay.PlayerTurnOptions.DisplayOptions.BusinessPhonenumbersDisplay;
import Persons.PersonDesign;
import Territories.RealmDesign;
import Territories.World;
import Utilities.Buildings.GetBuildingObjectByName;
import Utilities.Population.DisplayCitizens;
import Utilities.Population.GetCitizensObjectByName;
import Utilities.UserInputs.Inputs.NameInput;
import Utilities.UserInputs.Inputs.NameInputWithSpaces;

public class ChangeBusinessOwnership {

    public void changeBusinessOwnership(int realmId){
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);
        // print out list of business names
        System.out.println("Business' currently in your realm are - ");
        System.out.println();
        new BusinessPhonenumbersDisplay().businessNamesDisplay(realmId);
        // get name of business to change ownership from user input
        System.out.println("\nType the name of the business that is changing ownership");
        String businessName = NameInputWithSpaces.nameInputWithSpaces();
        // get that buildings object
        BuildingDesign building = GetBuildingObjectByName.getBuilding(businessName, World.getBuildingsInTheWorld());
        if(building != null){
            // get name of the new owner
            System.out.println("List of your citizens -\n");
            DisplayCitizens.displayCitizens(realm.getCitizensObjects());
            System.out.println("\nType the name of the citizen that is the new owner");
            String newOwnersName = NameInput.nameInput();
            PersonDesign newOwnersObject = GetCitizensObjectByName.getCitizen(newOwnersName, realm.getCitizensObjects());
            // set new owner to the building
            if(newOwnersObject != null){
                building.setBusinessOwner(newOwnersObject.getId());
                building.setHomeOwnerOwner(newOwnersObject.getId());
                System.out.println(newOwnersName+" is the new owner of "+building.getName());
            }
        }
    }
}