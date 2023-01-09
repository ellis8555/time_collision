// a value from this class is required upon any person object creation as a argument to it's constructor

package Enums;

public enum Gender {
    FEMALE,
    MALE;

    public String getGender(){
        switch(this){
            case MALE:
                return "male";
            case FEMALE:
                return "female";
            default:
                return "gender neutral";
        }
    }
}
