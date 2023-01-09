package Utilities.Realms;

import Territories.RealmDesign;
import Territories.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GetRealmObjectByName {
    public static RealmDesign getRealm(String name) throws IndexOutOfBoundsException{
        // worlds list of realms
        HashMap<Integer, RealmDesign> realms = World.getRealmsInTheWorld();
        // get ids for each realm that exists and put them into an ArrayList
        ArrayList<Integer> realmIds = new ArrayList<>();
        for(Integer realmId : realms.keySet()){
            realmIds.add(realmId);
        }
        // get each realm's object and put those objects into an ArrayList
        ArrayList<RealmDesign> realmObjects = new ArrayList<>();
        for(Integer id : realmIds){
            realmObjects.add(realms.get(id));
        }
        RealmDesign realm = null;
        try {
            List<RealmDesign> nameMatches = realmObjects.stream().filter(element -> element.getRealmName().equals(name)).collect(Collectors.toList());
            if (nameMatches.size() == 0) {
                throw new IndexOutOfBoundsException("That realm does not exist in this world...");
            } else {
                realm = nameMatches.get(0);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return realm;
    }
}
