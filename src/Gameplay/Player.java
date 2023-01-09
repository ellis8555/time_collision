package Gameplay;

import Gameplay.PlayerTurnOptions.AttackAnotherRealm;
import Gameplay.PlayerTurnOptions.DisplayOptions.CheatDisplay;
import Gameplay.PlayerTurnOptions.CreateOptions.CreateNewBuilding;
import Gameplay.PlayerTurnOptions.CreateOptions.CreateNewCitizen;
import Gameplay.PlayerTurnOptions.DisplayOptions.*;
import Gameplay.PlayerTurnOptions.EditOptions.*;
import Gameplay.PlayersTurns.PlayerTurn;


public class Player {

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////
    private String name;
    private static byte players = 1;
    private byte playerNumber;
    private int playersRealmId;

    //////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////

    public Player(String name) {
        this.name = name;
        this.setPlayerNumber();
        this.setPlayers();
    }

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////


    public String getName() {
        return name;
    }

    public String getPlayersNumber() {
        return String.valueOf(this.playerNumber);
    }

    public int getPlayersRealmId() {
        return playersRealmId;
    }

    /////////////////////
    // SETTERS
    ////////////////////


    private void setPlayerNumber() {
        this.playerNumber = players;
    }

    private void setPlayers() {
        players++;
    }

    public void setPlayersRealmId(int playersRealmId) {
        this.playersRealmId = playersRealmId;
    }

    //////////////////////////////////////////
    // GAMEPLAY TURN
    /////////////////////////////////////////

    public void playerTurn(boolean isGameOver){
        new PlayerTurn().playerTurn(this, isGameOver);
    }

    //////////////////////////////////////////
    // UTILITY DISPLAY FUNCTIONS
    /////////////////////////////////////////

    // display all of this realms citizens
    public void displayPlayersCitizens(){
        new AllCitizensDisplay().displayPlayersCitizens(this.getPlayersRealmId());
    }

    // display a single citizen
    public void displayASingleCitizen(){
        new SingleCitizenDisplay().displayASingleCitizen(this.getPlayersRealmId());
    }

    // display this realms phonebook
    public void displayMyRealmsPhoneBook(){
        new RealmsPhonebookDisplay().displayMyRealmsPhoneBook(this.getPlayersRealmId());
    }

    // display this realms ruler
    public void displayRulerOfRealm(){
        new RulerOfRealmDisplay().rulerOfRealmDisplay(this.getPlayersRealmId());
    }

    // get age of a citizen
    public void displayAgeOfCitizen(){
       new AgeOfCitizenDisplay().displayAgeOfCitizen(this.getPlayersRealmId());
    }

    // display the time a citizen was created
    public void displayBirthTimeOfCitizen(){
        new BirthTimeOfCitizenDisplay().displayBirthTimeOfCitizen(this.getPlayersRealmId());
    }

    // get a single citizens occupation
    public void displayCitizensOccupation(){
        new CitizensOccupationDisplay().displayCitizensOccupation(this.getPlayersRealmId());
    }

    // list of all of this realms' buildings
    public void displayRealmsBuildings() throws NoSuchMethodException {
       new RealmsBuildingsDisplay().displayRealmsBuildings(this.getPlayersRealmId());
    }

    // display only numbers of business buildings
    public void displayBusinessPhoneNumbers(){
       new BusinessPhonenumbersDisplay().businessPhonenumbersDisplay(this.getPlayersRealmId());
    }

    // display worlds information for demonstrating purposes
    public void cheatDisplay(){
        new CheatDisplay().cheatDisplay();
    }

    // display players army
    public void displayArmy(){
        new DisplayArmy().displayArmy(this.getPlayersRealmId());
    }

    //////////////////////////////////////////
    // UTILITY EDIT FUNCTIONS
    /////////////////////////////////////////

    // change a citizens phone number
    public void changeCitizensPhoneNumber(){
        new ChangeCitizensPhonenumber().changeCitizensPhoneNumber(this.getPlayersRealmId());
    }

    // assign a new ruler to the realm
    public void setANewRuler(){
        new SetANewRuler().setANewRuler(this.getPlayersRealmId());
    }


    // change the name of a citizen
    public void changeCitizensName(){
        new ChangeCitizensName().changeCitizensName(this.getPlayersRealmId());
    }

    public boolean changeCitizensOccupation(){
        boolean endTurn = new ChangeCitizensOccupation().changeCitizensOccupation(this.getPlayersRealmId());
        return endTurn;
    }

    public void changeBusinessOwner(){
        new ChangeBusinessOwnership().changeBusinessOwnership(this.getPlayersRealmId());
    }

    //////////////////////////////////////////
    // UTILITY CREATE FUNCTIONS
    /////////////////////////////////////////

    // create a new citizen in the realm
    public void createNewCitizen(){
        new CreateNewCitizen().createNewCitizen(this.getPlayersRealmId());
    }

    // create a new business building in the realm
    public void createNewBuilding(){
        new CreateNewBuilding().createNewBuilding(this.getPlayersRealmId());
    }

    //////////////////////////////////////////
    // UTILITY GENERAL FUNCTIONS
    /////////////////////////////////////////

    // attack another realm
    public boolean attackAnotherRealm(){
        boolean doesPlayerHaveAnArmy = new AttackAnotherRealm().attackAnotherRealm(this.getPlayersRealmId());
        return doesPlayerHaveAnArmy;
    }

    public String toString(){
        return "Player "+getPlayersNumber()+": "+getName();
    }

}
