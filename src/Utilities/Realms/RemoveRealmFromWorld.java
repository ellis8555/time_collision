package Utilities.Realms;

import Buildings.BuildingDesign;
import Territories.GermanicRegion.GermanicRealm;
import Territories.RealmDesign;
import Territories.RomanRegion.RomanRealm;
import Territories.World;

import java.util.ArrayList;

public class RemoveRealmFromWorld {

    public void removeRealmFromWorld(RealmDesign realmsObject){

        int realmsId = realmsObject.getRealmId();

        // remove building from worlds list of buildings
        ArrayList<BuildingDesign> realmsBuildingObjects = realmsObject.getBuildingObjects();
        for(BuildingDesign building : realmsBuildingObjects){
            int buildingId = building.getBuildingId();
            World.removeBuilding(buildingId);
        }
        // clear realms building list
        realmsBuildingObjects.clear();

        if(realmsObject instanceof GermanicRealm){
            GermanicRealm.decrementGermanicRealmCount();
            GermanicRealm.removeGermanicRealm(realmsId);
        }else{
            RomanRealm.decrementRomanRealmCount();
            RomanRealm.removeRomanRealm(realmsId);
        }

        // remove the realm from worlds list of realms
        World.removeRealm(realmsId);

        // end of removeRealmFromWorld method
    }
    // end of class
}
