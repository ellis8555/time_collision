package Enums.Occupations;

public enum GermanicSkills{
        WOODWORKER,
    BLACKSMITH,
    COOK,
    WEAVER,
    SEAMSTRESS,
    PEASANT,
    WARRIOR,
    CHIEFTAIN;


    public String toString(){
        switch(this){
            case WOODWORKER:
                return "woodworker";
            case BLACKSMITH:
                return "blacksmith";
            case COOK:
                return "cook";
            case WEAVER:
                return "weaver";
            case SEAMSTRESS:
                return "seamstress";
            case WARRIOR:
                return "warrior";
            case CHIEFTAIN:
                return "Chieftain";
            default:
                return "peasant";
        }
    }
}
