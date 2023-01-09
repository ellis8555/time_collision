package Gameplay;

public class GameStartMessage {

    public String gameStartMessage(Player playerOne, Player playerTwo){

        String openingMessage = "\nWelcome "+playerOne.getName()+" and "+playerTwo.getName()+
                                " to Time Collision! The game where you may think to yourself, 'This doesn't make sense!'"+
                                "\nThe game ends when both players' realms have been decimated!";
        return openingMessage;
    }

}
