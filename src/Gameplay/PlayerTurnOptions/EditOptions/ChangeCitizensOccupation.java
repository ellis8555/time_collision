package Gameplay.PlayerTurnOptions.EditOptions;

import Enums.Occupations.GermanicSkills;
import Enums.Occupations.RomanSkills;
import Persons.PersonDesign;
import Territories.GermanicRegion.GermanicRealm;
import Territories.RealmDesign;
import Territories.World;
import Utilities.Population.DisplayCitizens;
import Utilities.Population.GetCitizensObjectByName;
import Utilities.UserInputs.Inputs.NameInput;
import Utilities.UserInputs.Inputs.NumberWithRangeInput;

public class ChangeCitizensOccupation {

    public boolean changeCitizensOccupation(Integer realmId){
        Enum occupation;
        boolean endTurn = false;
        // get realm
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);
        // display list of this realms citizesn
        System.out.println("List of your citizens");
        DisplayCitizens.displayCitizens(realm.getCitizensObjects());
        // get user input for which citizen
        System.out.println("Enter name of which citizen you're changing their occupation");
        String nameToChange = NameInput.nameInput();
        try{
            PersonDesign person = GetCitizensObjectByName.getCitizen(nameToChange, World.getRealmsInTheWorld().get(realmId).getCitizensObjects());
            RealmDesign realmPersonBelongsTo = World.getRealmsInTheWorld().get(person.getRealmPersonBelongsTo());
            if(realmPersonBelongsTo instanceof GermanicRealm){
                System.out.println("1. Blacksmith\n2. Cook\n3. Weaver\n4. Seamstress\n5. Woodworker\n6. Warrior");
                System.out.println("Enter the corresponding number to change occupation");
                int selectionNumber = NumberWithRangeInput.numberWithRangeInput(6);
                switch(selectionNumber){
                    case 1:
                        occupation = GermanicSkills.BLACKSMITH;
                        break;
                    case 2:
                        occupation = GermanicSkills.COOK;
                        break;
                    case 3:
                        occupation = GermanicSkills.WEAVER;
                        break;
                    case 4:
                        occupation = GermanicSkills.SEAMSTRESS;
                        break;
                    case 5:
                        occupation = GermanicSkills.WOODWORKER;
                        break;
                    case 6:
                        person.setTimeBeginServiceInArmy();
                        occupation = GermanicSkills.WARRIOR;
                        endTurn = true;
                        break;
                    default:
                        occupation = GermanicSkills.PEASANT;
                }
                person.setOccupation(occupation);
            }else{
                System.out.println("1. Teacher\n2. Blacksmith\n3. Weaver\n4. Chef\n5. Equestrian Rider\n6. Centurion");
                System.out.println("Enter the corresponding number to change occupation");
                int selectionNumber = NumberWithRangeInput.numberWithRangeInput(6);
                switch(selectionNumber){
                    case 1:
                        occupation = RomanSkills.TEACHER;
                        break;
                    case 2:
                        occupation = RomanSkills.BLACKSMITH;
                        break;
                    case 3:
                        occupation = RomanSkills.WEAVER;
                        break;
                    case 4:
                        occupation = RomanSkills.CHEF;
                        break;
                    case 5:
                        occupation = RomanSkills.EQUESTRIAN_RIDER;
                        break;
                    case 6:
                        person.setTimeBeginServiceInArmy();
                        occupation = RomanSkills.CENTURION;
                        endTurn = true;
                        break;
                    default:
                        occupation = RomanSkills.SLAVE;
                }
                person.setOccupation(occupation);
            }
        }catch(Exception e){
            System.out.println("That person doesn't exist.");
        }
        return endTurn;
    }
}
