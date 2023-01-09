package Territories.RomanRegion;

import Enums.Gender;
import Enums.realmAreacodes;
import Persons.PersonDesign;
import Persons.RomanPeople.RomanPerson;
import Territories.RealmDesign;
import Territories.World;
import Utilities.Phones.AreaCodes;
import Utilities.Search.ArrayListSearch;

import java.util.ArrayList;
import java.util.UUID;

public class RomanRealm extends RealmDesign{

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////

    // ArrayList of roman realms by id
    private static ArrayList<Integer> romanRealms = new ArrayList<>();

    // how many roman realms there are is size of romanRealms ArrayList.
    // this is incremented upon romanRealm constructor creation
    private static int romanRealmCount = 0;

    // ArrayList of all roman persons by id
    private static ArrayList<Integer> romanCitizens = new ArrayList<>();

    // how many roman citizens have been created
    // this is incremented upon a roman citizen creation
    private static int romanCitizenCount;

    // area code this realm
    private int thisRealmsAreacode = realmAreacodes.ROME.getAreaCode();

    //////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////
    public RomanRealm(String name){
        super(name);
        // add this realmsId to germanicRealms ArrayList
        romanRealms.add(this.getRealmId());
        // add this realms area code to areaCodes list
        AreaCodes.addRealmToDirectory(name, thisRealmsAreacode);
        // update how many germanic realms exist
        incrementRomanRealmCount();
    }

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    // get list of roman persons by id
    public static ArrayList<Integer> getRomanCitizens(){
        return romanCitizens;
    }

    // get list of roman realms by id
    public static ArrayList<Integer> getRomanRealms(){
        return romanRealms;
    }

    // get the count of how many roman realms that have been created
    public static int getRomanRealmCount(){ return romanRealmCount;};

    // get roman citizens objects
    public static ArrayList<PersonDesign> getRomanCitizensObjects(){
        ArrayList<PersonDesign> romanCitizenObjects = new ArrayList<>();
        for(int id : romanCitizens){
            romanCitizenObjects.add(World.getWorldsPeopleObjectsMAPPED().get(id));
        }
        return romanCitizenObjects;
    }

    // get the count of how many roman realms that have been created
    public static int getRomanCitizenCount(){ return romanCitizenCount;};

    public int getThisRealmsAreacode(){
        return this.thisRealmsAreacode;
    }

    //////////////////////////////////////////
    // SETTERS
    /////////////////////////////////////////

    public static void incrementRomanRealmCount(){
        RomanRealm.romanRealmCount++;
    }

    public static void decrementRomanRealmCount(){
        RomanRealm.romanRealmCount--;
    }

    public static void incrementRomanCitizenCount(){
        RomanRealm.romanCitizenCount++;
    }

    public static void decrementRomanCitizenCount(){
        RomanRealm.romanCitizenCount--;
    }

    //////////////////////////////////////////
    // UTILITY FUNCTIONS
    /////////////////////////////////////////


    // ADD A RULER TO THIS REALM
    public void addCitizen(String name, Gender gender, boolean ruler){
        UUID uuid = UUID.randomUUID();
        int id = uuid.hashCode();
        int realmId = this.getRealmId();
        PersonDesign newPerson = new RomanPerson(id, name, gender, realmId, ruler);
        romanCitizens.add(id);
        if(ruler){
            newPerson.setAsRuler();
        }
        this.getCitizensIdOfThisRealm().add(id);
        this.setPopulation();
        incrementRomanCitizenCount();
    }

    // ADD A CITIZEN TO THIS REALM
    public void addCitizen(String name, Gender gender){
        UUID uuid = UUID.randomUUID();
        int id = uuid.hashCode();
        int realmId = this.getRealmId();
        PersonDesign newPerson = new RomanPerson(id, name, gender, realmId);
        romanCitizens.add(id);
        this.getCitizensIdOfThisRealm().add(id);
        this.setPopulation();
        incrementRomanCitizenCount();
    }

    // remove a roman realm
    public static void removeRomanRealm(int realmId){
        int placeHolder = new ArrayListSearch().arrayListSearch(romanRealms, realmId);
        romanRealms.remove(placeHolder);
    }
    public static void removeRomanCitizen(int citizenId){
        int placeHolder = new ArrayListSearch().arrayListSearch(romanCitizens, citizenId);
        romanCitizens.remove(placeHolder);
    }

}