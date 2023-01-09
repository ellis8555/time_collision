package Buildings.Roman.BuildingTypes;

import Buildings.Roman.RomanBuilding;
import Enums.Buildings.RomanBuildingType;

public class Notary extends RomanBuilding{

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////
    private RomanBuildingType type;

    //////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////

    public Notary(int owner, int realmBuildingBelongsTo) {
        super(owner, realmBuildingBelongsTo);
        this.type = RomanBuildingType.NOTARY;
    }

    public Notary(String name, int realmBuildingBelongsTo) {
        super(name, realmBuildingBelongsTo);
        this.type = RomanBuildingType.NOTARY;
    }

    public Notary(String name, int owner, int realmBuildingBelongsTo) {
        super(name, owner, realmBuildingBelongsTo);
        this.type = RomanBuildingType.NOTARY;
    }

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    @Override
    public String getBuildingType() {
        return this.type.toString();
    }

}
