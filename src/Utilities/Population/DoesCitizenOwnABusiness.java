package Utilities.Population;

import Buildings.BuildingDesign;
import Territories.RealmDesign;
import Territories.World;

import java.util.ArrayList;

public class DoesCitizenOwnABusiness {

    public boolean doesCitizenOwnABusiness(int citizenId, int realmId) {

        // boolean to return
        boolean doesCitizenOwnABusiness = false;

        // get realm of citizen
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);

        // get arrayList of realms building objects
        ArrayList<BuildingDesign> buildings = realm.getBuildingObjects();

        // loop through realms buildings to find if citizen owns a business building
        for(BuildingDesign building : buildings) {
                if(citizenId == building.getBusinessOwner()){
                    doesCitizenOwnABusiness = true;
                }
            }
        return doesCitizenOwnABusiness;
    }
}
