package Gameplay.PlayersTurns.GameMenus;

import Gameplay.Player;
import Gameplay.PlayersTurns.PlayerTurn;
import Gameplay.PlayersTurns.PlayerTurnOver;
import Utilities.Phones.AreaCodes;
import Utilities.UserInputs.Inputs.NumberWithRangeInput;

public class RealmInfoSelections {
    public RealmInfoSelections(Player player, boolean isTurnOver) {
        // instance of inner class
        NonTurnEndingOptions nonTurnEndingOptions = new NonTurnEndingOptions(player);
        // loop detecting if player should return back to the main menu
        do{
            if(!isTurnOver){
                nonTurnEndingOptions.getSelectedTurnOption();
            }else{
                nonTurnEndingOptions.getSelectedTurnOption();
                PlayerTurnOver.setIsPlayersTurnOver(true);
            }
        }
        while(!PlayerTurnOver.isPlayersTurnOver());
        // class PlayerTurn is the main menu
        new PlayerTurn().playerTurn(player, false);
    }

    // innerclass
    private class NonTurnEndingOptions{
        private Player player;

        NonTurnEndingOptions(Player player){
            this.player=  player;
        }

        private void displayNonTurnEndingOptions(){
            System.out.println("\n"+player.getName()+" select an option!\nPress zero key to go back to main menu\n");
            System.out.println("1. Display your Realm's citizens");
            System.out.println("2. Get info on one of your citizens");
            System.out.println("3. Get the residential phone book of the Realm");
            System.out.println("4. Get Ruler of the Realm");
            System.out.println("5. Get age of a citizen");
            System.out.println("6. Get birth time of a citizen");
            System.out.println("7. Get citizens occupation");
            System.out.println("8. Get list of this realms buildings");
            System.out.println("9. Get phone numbers for local business'");
            System.out.println("10 Display your realms army");
            System.out.println("0. back to main option list");
        }

        // user selects from displayed option list in which the appropriate method will be called
        public void getSelectedTurnOption(){
            displayNonTurnEndingOptions();
            int choice = NumberWithRangeInput.numberWithRangeInput(10);
            switch(choice){
                case 0:
                    PlayerTurnOver.setIsPlayersTurnOver(true);
                    break;
                case 1:
                    player.displayPlayersCitizens();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                case 2:
                    player.displayASingleCitizen();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                case 3:
                    System.out.println("Area Codes:");
                    AreaCodes.getListOfAreaCodes();
                    System.out.println("\nListings:");
                    player.displayMyRealmsPhoneBook();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                case 4:
                    player.displayRulerOfRealm();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                case 5:
                    player.displayAgeOfCitizen();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                case 6:
                    player.displayBirthTimeOfCitizen();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                case 7:
                    player.displayCitizensOccupation();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                case 8:
                    try {
                        player.displayRealmsBuildings();
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                case 9:
                    player.displayBusinessPhoneNumbers();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                case 10:
                    player.displayArmy();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                default:
                    PlayerTurnOver.setIsPlayersTurnOver(false);
            }
        }
    }
}
