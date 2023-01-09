package Buildings.Germanic.BuildingTypes;

import Buildings.Germanic.GermanicBuilding;
import Enums.Buildings.GermanicBuildingType;

public class Barn extends GermanicBuilding {

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////
    private GermanicBuildingType type;

    //////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////

    public Barn(int owner, int realmBuildingBelongsTo) {
        super(owner, realmBuildingBelongsTo);
        this.type = GermanicBuildingType.BARN;
    }

    public Barn(String name, int realmBuildingBelongsTo) {
        super(name, realmBuildingBelongsTo);
        this.type = GermanicBuildingType.BARN;
    }

    public Barn(String name, int owner, int realmBuildingBelongsTo) {
        super(name, owner, realmBuildingBelongsTo);
        this.type = GermanicBuildingType.BARN;
    }

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    @Override
    public String getBuildingType() {
        return this.type.toString();
    }

}
