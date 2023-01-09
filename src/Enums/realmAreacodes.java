package Enums;

public enum realmAreacodes {
    GERMANIC(49),
    ROME(39);

    private final int code;

    public int getAreaCode(){
        return this.code;
    }
    realmAreacodes(int code){
        this.code = code;
    }
}


