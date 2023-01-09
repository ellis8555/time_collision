package Persons;

public interface PersonDesignInterface {
    public Enum getOccupation();
    public String getHomePhoneNumber();
    public String getCellNumber();
    public void setOccupation(Enum occupation);
    public void setCellNumber(String newNumber, String oldNUmber);
    public String getHomeAddress();
    public int getAreaCode();
    public int getOriginalHomeAddress();
}
