package Gameplay.PlayersTurns.GameMenus;

import Gameplay.Player;
import Gameplay.PlayersTurns.PlayerTurn;
import Gameplay.PlayersTurns.PlayerTurnOver;
import Utilities.UserInputs.Inputs.NumberWithRangeInput;

public class EditSelections {
    public EditSelections(Player player, boolean isTurnOver) {
        // instance of inner class
        EditSelectionOptions editSelectionOptions = new EditSelectionOptions(player);
        // loop detecting if players turn is over
        // each option a player selects during their turn sets if their turn is ended
        do{
            if(!isTurnOver){
                editSelectionOptions.getSelectedTurnOption();
            }else{
                editSelectionOptions.getSelectedTurnOption();
                PlayerTurnOver.setIsPlayersTurnOver(true);
            }
        }
        while(!PlayerTurnOver.isPlayersTurnOver());
        // detects if the option is a turn ending option
        // if false then player simply returns to the main menu
        boolean isPlayersSelectionTurnEnding = editSelectionOptions.getOptionEndingTurn();
        if(isPlayersSelectionTurnEnding){
            new PlayerTurn().endPlayersTurn();
        }else{
            new PlayerTurn().playerTurn(player, false);
        }
    }

    // innerclass
    private class EditSelectionOptions{
        private Player player;
        // set to true if the players turn is to end after selection
        private boolean optionEndingTurn = false;

        EditSelectionOptions(Player player){this.player = player;}

        // returns boolean if turn should end or not
        public boolean getOptionEndingTurn(){
            return optionEndingTurn;
        }

        // submenu to be displayed
        private void displayEditOptions(){
            System.out.println("\n"+player.getName()+" select an option!\nPress zero key to go back to main menu\n");
            System.out.println("1. Edit a citizens cell phone number");
            System.out.println("2. Set a new ruler for your realm");
            System.out.println("3. Change a citizens name");
            System.out.println("4. Change a citizens occupation");
            System.out.println("5 Change owner of a business");
            System.out.println("0. back to main option list");
        }

        // user selects from displayed option list in which the appropriate method will be called
        public void getSelectedTurnOption(){
            displayEditOptions();
            int choice = NumberWithRangeInput.numberWithRangeInput(5);
            switch(choice){
                case 0:
                    PlayerTurnOver.setIsPlayersTurnOver(true);
                    break;
                case 1:
                    player.changeCitizensPhoneNumber();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                case 2:
                    player.setANewRuler();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                case 3:
                    player.changeCitizensName();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                case 4:
                    boolean endTurn = player.changeCitizensOccupation();
                    if(endTurn){
                        optionEndingTurn = true;
                        PlayerTurnOver.setIsPlayersTurnOver(true);
                    }else{
                        PlayerTurnOver.setIsPlayersTurnOver(false);
                    }
                    break;
                case 5:
                    player.changeBusinessOwner();
                    PlayerTurnOver.setIsPlayersTurnOver(false);
                    break;
                default:
                    PlayerTurnOver.setIsPlayersTurnOver(false);
            }
        }
    }
}
