package Utilities.Population;

import Territories.RealmDesign;
import Territories.World;

import java.util.ArrayList;

public class IsCitizenEnlistedInArmy {

    public boolean isCitizenEnlistedInArmy(int citizenId, int realmId){
        // get citizens realm
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);
        // get realms army list
        realm.resetArmyOfThisRealm();
        ArrayList<Integer> realmsArmy = realm.getArmyOfThisRealm();
        // check if citizen is enlisted
        boolean isEnlisted = realmsArmy.contains(citizenId);
        return isEnlisted;
    }
}
