package Utilities.Buildings;

import Buildings.BuildingDesign;
import Territories.World;
import Utilities.UserInputs.Inputs.NumberInput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GetBuildingObjectByName {

    public static BuildingDesign getBuilding(String name, ArrayList<BuildingDesign> buildings) throws IndexOutOfBoundsException {
        BuildingDesign building = null;
        try {
            List<BuildingDesign> nameMatches = buildings.stream().filter(element -> element.getName().equals(name)).collect(Collectors.toList());
            if (nameMatches.size() == 0) {
                throw new IndexOutOfBoundsException("There is no building by that name in the realm...");
            } else if (nameMatches.size() == 1) {
                building = nameMatches.get(0);
            } else {
                System.out.println("There are " + nameMatches.size() + " " + name + "'s in this realm.\nSelect which " + name + " you are referring to..");
                for(int i=0;i < nameMatches.size();i++){
                    int index = i+1;
                    String cellNumber = nameMatches.get(i).getPhoneNumber();
                    long buildingsAge = nameMatches.get(i).getAgeInMillis();
                    String buildingDescription = String.format("%1$d. Phone#: %2$-11s Age: %3$d milliseconds",index , cellNumber, buildingsAge);
                    System.out.println(buildingDescription);
                }
                int selectionChoice = NumberInput.numberInput();
                building = nameMatches.get(selectionChoice-1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return building;
    }

    // get business object from entire world by name
    public static BuildingDesign getBuilding(String name, HashMap<Integer, BuildingDesign> buildings) throws IndexOutOfBoundsException{
        // get ids for each realm that exists and put them into an ArrayList
        ArrayList<Integer> buildingIds = new ArrayList<>();
        for(Integer buildingId : buildings.keySet()){
            buildingIds.add(buildingId);
        }
        // get each realm's object and put those objects into an ArrayList
        ArrayList<BuildingDesign> buildingObjects = new ArrayList<>();
        for(Integer id : buildingIds){
            buildingObjects.add(buildings.get(id));
        }
        BuildingDesign building = null;
        try {
            List<BuildingDesign> nameMatches = buildingObjects.stream()
                    .filter(element -> element.getBuildingType() != "dwelling")
                    .filter(element -> element.getBuildingType() != "home")
                    .filter(element -> element.getName().equals(name))
                    .collect(Collectors.toList());
            if (nameMatches.size() == 0) {
                throw new IndexOutOfBoundsException("There is no building by that name in the realm...");
            } else if (nameMatches.size() == 1) {
                building = nameMatches.get(0);
            } else {
                System.out.println("There are " + nameMatches.size() + " " + name + "'s in the world.\nSelect which " + name + " you are referring to..");
                for(int i=0;i < nameMatches.size();i++){
                    int index = i+1;
                    String cellNumber = nameMatches.get(i).getPhoneNumber();
                    String realmName = World.getRealmsInTheWorld().get(nameMatches.get(i).getRealmBuildingBelongsTo()).getRealmName();
                    long buildingsAge = nameMatches.get(i).getAgeInMillis();
                    String buildingDescription = String.format("%1$d. Phone#: %2$-11s Age: %3$d milliseconds Realm: %4$s",index , cellNumber, buildingsAge, realmName);
                    System.out.println(buildingDescription);
                }
                int selectionChoice = NumberInput.numberInput();
                building = nameMatches.get(selectionChoice-1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return building;
    }
}

