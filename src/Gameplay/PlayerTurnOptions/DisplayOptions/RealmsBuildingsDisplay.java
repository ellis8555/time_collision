package Gameplay.PlayerTurnOptions.DisplayOptions;

import Buildings.BuildingDesign;
import Territories.RealmDesign;
import Territories.World;

import java.util.ArrayList;

public class RealmsBuildingsDisplay {

    public void displayRealmsBuildings(Integer realmId) throws NoSuchMethodException {
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);
        ArrayList<BuildingDesign> buildings = realm.getBuildingObjects();
        for(BuildingDesign building : buildings){
            System.out.println(building);
        }
    }

}
