package Gameplay.PlayerTurnOptions.DisplayOptions;

import Persons.PersonDesign;
import Territories.GermanicRegion.GermanicRealm;
import Territories.RealmDesign;
import Territories.World;

public class DisplayArmy {

    public void displayArmy(Integer realmId){
        RealmDesign realm = World.getRealmsInTheWorld().get(realmId);
        realm.resetArmyOfThisRealm();
        int sizeOfArmy = realm.getArmyOfThisRealm().size();
        if(sizeOfArmy > 0){
            System.out.println("----------------------CONFIDENTIAL---------ARMY-------------------------");
            if(sizeOfArmy == 1){
                System.out.println("\nYou currently have "+sizeOfArmy+" citizen in your army.");
            }else{
                System.out.println("\nYou currently have "+sizeOfArmy+" citizens in your army.");
            }
            for(Integer citizensId : realm.getArmyOfThisRealm()){
                PersonDesign citizen = World.getWorldsPeopleObjectsMAPPED().get(citizensId);
                String citizensName = citizen.getName();
                String citizensTimeServedInArmy = citizen.displayTimeServedInArmy();
                System.out.println(citizensName+": "+citizensTimeServedInArmy);
            }
            System.out.println("\n--------------------ARMY----------CONFIDENTIAL------------------------");
        }else{
            if(realm instanceof GermanicRealm){
                System.out.println("\nYou currently have no army.\nYou need to promote a citizen to a warrior. This will conscript that person into the army.");
            }else{
                System.out.println("\nYou currently have no army.\nYou need to promote a citizen to a centurion. This will conscript that person into the army.");
            }
        }
    }

}
