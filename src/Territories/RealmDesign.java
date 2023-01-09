package Territories;

import Buildings.BuildingDesign;
import Enums.Gender;
import Persons.PersonDesign;
import Utilities.Buildings.GetBuildingObjectByName;
import Utilities.Population.GetCitizensObjectByName;
import Utilities.Realms.CheckIfRealmNameExists;
import Utilities.Realms.RealmsArmy;
import Utilities.Search.ArrayListSearch;
import Utilities.UserInputs.Inputs.NameInput;
import java.util.*;

public abstract class RealmDesign {

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////

    // id generated utilizing UUID class then hashing that in constructor
    private int realmId;
    // name of this realm
    private String realmName;
    // ArrayList that includes every person in this realm. Occurs as new person is created in each realm's addCitizen method
    private ArrayList<Integer> citizensIdOfThisRealm = new ArrayList<>();

    // population of this realm is size of citizensIdOfThisRealm ArrayList
    private int population;

    // the ruler of this realms id gets assigned here
    private int ruler = 1;
    // list of this realms buildings
    private ArrayList<BuildingDesign> buildingsOfThisRealm = new ArrayList<>();
    // this realms army
    private ArrayList<Integer> armyOfThisRealm = new ArrayList<>();

    //////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////

    protected RealmDesign(String name){
        // create an id for this realm
        this.realmId = UUID.randomUUID().hashCode();
        // checks if this realm name already exists. No duplicate names allowed
        setRealmName(name);
        // adding this realm to Worlds.realms occurs within this utility function
        new World().addRealmsInTheWorld(this.realmId, this);
    }

    //////////////////////////////////////////
    // ABSTRACT METHODS
    //////////////////////////////////////////

    public abstract void addCitizen(String name, Gender gender, boolean ruler);

    public abstract void addCitizen(String name, Gender gender);

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////
    // get realm Id
    public int getRealmId(){
        return this.realmId;
    }
    public String getRealmName(){
        return this.realmName;
    }

    // used locally in 'getRulerOfThisRealm'
    public int getRulerID(){
        return this.ruler;
    }
    // get the name of this realms ruler
    public String displayRulerOfThisRealm(){
        if(this.ruler == 1){
            return "This realm currently has no leader!";
        } else {
             return new World().getWorldsPeopleObjectsMAPPED().get(this.getRulerID()).getName();
        }
    }

    // get the population for this realm
    public int getPopulation(){
        return this.population;
    }

    //////////////////////////////////////////
    // SETTERS
    /////////////////////////////////////////

    public void setRealmName(String name){
        boolean doesNameExist = CheckIfRealmNameExists.DoesNameExist(name, World.getRealmsInTheWorld());
        if(doesNameExist){
            do{
                System.out.println("Realm name is already used. Enter another name..");
                String enterNewName = NameInput.nameInput();
                this.realmName = enterNewName;
                doesNameExist = CheckIfRealmNameExists.DoesNameExist(enterNewName, World.getRealmsInTheWorld());
            } while (doesNameExist);
        }else{
            this.realmName = name;
        }
    }

    // occurs in a realms addCitizen method
    public int setPopulation(){
        return this.population = this.citizensIdOfThisRealm.size();
    }

    // set RulerId back to 1 if current ruler is killed in battle
    public void setRulerId(){
        this.ruler = 1;
    }

    // setRuler is used when creating a new person using PersonDesign's setAsRuler() method
    public void setRuler(int personId){
        this.ruler = personId;
    }

    // set this realms army
    public void resetArmyOfThisRealm(){
        RealmDesign thisRealm = World.getRealmsInTheWorld().get(this.realmId);
        RealmsArmy.fetchRealmsArmy(thisRealm);
    }

    //////////////////////////////////////////
    // UTILITY GETTER
    /////////////////////////////////////////

    // returns only the id's of this realms citizens. intended use for world's hashmap of worlds citizens
    public ArrayList<Integer> getCitizensIdOfThisRealm(){
        return this.citizensIdOfThisRealm;
    }

    //get all citizen objects for this realm
    public ArrayList<PersonDesign> getCitizensObjects(){
        ArrayList<PersonDesign> thisRealmsCitizensObjects = new ArrayList<>();
        for(int id : this.citizensIdOfThisRealm){
            thisRealmsCitizensObjects.add(World.getWorldsPeopleObjectsMAPPED().get(id));
        }
        return thisRealmsCitizensObjects;
    }

    public PersonDesign getCitizenObjectByName(String name){
        return GetCitizensObjectByName.getCitizen(name, this.getCitizensObjects());
    }

    // get all building objects belonging to this realm
    public ArrayList<BuildingDesign> getBuildingObjects(){
        return this.buildingsOfThisRealm;
    }

    // get building object by name
    public BuildingDesign getBuildingObjectByName(String name){
        return GetBuildingObjectByName.getBuilding(name, this.getBuildingObjects());
    }

    // get soldiers id's in this realms army
    public ArrayList<Integer> getArmyOfThisRealm(){
        return this.armyOfThisRealm;
    }

    //////////////////////////////////////////
    // UTILITY METHODS
    /////////////////////////////////////////

    // add a citizen to the army
    public void conscriptCitizenIntoArmy(Integer citizensId){
        this.armyOfThisRealm.add(citizensId);
    }

    // remove conscript from army
    public void removeConscriptFromArmy(Integer citizensId){
        int placeHolder = new ArrayListSearch().arrayListSearch(armyOfThisRealm, citizensId);
        armyOfThisRealm.remove(placeHolder);
    }

    // add a building to this realm
    public void addBuildingToThisRealm(BuildingDesign building){
        this.buildingsOfThisRealm.add(building);
    }

    // remove citizen from this realms citizen list
    public void removeCitizenFromRealm(int citizensId){
        int placeHolder = new ArrayListSearch().arrayListSearch(citizensIdOfThisRealm, citizensId);
        citizensIdOfThisRealm.remove(placeHolder);
    }

    // toString method returns the name of the realm
    public String toString(){
        return this.realmName;
    }
}
