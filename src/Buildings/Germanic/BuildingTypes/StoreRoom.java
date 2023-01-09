package Buildings.Germanic.BuildingTypes;

import Buildings.Germanic.GermanicBuilding;
import Enums.Buildings.GermanicBuildingType;

public class StoreRoom extends GermanicBuilding {

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////
    private GermanicBuildingType type;

    //////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////

    public StoreRoom(int owner, int realmBuildingBelongsTo) {
        super(owner, realmBuildingBelongsTo);
        this.type = GermanicBuildingType.STORE_ROOM;
    }

    public StoreRoom(String name, int realmBuildingBelongsTo) {
        super(name, realmBuildingBelongsTo);
        this.type = GermanicBuildingType.STORE_ROOM;
    }

    public StoreRoom(String name, int owner, int realmBuildingBelongsTo) {
        super(name, owner, realmBuildingBelongsTo);
        this.type = GermanicBuildingType.STORE_ROOM;
    }

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    @Override
    public String getBuildingType() {
        return this.type.toString();
    }

}
