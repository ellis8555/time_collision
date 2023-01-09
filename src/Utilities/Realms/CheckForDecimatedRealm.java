package Utilities.Realms;

import Territories.RealmDesign;
import Territories.World;

public class CheckForDecimatedRealm{

    public boolean checkForDecimatedRealm(int realmId){

        boolean isDecimated = false;

        // try to get a realm

        try {
            // get realm
            RealmDesign realm = World.getRealmsInTheWorld().get(realmId);
            int population = realm.getPopulation();
            if(population == 0){
                isDecimated = true;
            }
            //
        }catch(NullPointerException e){
            isDecimated = true;
        }
        return isDecimated;
    }
}
