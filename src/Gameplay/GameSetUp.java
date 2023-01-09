package Gameplay;

import Buildings.Germanic.BuildingTypes.MeadHall;
import Buildings.Roman.BuildingTypes.Notary;
import Buildings.Roman.BuildingTypes.Stable;
import Enums.Gender;
import Territories.GermanicRegion.GermanicRealm;
import Territories.RealmDesign;
import Territories.RomanRegion.RomanRealm;

public class GameSetUp {

    private Player playerOne;

    private Player playerTwo;

    //////////////////////////////////////////
    // SETTERS
    /////////////////////////////////////////


    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////


    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setDefaultRealms(){

        // default realms each with a ruler, a building and 3 citizens

        /////////////////////
        // 2 germanic realms
        /////////////////////


        // first realm
        RealmDesign Cherusci = new GermanicRealm("Cherusci");
        new MeadHall("The Lair", Cherusci.getRealmId());
        Cherusci.addCitizen("Anders", Gender.MALE, true);
        Cherusci.addCitizen("Hans", Gender.MALE);
        Cherusci.addCitizen("Bruna", Gender.FEMALE);
        Cherusci.addCitizen("Hans", Gender.MALE);

        // second realm

        RealmDesign Orga = new GermanicRealm("Orga");
        new MeadHall( "The Cavern's Flame", Orga.getRealmId());
        Orga.addCitizen("Schzten", Gender.MALE, true);
        Orga.addCitizen("Andreas", Gender.MALE);
        Orga.addCitizen("Klaren", Gender.FEMALE);
        Orga.addCitizen("Uwe", Gender.FEMALE);

        /////////////////////
        // 2 roman realms
        /////////////////////

        // third realm
        RealmDesign Rome = new RomanRealm("Eastern Rome");
        new Stable( "Black Stables", Rome.getRealmId());
        Rome.addCitizen("Julius", Gender.MALE, true);
        Rome.addCitizen("Augustus", Gender.MALE);
        Rome.addCitizen("Massim", Gender.FEMALE);
        Rome.addCitizen("Georgina", Gender.FEMALE);

        // fourth realm

        RealmDesign WesternRome = new RomanRealm("Western Rome");
        new Notary( "Notary Inc.", WesternRome.getRealmId());
        WesternRome.addCitizen("Cicero", Gender.MALE, true);
        WesternRome.addCitizen("Domitia", Gender.FEMALE);
        WesternRome.addCitizen("Hadriana", Gender.FEMALE);
        WesternRome.addCitizen("Cassia", Gender.FEMALE);
    }
}
