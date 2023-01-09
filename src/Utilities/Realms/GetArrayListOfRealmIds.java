package Utilities.Realms;

import Territories.World;

import java.util.ArrayList;

public class GetArrayListOfRealmIds {

    private static ArrayList<Integer> realmIds() {
        ArrayList<Integer> realmIds = new ArrayList<>();
        for (Integer ids : World.getRealmsInTheWorld().keySet()) {
            realmIds.add(ids);
        }
        return realmIds;
    }

    public static ArrayList<Integer> getArrayListOfRealmIds(){
        return realmIds();
    }
}
