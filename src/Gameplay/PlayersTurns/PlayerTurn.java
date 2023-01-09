package Gameplay.PlayersTurns;

import Gameplay.EndTheGame;
import Gameplay.Player;
import Gameplay.PlayersTurns.GameMenus.EditSelections;
import Gameplay.PlayersTurns.GameMenus.RealmInfoSelections;
import Utilities.UserInputs.Inputs.NumberWithRangeInput;

public class PlayerTurn {

    public void playerTurn(Player player, boolean isGameOver){

        if(!isGameOver){
            new TurnOptions(player).getSelectedTurnOption();
        }else{
            new TurnOptions(player).getSelectedTurnOption();
            EndTheGame.setGameOver(true);
        }
    }

    // this method is run within submenu if submenu's option is turn ending
    public void endPlayersTurn(){
        PlayerTurnOver.setIsPlayersTurnOver(true);
    }

     private class TurnOptions{

        private Player player;

        TurnOptions(Player player){
            this.player = player;

        }
        // these are the options that will be displayed for the players to choose from for their turn
        private void displayTurnOptions(){
            System.out.println("\n-------------------------------------------------------------------------------");
            System.out.println(player.getName()+" it's your turn. Choose your play!\n-------------------------------------------------------------------------------\nSome selections will end your turn after completion\n");
            System.out.println("1. Get various information about your Realm");
            System.out.println("2. Make some edits");
            System.out.println("3. Create a new citizen for your realm");
            System.out.println("4. Create a new building in your realm");
            System.out.println("5. Attack another realm");
            System.out.println("6. Skip your turn");
            System.out.println("7. CHEAT MODE - list the entire world");
            System.out.println("0. Game will end either this round or next");
        }

        // user selects from displayed option list in which the appropriate method will be called
        public void getSelectedTurnOption(){
            displayTurnOptions();
            int choice = NumberWithRangeInput.numberWithRangeInput(7);
            switch(choice){
                case 0:
                    PlayerTurnOver.setIsPlayersTurnOver(true);
                    EndTheGame.setGameOver(true);
                    break;
                case 1:
                    new RealmInfoSelections(player, false);
                    EndTheGame.setGameOver(false);
                    break;
                case 2:
                    new EditSelections(player, false);
                    EndTheGame.setGameOver(false);
                    break;
                case 3:
                    player.createNewCitizen();
                    PlayerTurnOver.setIsPlayersTurnOver(true);
                    break;
                case 4:
                    player.createNewBuilding();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                case 5:
                    boolean hasArmy = player.attackAnotherRealm();
                    PlayerTurnOver.setIsPlayersTurnOver(hasArmy);
                    break;
                case 6:
                    PlayerTurnOver.setIsPlayersTurnOver(true);
                    break;
                case 7:
                    player.cheatDisplay();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                default:
                    EndTheGame.setGameOver(false);
            }
        }
    }
}
