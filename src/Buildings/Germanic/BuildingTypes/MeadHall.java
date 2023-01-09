package Buildings.Germanic.BuildingTypes;

import Buildings.Germanic.GermanicBuilding;
import Enums.Buildings.GermanicBuildingType;

public class MeadHall extends GermanicBuilding {

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////
    private GermanicBuildingType type;

    //////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////

    //
    public MeadHall(int owner, int realmBuildingBelongsTo) {
        super(owner, realmBuildingBelongsTo);
        this.type = GermanicBuildingType.MEAD_HALL;
    }

    public MeadHall(String name, int realmBuildingBelongsTo) {
        super(name, realmBuildingBelongsTo);
        this.type = GermanicBuildingType.MEAD_HALL;
    }

    public MeadHall(String name, int owner, int realmBuildingBelongsTo) {
        super(name, owner, realmBuildingBelongsTo);
        this.type = GermanicBuildingType.MEAD_HALL;
    }

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    @Override
    public String getBuildingType() {
        return this.type.toString();
    }

}
