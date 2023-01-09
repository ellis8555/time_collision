import Gameplay.*;
import Gameplay.PlayersTurns.PlayerTurnOver;
import Territories.World;
import Utilities.Realms.CheckForDecimatedRealm;
import Utilities.UserInputs.Inputs.NameInput;

public class Main {

    public static void main(String[] args) {
        // set up the default realms
        GameSetUp gameSetUp = new GameSetUp();
        gameSetUp.setDefaultRealms();

        // create player one
        System.out.println("\nEnter player ones name");
        String playerOneName = NameInput.nameInput();
        gameSetUp.setPlayerOne(new Player(playerOneName));

        // create player two
        System.out.println("Enter player twos name");
        String playerTwoName = NameInput.nameInput();
        gameSetUp.setPlayerTwo(new Player(playerTwoName));

        // assign players locally

        Player playerOne = gameSetUp.getPlayerOne();
        Player playerTwo = gameSetUp.getPlayerTwo();

        // players select which realms to control
        new PlayerChooseRealm(playerOne, playerTwo);

        // display game begin message
        String gameMessage = new GameStartMessage().gameStartMessage(playerOne, playerTwo);
        System.out.println(gameMessage);

        // boolean setting is the game over to false
        EndTheGame.setGameOver(false);

        /////////////
        // GAMESTART
        /////////////

        // alternate turns between player one and two until one decides to end the game
        do {

            //////////////
            // PLAYER ONE
            //////////////

            // check if player one's realm has been decimated
            if(!new CheckForDecimatedRealm().checkForDecimatedRealm(playerOne.getPlayersRealmId())){
                // try to take a turn
                try {
                    do {
                        // do until player makes a play selection that is a turn ending selection
                        PlayerTurnOver.setIsPlayersTurnOver(true);
                        playerOne.playerTurn(EndTheGame.getIsGameOver());
                        if (PlayerTurnOver.isPlayersTurnOver()) {
                            System.out.println(playerOneName + " your turn has ended");
                        }
                        // boolean is set after each option player selects during their turn
                    } while (!PlayerTurnOver.isPlayersTurnOver());
                }
                // print error message if an exception occurs
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Player one you have been defeated!");
            }

            //////////////
            // PLAYER TWO
            //////////////

            // check if player two's realm has been decimated
            if(!new CheckForDecimatedRealm().checkForDecimatedRealm(playerTwo.getPlayersRealmId())){

            // try to take a turn
            try {
                do {
                    // do until player makes a play selection that is a turn ending selection
                    PlayerTurnOver.setIsPlayersTurnOver(true);
                    playerTwo.playerTurn(EndTheGame.getIsGameOver());
                    if (PlayerTurnOver.isPlayersTurnOver()) {
                        System.out.println(playerTwoName + " your turn has ended");
                    }
                    // boolean is set after each option player selects during their turn
                } while (!PlayerTurnOver.isPlayersTurnOver());
            } catch (Exception e) {
                System.out.println("Player One you have been defeated!\nSome options will display this message as your realm no longer exists.");
            }
            } else {
                System.out.println("Player Two you have been defeated!");
            }

            ////////////////////////////////////////////////////////////////////////
            // END GAME CHECK
            // determine if both players' realms have been decimated with NOT checks
            // if so then end the game
            ////////////////////////////////////////////////////////////////////////

            if(!World.getRealmsInTheWorld().containsKey(playerOne.getPlayersRealmId()) && !World.getRealmsInTheWorld().containsKey(playerTwo.getPlayersRealmId())){
                EndTheGame.setGameOver(true);
            }

            // boolean is if player opts to end game during their turn
        } while(!EndTheGame.getIsGameOver());

        // game is over display message
        EndTheGame.gameOverMessage();
    }
}
