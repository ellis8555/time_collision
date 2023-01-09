package Territories;

import Buildings.BuildingDesign;
import Persons.PersonDesign;
import Utilities.Buildings.GetBuildingObjectByName;
import Utilities.Population.GetCitizensObjectByName;
import Utilities.Realms.GetRealmObjectByName;

import java.util.*;

public class World {

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////

    // when a new person is created they are mapped here by Id to their object
    // occurs in class PersonDesign constructor
    private static HashMap<Integer, PersonDesign> worldsPeopleObjectsMAPPED = new HashMap<>();
    // worldPopulation is size of worldsPeopleObjects HashMap within this World class

    // when a new realm object is created the name of that newly created realm is placed in this map
    // occurs in setName() method upon a realms creation in realm classes
    private static HashMap<Integer, RealmDesign> realmsInTheWorldMAPPED = new HashMap<>();

    // when a new building object is created that building is placed in here
    private static HashMap<Integer, BuildingDesign> buildingsInTheWorldMAPPED = new HashMap<>();

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////


    // get realms of the world from arrayList
    public static ArrayList<RealmDesign> getRealmObjects(){
        ArrayList<RealmDesign> realmsOfTheWorld = new ArrayList<>();
        for(RealmDesign realm : getRealmsInTheWorld().values()){
            realmsOfTheWorld.add(realm);
        }
        return realmsOfTheWorld;
    }

    // get persons object from world map ArrayList
    public static HashMap<Integer, PersonDesign> getWorldsPeopleObjectsMAPPED() {
        return worldsPeopleObjectsMAPPED;
    }

    // get entire worlds citizen objects
    public static ArrayList<PersonDesign> getWorldsCitizensObjects(){
        ArrayList<PersonDesign> worldsCitizens = new ArrayList<>();
        for(PersonDesign person : getWorldsPeopleObjectsMAPPED().values()){
            worldsCitizens.add(person);
        }
        return worldsCitizens;
    }

    // get entire worlds building objects
    public static ArrayList<BuildingDesign> getWorldsBuildingsObjects(){
        ArrayList<BuildingDesign> worldsBuildings = new ArrayList<>();
        for(BuildingDesign building : getBuildingsInTheWorld().values()){
            worldsBuildings.add(building);
        }
        return worldsBuildings;
    }

    // get entire world's population
    public static int getWorldPopulation() {
        return worldsPeopleObjectsMAPPED.size();
    }

    // get list of realms objects
    public static HashMap<Integer, RealmDesign> getRealmsInTheWorld() {
        return realmsInTheWorldMAPPED;
    }

    // get list of building objects
    public static HashMap<Integer, BuildingDesign> getBuildingsInTheWorld(){return buildingsInTheWorldMAPPED;}

    // get how many realms exist
    public static int getRealmCount() {
        return realmsInTheWorldMAPPED.size();
    }

    //////////////////////////////////////////
    // UTILITY METHODS
    /////////////////////////////////////////

    // occurs in class PersonDesign constructor
    public void addWorldsPeopleObjects(Integer id, PersonDesign person) {
        worldsPeopleObjectsMAPPED.put(id, person);
    }

    // occurs in class RealmDesign constructor
    public void addRealmsInTheWorld(Integer id, RealmDesign realm) {
        realmsInTheWorldMAPPED.put(id, realm);
    }

    // occurs in class BuildingDesign constructor
    public void addBuildingsInTheWorld(Integer id, BuildingDesign building){buildingsInTheWorldMAPPED.put(id, building);}

    // remove building from worlds building list
    public static void removeBuilding(int buildingId){
        buildingsInTheWorldMAPPED.remove(buildingId);
    }

    public static void removeRealm(int realmId){
        realmsInTheWorldMAPPED.remove(realmId);
    }

    // get any citizen object in the world by name
    public static PersonDesign getCitizenByName(String name){
        return GetCitizensObjectByName.getCitizen(name, getWorldsPeopleObjectsMAPPED());
    }

    // get a building by its name
    public static BuildingDesign getBuildingByName(String name){
        return GetBuildingObjectByName.getBuilding(name, getWorldsBuildingsObjects());
    }

    // get any realms object from the world by name
    public static RealmDesign getRealmByName(String name){
        return GetRealmObjectByName.getRealm(name);
    }

}