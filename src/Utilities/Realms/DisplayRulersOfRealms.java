package Utilities.Realms;

import Territories.World;

import java.util.ArrayList;

public class DisplayRulersOfRealms {

    private ArrayList<Integer> realmIds;

    public DisplayRulersOfRealms(){

        realmIds = GetArrayListOfRealmIds.getArrayListOfRealmIds();

        for(Integer realmId : realmIds){
            String ruler = World.getRealmsInTheWorld().get(realmId).displayRulerOfThisRealm();
            String realm = World.getRealmsInTheWorld().get(realmId).getRealmName();
            System.out.println(ruler+" ruler of the "+realm);
        }
    }
}
