package Persons;
import Enums.Gender;
import Enums.Occupations.GermanicSkills;
import Enums.Occupations.RomanSkills;
import Persons.GermanicPeople.GermanicPerson;
import Territories.GermanicRegion.GermanicRealm;
import Territories.RealmDesign;
import Territories.World;
import Utilities.CreationStamps.CreationInstanceDetails;
import Utilities.CreationStamps.CreationInstance;
import Utilities.Durations.DisplayAge;
import Utilities.Durations.DisplayTimeServedInArmy;
import Utilities.Durations.DurationInMillis;
import java.time.Instant;
import java.time.LocalDateTime;

public abstract class PersonDesign implements PersonDesignInterface{

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////

    private int id;
    private String name;
    private String gender;
    private LocalDateTime dateTimeOfBirth;
    private boolean isRulerOfTheRealm = false;
    private int realmPersonBelongsTo;
    private LocalDateTime timeBeginServiceInArmy;

    //////////////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////////////

    protected PersonDesign(int id, String name, Gender gender, int realmPersonBelongsTo){
        // set id for this person
        this.id = id;
        // set first name
        this.name = name;
        // set gender
        this.gender = String.valueOf(gender);
        // get an instance of time for this objects creation
        this.dateTimeOfBirth = new CreationInstance(Instant.now()).setCreationInstant();
        // add this persons realms name they belong to. This value occurs in each realm's add citizen method
        this.realmPersonBelongsTo = realmPersonBelongsTo;
        // add statistics to the worlds population
        // add person id mapped to their object
        new World().addWorldsPeopleObjects(id, this);

    }

    protected PersonDesign(int id, String name, Gender gender, int realmPersonBelongsTo, boolean isRuler){
        // set id for this person
        this.id = id;
        // set first name
        this.name = name;
        // set gender
        this.gender = String.valueOf(gender);
        // set this person as ruler of the realm
        this.isRulerOfTheRealm = isRuler;
        // get an instance of time for this objects creation
        this.dateTimeOfBirth = new CreationInstance(Instant.now()).setCreationInstant();
        // add this persons realms name they belong to
        this.realmPersonBelongsTo = realmPersonBelongsTo;
        // add statistics to the worlds population
        // add person id mapped to their object
        new World().addWorldsPeopleObjects(id, this);
    }

    //////////////////////////////////////////////////////////////////////
    // ABSTRACT METHODS
    // these methods require properties that are specific to their realm
    //////////////////////////////////////////////////////////////////////

    // get homePhoneNumber of person
    public abstract String getHomePhoneNumber();
    // get cell phone number of person
    public abstract String getCellNumber();
    public abstract Enum getOccupation();

    // change phone number to custom number
    public abstract void setCellNumber(String newNumber, String oldNumber);

    // set occupation for this person
    public abstract void setOccupation(Enum occupation);


    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    // get realmId this person belongs to
    public int getRealmPersonBelongsTo(){
        return this.realmPersonBelongsTo;
    }
    // get gender
    public String getGender(){
        return String.valueOf(gender);
    }

    // get date of birth
    public String getDateOfBirth(){
        return CreationInstanceDetails.getBirthDate(dateTimeOfBirth);
    }

    // get time of birth
    public String getTimeOfBirth(){
        return CreationInstanceDetails.getBirthTime(dateTimeOfBirth);
    }

    // get persons age
    public long getAgeInMillis(){
        return new DurationInMillis().getDurationInMillis(dateTimeOfBirth);
    }

    // display persons age
    public String displayAge(){
        return new DisplayAge().displayAge(getAgeInMillis());
    }

    // see if this is the ruler or leader of the realm
    public boolean getIsRulerOfTheRealm(){
        return isRulerOfTheRealm;
    }

    // get
    public LocalDateTime getTimeBeginServiceInArmy(){
        return timeBeginServiceInArmy;
    }

    /////////////////////
    // SETTERS
    ////////////////////

    // set name
    public void setName(String name){
        this.name = name;
    }

    // make ruler
    public void setAsRuler(){
        World world = new World();
        RealmDesign realm = world.getRealmsInTheWorld().get(getRealmPersonBelongsTo());
        int previousRulersId = realm.getRulerID();
        realm.setRuler(this.id);
        this.isRulerOfTheRealm = true;
        // this part sets the persons status as corresponding ruling title
        PersonDesign thisPerson = World.getWorldsPeopleObjectsMAPPED().get(id);
        PersonDesign previousRulersObject = world.getWorldsPeopleObjectsMAPPED().get(previousRulersId);
        if(thisPerson != previousRulersObject){
            if(realm instanceof GermanicRealm){
                thisPerson.setOccupation(GermanicSkills.CHIEFTAIN);
                if(previousRulersId != 1){
                    // this sets previous rulers isRuler status to false
                    previousRulersObject.rulerFalse();
                    // take away previous status of chieftain
                    previousRulersObject.setOccupation(GermanicSkills.PEASANT);
                }
            }else{
                thisPerson.setOccupation(RomanSkills.CAESAR);
                if(previousRulersId != 1){
                    // this sets previous rulers isRuler status to false
                    previousRulersObject.rulerFalse();
                    // take away previous status of caesar
                    previousRulersObject.setOccupation(RomanSkills.SLAVE);
                }
            }
            // remove the new ruler from the army if was currently enlisted
            if(realm.getArmyOfThisRealm().contains(thisPerson.getId())){
                realm.removeConscriptFromArmy(thisPerson.getId());
            }
        }else{
            System.out.println("\n you made the same person ruler!");
        }
    }

    public void setTimeBeginServiceInArmy(){
        this.timeBeginServiceInArmy = new CreationInstance(Instant.now()).setCreationInstant();
    }

    //////////////////////////////////////////
    // UTILITY FUNCTIONS
    /////////////////////////////////////////

    // remove previous ruler
    public void rulerFalse(){
        isRulerOfTheRealm = false;
    }

    public String displayTimeServedInArmy(){
        long timeServedInMillis = new DurationInMillis().getDurationInMillis(getTimeBeginServiceInArmy());
        String timeServed = DisplayTimeServedInArmy.displayTimeServedInArmy(timeServedInMillis);
        return timeServed;
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        boolean isGermanic = this instanceof GermanicPerson;
        if(this.getIsRulerOfTheRealm()){
            if(isGermanic){
                string.append("Hello my name is "+this.getName()+"\n"+this.displayAge()+"\nI am the "+GermanicSkills.CHIEFTAIN+"!");
            }else{
                string.append("Hello my name is "+this.getName()+"\n"+this.displayAge()+"\nI am "+RomanSkills.CAESAR+"!");
            }
        }else{
            string.append("Hello my name is "+this.getName()+"\n"+this.displayAge()+"\n");
        }
        return string.toString();
    }
}
