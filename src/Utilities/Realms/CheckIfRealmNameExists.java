package Utilities.Realms;


import Territories.RealmDesign;
import java.util.ArrayList;
import java.util.HashMap;

public class CheckIfRealmNameExists {
    public static boolean DoesNameExist(String name, HashMap<Integer, RealmDesign> realms){
        // get each realm's id needed to loop through realm hashmap
        ArrayList<Integer> realmIds = new ArrayList<>();
        for(Integer id : realms.keySet()){
            realmIds.add(id);
        }
        // get each realms object using the realms ids contained in Arraylist realmIds
        ArrayList<RealmDesign> realmObjects = new ArrayList<>();
        for(Integer id : realmIds){
            realmObjects.add(realms.get(id));
        }
        ArrayList<String> realmNames = new ArrayList<>();
        for(RealmDesign realm : realmObjects){
            realmNames.add(realm.getRealmName());
        }
        // if another realm is not named the same then create this realm
        return realmNames.contains(name);
    }
}
