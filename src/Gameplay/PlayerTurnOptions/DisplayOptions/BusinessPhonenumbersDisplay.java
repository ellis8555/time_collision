package Gameplay.PlayerTurnOptions.DisplayOptions;

import Buildings.BuildingDesign;
import Territories.RealmDesign;
import Territories.World;
import Utilities.Sorting.BuildingNameSort;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BusinessPhonenumbersDisplay {

    public void businessPhonenumbersDisplay(Integer realmId){
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);
        List<BuildingDesign> buildings = (List<BuildingDesign>) realm.getBuildingObjects();

        BuildingNameSort buildingNameSort = new BuildingNameSort();
        Collections.sort(buildings, buildingNameSort);
        List<String> buildingsList = buildings.stream().filter(element ->
                element.getBuildingType() != "dwelling"
        ).filter(element -> element.getBuildingType() != "home").map(
                element -> {
                    String businessName = element.getName();
                    String address = String.valueOf(element.getBuildingId());
                    String phoneNumber = element.getPhoneNumber();
                    String realmName = realm.getRealmName();
                    int ownerId = element.getOwnerOfHome();
                    StringBuilder ownersName = new StringBuilder();
                    if(ownerId == 1){
                        return String.format("%1$s - %3$s | Address: %2$s, %4$s", businessName, address, phoneNumber, realmName);
                    }else{
                        ownersName.append(World.getWorldsPeopleObjectsMAPPED().get(ownerId).getName());
                        return String.format("%1$s - %3$s | Address: %2$s, %4$s | Owner: %5$s", businessName, address, phoneNumber, realmName, ownersName.toString());
                    }
                }).collect(Collectors.toList());
        buildingsList.forEach(element -> System.out.println(element));
        // if custom realm and a building has not been manually created then building list will contain no busniess'
        if(buildingsList.size()==0){
            System.out.println("Your realm currently does not have an up and running business. You need to create a building via main menu.");
        }
    }

    public void businessNamesDisplay(Integer realmId){
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);
        List<BuildingDesign> buildings = (List<BuildingDesign>) realm.getBuildingObjects();

        BuildingNameSort buildingNameSort = new BuildingNameSort();
        Collections.sort(buildings, buildingNameSort);
        List<String> buildingsList = buildings.stream().filter(element ->
                element.getBuildingType() != "dwelling"
        ).filter(element -> element.getBuildingType() != "home").map(
                element -> {
                    String businessName = element.getName();
                    String address = String.valueOf(element.getBuildingId());
                    return String.format("%1$s | Address: %2$s", businessName, address);
                }).collect(Collectors.toList());
        buildingsList.forEach(element -> System.out.println(element));
        // if custom realm and a building has not been manually created then building list will contain no busniess'
        if(buildingsList.size()==0){
            System.out.println("Your realm currently does not have an up and running business. You need to create a building via main menu.");
        }
    }
}
