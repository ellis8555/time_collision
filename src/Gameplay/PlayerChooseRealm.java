package Gameplay;

import Enums.Gender;
import Territories.GermanicRegion.GermanicRealm;
import Territories.RealmDesign;
import Territories.RomanRegion.RomanRealm;
import Territories.World;
import Utilities.Realms.GetArrayListOfRealmIds;
import Utilities.UserInputs.Inputs.NameInput;
import Utilities.UserInputs.Inputs.NameInputWithSpaces;
import Utilities.UserInputs.Inputs.NumberWithRangeInput;
import java.util.ArrayList;

public class PlayerChooseRealm {

    private int otherSize;
    private ArrayList<Integer> realmIds = GetArrayListOfRealmIds.getArrayListOfRealmIds();
    public PlayerChooseRealm(Player firstPlayer, Player secondPlayer){
        System.out.println("\n"+firstPlayer.getName()+" choose which Realm you will control or create a new Realm. Enter the corresponding number for your choice..\n");
        for(byte i = 1; i<=realmIds.size(); i++){
            String realmName = World.getRealmsInTheWorld().get(realmIds.get(i-1)).getRealmName();
            System.out.println(i+": "+realmName);
        }
        otherSize = realmIds.size()+1;
        System.out.println(otherSize+": Create realm");

        int playerOnesRealm = NumberWithRangeInput.numberWithRangeInput(otherSize);

        if(playerOnesRealm == otherSize){
            PlayerCreateRealm playerCreateRealm = new PlayerCreateRealm(firstPlayer);
            playerCreateRealm.createRealm();
        }else{
            firstPlayer.setPlayersRealmId(realmIds.get(playerOnesRealm-1));
            realmIds.remove(playerOnesRealm-1);
        }

        System.out.println("\n"+secondPlayer.getName()+" choose which Realm you will control or create a new Realm. Enter the corresponding number for your choice..\n");

        for(byte i = 1; i<=realmIds.size(); i++){
            String realmName = World.getRealmsInTheWorld().get(realmIds.get(i-1)).getRealmName();
            System.out.println(i+": "+realmName);
        }
        int otherSize = realmIds.size()+1;
        System.out.println(otherSize+": Create realm");

        int playerTwosRealm = NumberWithRangeInput.numberWithRangeInput(otherSize);

        if(playerTwosRealm == otherSize){
            PlayerCreateRealm playerCreateRealm = new PlayerCreateRealm(secondPlayer);
            playerCreateRealm.createRealm();
        }else{
            secondPlayer.setPlayersRealmId(realmIds.get(playerTwosRealm-1));
            realmIds.clear();
        }
        }

    private class PlayerCreateRealm{

        private Player player;

        PlayerCreateRealm(Player player){
            this.player=  player;
        }

        public void createRealm(){
            System.out.println("1. Roman\n2. Germanic");
            int realmChoice = NumberWithRangeInput.numberWithRangeInput(2);
            System.out.println("Enter a name for your realm");
            String realmName = NameInputWithSpaces.nameInputWithSpaces();
            RealmDesign customRealm = null;
            switch (realmChoice){
                case 1:
                    customRealm = new RomanRealm(realmName);
                    break;
                case 2:
                    customRealm = new GermanicRealm(realmName);
                    break;
            }
            player.setPlayersRealmId(customRealm.getRealmId());
            if(customRealm instanceof GermanicRealm){
                System.out.println("You need to create 4 citizens for your realm\nOne of them will be Chieftain. Your first entrant will be your Chieftain.");
                System.out.println("Create your Chieftain. Enter their name..");
            }else{
                System.out.println("You need to create 4 citizens for your realm\nOne of them will be Caesar. Your first entrant will be your Caesar.");
                System.out.println("Create your Caesar. Enter their name..");
            }
            String rulersName = NameInput.nameInput();
            System.out.println("Pick a gender\n1. Male\n2.Female");
            int genderChoice = NumberWithRangeInput.numberWithRangeInput(2);
            switch(genderChoice){
                case 1:
                    customRealm.addCitizen(rulersName, Gender.MALE, true);
                    break;
                default:
                    customRealm.addCitizen(rulersName, Gender.FEMALE, true);
            }
            for(int i = 1; i<4; i++){
                System.out.println("Enter citizen "+i+" name");
                String citizensName = NameInput.nameInput();
                System.out.println("Pick a gender\n1. Male\n2.Female");
                int genderChoiceForCitizens = NumberWithRangeInput.numberWithRangeInput(2);
                switch(genderChoiceForCitizens){
                    case 1:
                        customRealm.addCitizen(citizensName, Gender.MALE);
                        break;
                    default:
                        customRealm.addCitizen(citizensName, Gender.FEMALE);
                }
            }
            System.out.println("You have created the realm "+customRealm.getRealmName()+" and added its citizens!");
        }
    }
}
