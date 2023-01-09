package Enums.Buildings;

public enum GermanicBuildingType {
    DWELLING,
    MEAD_HALL,
    BARN,
    STORE_ROOM;

    public String toString() {
        switch (this) {
            case DWELLING:
                return "dwelling";
            case MEAD_HALL:
                return "mead hall";
            case BARN:
                return "barn";
            case STORE_ROOM:
                return "store room";
            default:
                return "shack";
        }
    }
}
