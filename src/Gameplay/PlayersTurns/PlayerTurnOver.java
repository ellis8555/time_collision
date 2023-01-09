package Gameplay.PlayersTurns;

import Gameplay.Player;

public class PlayerTurnOver {
    private static boolean isPlayersTurnOver = false;

    public static void turnOverMessage(Player player){
        System.out.println(player.getName()+" turn is over");
    }

    public static void setIsPlayersTurnOver(boolean turnOver){isPlayersTurnOver = turnOver;};

    public static boolean isPlayersTurnOver() {
        return isPlayersTurnOver;
    }
}
