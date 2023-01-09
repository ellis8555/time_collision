package Enums.Buildings;

public enum RomanBuildingType {
    HOME,
    STABLE,
    NOTARY,
    SCHOOL;

    public String toString() {
        switch (this) {
            case HOME:
                return "home";
            case STABLE:
                return "stable";
            case NOTARY:
                return "notary";
            case SCHOOL:
                return "school";
            default:
                return "shack";
        }
    }
}
