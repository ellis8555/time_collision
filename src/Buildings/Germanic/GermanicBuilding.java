package Buildings.Germanic;

import Buildings.BuildingDesign;
import Enums.realmAreacodes;
import Territories.World;
import Utilities.Phones.CreateCellNumber;
import Utilities.Phones.GeneratePhoneNumber;

public abstract class GermanicBuilding extends BuildingDesign {

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////

    private String phoneNumber;

    private int areaCode;

    //////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////

    // business building created at game start
    public GermanicBuilding(String name, int realmBuildingBelongsTo){
        super(name, realmBuildingBelongsTo);
        this.areaCode = realmAreacodes.GERMANIC.getAreaCode();
        this.phoneNumber = GeneratePhoneNumber.createNumber(this.areaCode);
    }

    // building that is manually created
    public GermanicBuilding(String name, int owner, int realmBuildingBelongsTo){
        super(name, owner, realmBuildingBelongsTo);
        this.areaCode = realmAreacodes.GERMANIC.getAreaCode();
        this.phoneNumber = GeneratePhoneNumber.createNumber(this.areaCode);
    }

    // build home for person
    public GermanicBuilding(int owner, int realmBuildingBelongsTo){
        super(owner, realmBuildingBelongsTo);
        this.areaCode = realmAreacodes.GERMANIC.getAreaCode();
        this.phoneNumber = GeneratePhoneNumber.createNumber(this.areaCode);
    }

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public abstract String getBuildingType();


    /////////////////////
    // SETTERS
    ////////////////////

    @Override
    public void setPhoneNumber(String newNumber, String oldNumber) {
        CreateCellNumber createCellNumber = new CreateCellNumber(newNumber, oldNumber);
        String newCellPhoneNumber = createCellNumber.getCellPhoneNumber();
        int numberLength = newCellPhoneNumber.length();
        if(numberLength < 11){
            phoneNumber = areaCode + "-" + newCellPhoneNumber;
            System.out.println(this.getName()+" has a new cell phone number: "+phoneNumber+".");
        }else{
            phoneNumber = newCellPhoneNumber;
        }
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        if (this.getBuildingType() == "dwelling") {
            string.append(this.getName() + "'s house. Established " + this.getDateOfConstruction()+ ", "+ this.getDateTimeOfConstruction() + " Located in " + World.getRealmsInTheWorld().get(this.getRealmBuildingBelongsTo()).getRealmName());
        } else {
            if(this.getOwnerOfHome() !=1){
                string.append(this.getName() + ". Established " + this.getDateOfConstruction() + ", "+ this.getDateTimeOfConstruction() + " Located in " + World.getRealmsInTheWorld().get(this.getRealmBuildingBelongsTo()).getRealmName()+" and owned by "+World.getWorldsPeopleObjectsMAPPED().get(this.getOwnerOfHome()).getName());
            } else {
                string.append(this.getName() + ". Established " + this.getDateOfConstruction() + ", "+ this.getDateTimeOfConstruction() + " Located in " + World.getRealmsInTheWorld().get(this.getRealmBuildingBelongsTo()).getRealmName());
            }
        }
        return string.toString();
    }
}
