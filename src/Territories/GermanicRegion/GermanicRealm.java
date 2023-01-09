package Territories.GermanicRegion;

import Enums.Gender;
import Enums.realmAreacodes;
import Persons.GermanicPeople.GermanicPerson;
import Persons.PersonDesign;
import Territories.RealmDesign;
import Territories.World;
import Utilities.Phones.AreaCodes;
import Utilities.Search.ArrayListSearch;

import java.util.ArrayList;
import java.util.UUID;

public class GermanicRealm extends RealmDesign {

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////

    // ArrayList of germanic realms by id
    private static ArrayList<Integer> germanicRealms = new ArrayList<>();

    // how many germanic realms there are is size of germanicRealms ArrayList.
    // this is incremented upon GermanicRealm constructor creation
    private static int germanicRealmCount = 0;

    // ArrayList of all germanic persons by id
    private static ArrayList<Integer> germanicCitizens = new ArrayList<>();

    // how many germanic citizens have been created
    // this is incremented upon a germanic citizen creation
    private static int germanicCitizenCount;

    // area code this realm
    private int thisRealmsAreacode = realmAreacodes.GERMANIC.getAreaCode();

    //////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////
    public GermanicRealm(String name){
        super(name);
        // add this realmsId to germanicRealms ArrayList
        germanicRealms.add(this.getRealmId());
        // add this realms area code to areaCodes list
        AreaCodes.addRealmToDirectory(name, thisRealmsAreacode);
        // update how many germanic realms exist
        incrementGermanicRealmCount();
    }

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    // get list of germanic persons by id
    public static ArrayList<Integer> getGermanicCitizens(){
        return germanicCitizens;
    }

    // get list of germanic realms by id
    public static ArrayList<Integer> getGermanicRealms(){
        return germanicRealms;
    }

    // get the count of how many germanic realms that have been created
    public static int getGermanicRealmCount(){ return germanicRealmCount;};

    // get germanic citizens objects
    public static ArrayList<PersonDesign> getGermanicCitizensObjects(){
        ArrayList<PersonDesign> germanicCitizenObjects = new ArrayList<>();
        for(int id : germanicCitizens){
            germanicCitizenObjects.add(World.getWorldsPeopleObjectsMAPPED().get(id));
        }
        return germanicCitizenObjects;
    }

    // get the count of how many germanic realms that have been created
    public static int getGermanicCitizenCount(){ return germanicCitizenCount;};

    public int getThisRealmsAreacode(){
        return this.thisRealmsAreacode;
    }

    //////////////////////////////////////////
    // SETTERS
    /////////////////////////////////////////

    public static void incrementGermanicRealmCount(){
        GermanicRealm.germanicRealmCount++;
    }

    public static void decrementGermanicRealmCount(){
        --GermanicRealm.germanicRealmCount;
    }

    public static void incrementGermanicCitizenCount(){
         ++GermanicRealm.germanicCitizenCount;
    }

    public static void decrementGermanicCitizenCount(){
         --GermanicRealm.germanicCitizenCount;
    }


    //////////////////////////////////////////
    // UTILITY FUNCTIONS
    /////////////////////////////////////////


    // ADD A RULER TO THIS REALM
    public void addCitizen(String name, Gender gender, boolean ruler){
        UUID uuid = UUID.randomUUID();
        int id = uuid.hashCode();
        int realmId = this.getRealmId();
        PersonDesign newPerson = new GermanicPerson(id, name, gender, realmId, ruler);
        germanicCitizens.add(id);
        if(ruler){
            newPerson.setAsRuler();
        }
        this.getCitizensIdOfThisRealm().add(id);
        this.setPopulation();
        incrementGermanicCitizenCount();
    }

    // ADD A CITIZEN TO THIS REALM
    public void addCitizen(String name, Gender gender){
        UUID uuid = UUID.randomUUID();
        int id = uuid.hashCode();
        int realmId = this.getRealmId();
        PersonDesign newPerson = new GermanicPerson(id, name, gender, realmId);
        germanicCitizens.add(id);
        this.getCitizensIdOfThisRealm().add(id);
        this.setPopulation();
        incrementGermanicCitizenCount();
    }

    // remove a germanic realm
    public static void removeGermanicRealm(int realmId){
        int placeHolder = new ArrayListSearch().arrayListSearch(germanicRealms, realmId);
        germanicRealms.remove(placeHolder);
    }
    // remove germanic citizen
    public static void removeGermanicCitizen(int citizenId){
        int placeHolder = new ArrayListSearch().arrayListSearch(germanicCitizens, citizenId);
        germanicCitizens.remove(placeHolder);
    }
}
