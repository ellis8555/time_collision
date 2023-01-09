package Enums.Occupations;

public enum RomanSkills {
    TEACHER,
    BLACKSMITH,
    CHEF,
    WEAVER,
    EQUESTRIAN_RIDER,
    SLAVE,
    CENTURION,
    CAESAR;


    public String toString(){
        switch(this){
            case TEACHER:
                return "teacher";
            case BLACKSMITH:
                return "blacksmith";
            case CHEF:
                return "chef";
            case WEAVER:
                return "weaver";
            case EQUESTRIAN_RIDER:
                return "equestrian rider";
            case CENTURION:
                return "centurion";
            case SLAVE:
                return "slave";
            case CAESAR:
                return "Caesar";
            default:
                return "peasant";
        }
    }
}
