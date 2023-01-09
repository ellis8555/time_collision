package Buildings.Roman.BuildingTypes;

import Buildings.Roman.RomanBuilding;
import Enums.Buildings.RomanBuildingType;

public class School extends RomanBuilding {

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////
    private RomanBuildingType type;

    //////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////

    public School(int owner, int realmBuildingBelongsTo) {
        super(owner, realmBuildingBelongsTo);
        this.type = RomanBuildingType.SCHOOL;
    }

    public School(String name, int realmBuildingBelongsTo) {
        super(name, realmBuildingBelongsTo);
        this.type = RomanBuildingType.SCHOOL;
    }

    public School(String name, int owner, int realmBuildingBelongsTo) {
        super(name, owner, realmBuildingBelongsTo);
        this.type = RomanBuildingType.SCHOOL;
    }

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    @Override
    public String getBuildingType() {
        return this.type.toString();
    }

}
