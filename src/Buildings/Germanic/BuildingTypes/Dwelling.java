package Buildings.Germanic.BuildingTypes;

import Buildings.Germanic.GermanicBuilding;
import Enums.Buildings.GermanicBuildingType;

public class Dwelling extends GermanicBuilding {

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////
    private GermanicBuildingType type;

    //////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////

    public Dwelling(int owner, int realmBuildingBelongsTo) {
        super(owner, realmBuildingBelongsTo);
        this.type = GermanicBuildingType.DWELLING;
    }

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    @Override
    public String getBuildingType() {
        return this.type.toString();
    }

}
