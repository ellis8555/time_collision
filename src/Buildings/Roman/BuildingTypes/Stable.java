package Buildings.Roman.BuildingTypes;

import Buildings.Roman.RomanBuilding;
import Enums.Buildings.RomanBuildingType;

public class Stable extends RomanBuilding {

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////
    private RomanBuildingType type;

    //////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////

    public Stable(int owner, int realmBuildingBelongsTo) {
        super(owner, realmBuildingBelongsTo);
        this.type = RomanBuildingType.STABLE;
    }

    public Stable(String name, int realmBuildingBelongsTo) {
        super(name, realmBuildingBelongsTo);
        this.type = RomanBuildingType.STABLE;
    }

    public Stable(String name, int owner, int realmBuildingBelongsTo) {
        super(name, owner, realmBuildingBelongsTo);
        this.type = RomanBuildingType.STABLE;
    }

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    @Override
    public String getBuildingType() {
        return this.type.toString();
    }

}
