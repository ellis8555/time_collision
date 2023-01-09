package Gameplay.PlayerTurnOptions.DisplayOptions;

import Enums.Occupations.GermanicSkills;
import Enums.Occupations.RomanSkills;
import Territories.GermanicRegion.GermanicRealm;
import Territories.RealmDesign;
import Territories.World;

public class RulerOfRealmDisplay {

    public void rulerOfRealmDisplay(Integer realmId){
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);
        int rulersId = realm.getRulerID();
        if(rulersId != 1){
            if(realm instanceof GermanicRealm){
                System.out.println(World.getRealmsInTheWorld().get(realmId).displayRulerOfThisRealm()+" is "+ GermanicSkills.CHIEFTAIN +" of your realm!");
            }else{
                System.out.println(World.getRealmsInTheWorld().get(realmId).displayRulerOfThisRealm()+" is "+ RomanSkills.CAESAR +" of your realm!");
            }
        }else{
            System.out.println(World.getRealmsInTheWorld().get(realmId).displayRulerOfThisRealm());
        }
    }
}
