package Gameplay;

public class EndTheGame {

    private static boolean isGameOver = false;

    public static void gameOverMessage(){
        System.out.println("Good game!");
    }

    public static void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public static boolean getIsGameOver(){
        return isGameOver;
    }
}
