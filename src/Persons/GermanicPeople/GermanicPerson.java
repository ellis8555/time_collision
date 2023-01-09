package Persons.GermanicPeople;
import Buildings.BuildingDesign;
import Buildings.Germanic.BuildingTypes.Dwelling;
import Enums.Gender;
import Enums.Occupations.GermanicSkills;
import Enums.realmAreacodes;
import Persons.PersonDesign;
import Territories.World;
import Utilities.Phones.CreateCellNumber;
import Utilities.Phones.GeneratePhoneNumber;
import Utilities.Population.DoesCitizenOwnABusiness;
import Utilities.Population.GetCitizensBusiness;
import Utilities.Population.IsCitizenEnlistedInArmy;

public class GermanicPerson extends PersonDesign {

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////

    private Enum occupation;
    private String cellNumber;
    private int areaCode;

    private int homeAddress;

    private int getAreaCode;

    //////////////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////////////

    public GermanicPerson(int id, String name, Gender gender, int realmNamePersonBelongsTo) {
        super(id, name, gender, realmNamePersonBelongsTo);
        // get and set area code from Germanic realms
        this.areaCode = realmAreacodes.GERMANIC.getAreaCode();
        this.cellNumber = GeneratePhoneNumber.createNumber(this.areaCode);
        this.occupation = GermanicSkills.PEASANT;
        this.areaCode = realmAreacodes.GERMANIC.getAreaCode();
        BuildingDesign germanicBuilding = new Dwelling(this.getId(), this.getRealmPersonBelongsTo());
        homeAddress = germanicBuilding.getBuildingId();
    }

    public GermanicPerson(int id, String name, Gender gender, int realmNamePersonBelongsTo, boolean ruler) {
        super(id, name, gender, realmNamePersonBelongsTo, ruler);
        // get and set area code from Germanic realms
        this.areaCode = realmAreacodes.GERMANIC.getAreaCode();
        this.cellNumber = GeneratePhoneNumber.createNumber(this.areaCode);
        if(ruler){
            this.occupation = GermanicSkills.CHIEFTAIN;
        }else{
            this.occupation = GermanicSkills.PEASANT;
        }
        this.areaCode = realmAreacodes.GERMANIC.getAreaCode();
        BuildingDesign germanicBuilding = new Dwelling(this.getId(), this.getRealmPersonBelongsTo());
        homeAddress = germanicBuilding.getBuildingId();
    }

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    // buildings UUID before area code is appended
    @Override
    public int getOriginalHomeAddress(){
        return this.homeAddress;
    }

    // get this person's occupation
    @Override
    public Enum getOccupation(){
        return this.occupation;
    }
    // get persons home phone number
    @Override
    public String getHomePhoneNumber(){
        return String.valueOf(World.getBuildingsInTheWorld().get(this.homeAddress).getPhoneNumber());
    }
    // get this person's cell number
    @Override
    public String getCellNumber() {
        return this.cellNumber;
    }

    @Override
    public String getHomeAddress(){
        String areaCode = String.valueOf(this.areaCode);
        String address = String.valueOf(this.homeAddress);
        String replaceNegativeSign = address.replace('-', '0');
        return areaCode+" - "+replaceNegativeSign;
    }

    @Override
    public int getAreaCode(){
        return this.areaCode;
    }
    /////////////////////
    // SETTERS
    ////////////////////

    // change this person's occupation
    @Override
    public void setOccupation(Enum occupation){
        this.occupation = occupation;
    }
    // change this person's cell number
    @Override
    public void setCellNumber(String newNumber, String oldNumber) {
        CreateCellNumber createCellNumber = new CreateCellNumber(newNumber, oldNumber);
        String newCellPhoneNumber = createCellNumber.getCellPhoneNumber();
        int numberLength = newCellPhoneNumber.length();
        if(numberLength < 11){
            cellNumber = areaCode + "-" + newCellPhoneNumber;
            System.out.println(this.getName()+" has a new cell phone number: "+cellNumber+".");
        }else{
            cellNumber = newCellPhoneNumber;
        }
    }

    //////////////////////////////////////////
    // UTILITY FUNCTIONS
    /////////////////////////////////////////

    public String toString(){
        // string to return with final description of this person
        StringBuilder citizenDescription = new StringBuilder();

        // name introduction
        citizenDescription.append("\nHello my name is "+this.getName()+" of the "+World.getRealmsInTheWorld().get(this.getRealmPersonBelongsTo()).getRealmName());

        // if ruler display first
        boolean isRuler = this.getIsRulerOfTheRealm();
        if(isRuler){citizenDescription.append("\nI am the Chieftain!");}

        // generic information for everyone
        citizenDescription.append("\n"+this.displayAge());
        citizenDescription.append("\nMy dwellings address is "+this.getHomeAddress());

        // if is owner of a business
        boolean doesCitizenOwnABusiness = new DoesCitizenOwnABusiness().doesCitizenOwnABusiness(this.getId(), this.getRealmPersonBelongsTo());
        if(doesCitizenOwnABusiness){
            String getOwnersBusinessName = new GetCitizensBusiness().getCitizensBusiness(this.getId(), this.getRealmPersonBelongsTo());
            citizenDescription.append("\nI'm the owner of "+getOwnersBusinessName);
        }

        // if is enlisted in the army
        boolean isEnlisted = new IsCitizenEnlistedInArmy().isCitizenEnlistedInArmy(this.getId(), this.getRealmPersonBelongsTo());
        StringBuilder timeEnlisted = new StringBuilder();

        if(isEnlisted){
            timeEnlisted.append(this.displayTimeServedInArmy()).toString();
            StringBuilder finalTimeEnlisted = timeEnlisted.replace(0, 3, "have");
            citizenDescription.append("\nI am enlisted in the army and I "+finalTimeEnlisted.toString());
        }
        return citizenDescription.toString();
    }
}
