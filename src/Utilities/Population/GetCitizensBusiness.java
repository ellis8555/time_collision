package Utilities.Population;

import Buildings.BuildingDesign;
import Territories.RealmDesign;
import Territories.World;

import java.util.ArrayList;

public class GetCitizensBusiness {

    public String getCitizensBusiness(int citizenId, int realmId) {

        // string that will hold the final output of business names this person owns
        StringBuilder businessNames = new StringBuilder();

         // get the realm object
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);

        // get list of business' in the realm
        ArrayList<BuildingDesign> buildingsList = realm.getBuildingObjects();

        // create empty list to hold citizens business interests
        ArrayList<String> citizensBusinessOwned = new ArrayList<>();

        // loop through the realms buildings to find matches of citizenId and buildings business owner Id
        for(BuildingDesign building : buildingsList){
            if(citizenId == building.getBusinessOwner()){
                citizensBusinessOwned.add(building.getName());
            }
            // end of loop
        }

        // depending on how many business the individual owns output appropriate string
        int numberOfBusinessOwned = citizensBusinessOwned.size();
        switch(numberOfBusinessOwned){
            case 1:
                businessNames.append(citizensBusinessOwned.get(0));
                break;
            case 2:
                businessNames.append(citizensBusinessOwned.get(0)+" and "+citizensBusinessOwned.get(1));
                break;
            default:
                for(int i=0;i<numberOfBusinessOwned-1;i++){
                    businessNames.append(citizensBusinessOwned.get(i)+", ");
                }
                businessNames.append("and "+citizensBusinessOwned.get(numberOfBusinessOwned-1));
        }
        return businessNames.toString();
    }
}
