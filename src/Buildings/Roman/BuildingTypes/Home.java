package Buildings.Roman.BuildingTypes;

import Buildings.Roman.RomanBuilding;
import Enums.Buildings.RomanBuildingType;

public class Home extends RomanBuilding {


    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////
    private RomanBuildingType type;

    //////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////

    public Home(int owner, int realmBuildingBelongsTo) {
        super(owner, realmBuildingBelongsTo);
        this.type = RomanBuildingType.HOME;
    }

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    @Override
    public String getBuildingType() {
        return this.type.toString();
    }

}
