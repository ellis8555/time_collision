package Gameplay.PlayerTurnOptions.EditOptions;

import Persons.PersonDesign;
import Territories.GermanicRegion.GermanicRealm;
import Territories.RealmDesign;
import Territories.World;
import Utilities.Population.DisplayCitizens;
import Utilities.Population.GetCitizensObjectByName;
import Utilities.UserInputs.Inputs.NameInput;

public class SetANewRuler {

    public void setANewRuler(Integer realmId){
        // get realm object to determine if germanic or roman
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);
        // display list of this realms citizesn
        System.out.println("List of your citizens");
        DisplayCitizens.displayCitizens(realm.getCitizensObjects());
        // get user input for which citizen
        System.out.println("Enter name of which citizen you'd like to crown");
        String name = NameInput.nameInput();
        try{
            PersonDesign person = GetCitizensObjectByName.getCitizen(name, World.getRealmsInTheWorld().get(realmId).getCitizensObjects());
            person.setAsRuler();
            if(realm instanceof GermanicRealm){
                System.out.println(World.getRealmsInTheWorld().get(realmId).displayRulerOfThisRealm()+" is the Chieftain of realm!");
            }else{
                System.out.println(World.getRealmsInTheWorld().get(realmId).displayRulerOfThisRealm()+" is Caesar of the realm!");
            }

        }catch(Exception e){
            System.out.println("That person doesn't exist.");
        }
    }

}
