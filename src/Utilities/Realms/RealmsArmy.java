package Utilities.Realms;

import Persons.PersonDesign;
import Territories.GermanicRegion.GermanicRealm;
import Territories.RealmDesign;
import java.util.ArrayList;


public class RealmsArmy {
    public static void fetchRealmsArmy(RealmDesign realm){
        // remove any soldiers that had their occupation changed from warrior to something else
        realm.getArmyOfThisRealm().clear();
        ArrayList<PersonDesign> citizens = realm.getCitizensObjects();
        boolean isGermanic = realm instanceof GermanicRealm;
        if(isGermanic){
             citizens.stream().filter(element->element.getOccupation().toString() == "warrior").forEach(element->realm.conscriptCitizenIntoArmy(element.getId()));

        }else{
            citizens.stream().filter(element->element.getOccupation().toString() == "centurion").forEach(element->realm.conscriptCitizenIntoArmy(element.getId()));
        }
    }
}
