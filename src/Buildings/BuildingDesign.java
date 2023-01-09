package Buildings;

import Territories.RealmDesign;
import Territories.World;
import Utilities.CreationStamps.CreationInstance;
import Utilities.CreationStamps.CreationInstanceDetails;
import Utilities.Durations.DurationInMillis;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BuildingDesign {

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////

    private int buildingId;

    private String name;

    private LocalDateTime dateTimeOfConstruction;

    private int realmBuildingBelongsTo;

    private int homeOwner = 1;

    private int businessOwner = 1;

    //////////////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////////////

    // constructor for home when person is created
    protected BuildingDesign(int owner, int realmBuildingBelongsTo){

        // set name of who owns this house
        this.name = World.getWorldsPeopleObjectsMAPPED().get(owner).getName();

        // id generated utilizing UUID class then hashing it
        this.buildingId = UUID.randomUUID().hashCode();

        // who owns this home
        this.homeOwner = owner;

        // timestamp for structures creation
        CreationInstance creationInstance = new CreationInstance(Instant.now());
        this.dateTimeOfConstruction = creationInstance.setCreationInstant();
        // assign realmId this building belongs to
        this.realmBuildingBelongsTo = realmBuildingBelongsTo;
        // add this building to its realms arrayList of buildings
        RealmDesign realm = World.getRealmsInTheWorld().get(this.getRealmBuildingBelongsTo());
        realm.addBuildingToThisRealm(this);
        // add this building to the worlds arrayList of buildings
        new World().addBuildingsInTheWorld(this.getBuildingId(), this);
    }

    // constructor for game start buildings created
    protected BuildingDesign(String name, int realmBuildingBelongsTo){

        // id generated utilizing UUID class then hashing it
        this.buildingId = UUID.randomUUID().hashCode();

        // name of this building
        this.name = name;

        // timestamp for structures creation
        CreationInstance creationInstance = new CreationInstance(Instant.now());
        this.dateTimeOfConstruction = creationInstance.setCreationInstant();
        // assign realmId this building belongs to
        this.realmBuildingBelongsTo = realmBuildingBelongsTo;
        // add this building to its realms arrayList of buildings
        RealmDesign realm = World.getRealmsInTheWorld().get(this.getRealmBuildingBelongsTo());
        realm.addBuildingToThisRealm(this);
        // add this building to the worlds arrayList of buildings
        new World().addBuildingsInTheWorld(this.getBuildingId(), this);
    }

    // constructor for when manually creating a new building via game options menu
    protected BuildingDesign(String name, int owner, int realmBuildingBelongsTo){

        // id generated utilizing UUID class then hashing it
        this.buildingId = UUID.randomUUID().hashCode();

        // name of this building
        this.name = name;

        // who owns this business
        this.businessOwner = owner;

        // timestamp for structures creation
        CreationInstance creationInstance = new CreationInstance(Instant.now());
        this.dateTimeOfConstruction = creationInstance.setCreationInstant();
        // assign realmId this building belongs to
        this.realmBuildingBelongsTo = realmBuildingBelongsTo;
        // add this building to its realms arrayList of buildings
        RealmDesign realm = World.getRealmsInTheWorld().get(this.getRealmBuildingBelongsTo());
        realm.addBuildingToThisRealm(this);
        // add this building to the worlds arrayList of buildings
        new World().addBuildingsInTheWorld(this.getBuildingId(), this);
    }

    //////////////////////////////////////////////////////////////////////
    // ABSTRACT METHODS
    // these methods require properties that are specific to their realm
    //////////////////////////////////////////////////////////////////////

    // get business' phone number
    public abstract String getPhoneNumber();

    // get building type
    public abstract  String getBuildingType();

    // change phone number for this building
    public abstract void setPhoneNumber(String newNumber, String oldNumber);

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    public int getBuildingId(){return this.buildingId;}

    public String getName(){return this.name;}

    public int getRealmBuildingBelongsTo(){return this.realmBuildingBelongsTo;}

    public String getDateOfConstruction(){return CreationInstanceDetails.getBirthDate(this.dateTimeOfConstruction);}

    public String getDateTimeOfConstruction(){return CreationInstanceDetails.getBirthTime(this.dateTimeOfConstruction);}

    public long getAgeInMillis(){
        DurationInMillis durationInMillis = new DurationInMillis();
        return durationInMillis.getDurationInMillis(this.dateTimeOfConstruction);
    }

    // for homes get id of who owns the home
    public int getOwnerOfHome(){
        return this.homeOwner;
    }

    public int getBusinessOwner(){return this.businessOwner;}


    /////////////////////
    // SETTERS
    ////////////////////

    public void setName(String name){this.name = name;}

    public void setHomeOwnerOwner(int ownerId){this.homeOwner = ownerId;}

    public void setBusinessOwner(int ownerId){this.businessOwner = ownerId;}

    //////////////////////////////////////////
    // UTILITY FUNCTIONS
    /////////////////////////////////////////

    public String getHomeownerName(){
        return World.getWorldsPeopleObjectsMAPPED().get(this.getOwnerOfHome()).getName();
    }
}
