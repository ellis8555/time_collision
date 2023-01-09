package Utilities.Population;


import Buildings.BuildingDesign;
import Persons.GermanicPeople.GermanicPerson;
import Persons.PersonDesign;
import Territories.GermanicRegion.GermanicRealm;
import Territories.RealmDesign;
import Territories.RomanRegion.RomanRealm;
import Territories.World;
import Utilities.Search.ArrayListSearch;

import java.util.ArrayList;

public class RemoveCitizen {

    public void removeCitizen(int citizenId, ArrayList<Integer> realmsArmy, RealmDesign realm){
        // citizens object
        PersonDesign citizensObject = World.getWorldsPeopleObjectsMAPPED().get(citizenId);
        // get type of citizen.
        boolean isGermanic;
        if(citizensObject instanceof GermanicPerson) {
            isGermanic = true;
        } else {
            isGermanic = false;
        }

        /////////////////////////////////
        // remove buildings of citizen
        /////////////////////////////////

        // get building id of citizens home
        int citizensHomeId = citizensObject.getOriginalHomeAddress();
        // set count and marking variables to determine location in arrayList of citizens home building object
        int count = 0;
        int homeBuildingLocation = 0;
        // cycle through realms building objects to obtain location of citizens home object
        for(BuildingDesign building : realm.getBuildingObjects()){
            if(building.getBuildingId() == citizensHomeId){
                homeBuildingLocation = count;
            }
            if(building.getBusinessOwner() == citizenId){
                building.setBusinessOwner(1);
            }
            count++;
        }
        // remove citizens home building object from realms building arrayList
        realm.getBuildingObjects().remove(homeBuildingLocation);

        // remove building from worlds buildings arrayLists
        World.getBuildingsInTheWorld().remove(citizensHomeId);

        ////////////////////////////////////////
        // remove citizen from population lists
        ////////////////////////////////////////

        if(realmsArmy.contains(citizenId)){
            // 1. remove citizen from realms army list if is a soldier
            int placeHolder = new ArrayListSearch().arrayListSearch(realmsArmy, citizenId);
            realmsArmy.remove(placeHolder);
        }
        // 2. remove citizen from realms citizen list
        realm.removeCitizenFromRealm(citizenId);
        // reset attacking realms army no longer including removed soldiers id
        realm.resetArmyOfThisRealm();
        // 3. remove from corresponding realm types citizenId arrayList
        // reduce corresponding realm types population by one
        if(isGermanic){
            GermanicRealm.removeGermanicCitizen(citizenId);
            GermanicRealm.decrementGermanicCitizenCount();
        }else{
            RomanRealm.removeRomanCitizen(citizenId);
            RomanRealm.decrementRomanCitizenCount();
        }
        // 4. remove from worlds arrayList of people
        World.getWorldsPeopleObjectsMAPPED().remove(citizenId);
    }
}
