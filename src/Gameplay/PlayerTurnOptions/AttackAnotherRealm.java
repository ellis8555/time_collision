package Gameplay.PlayerTurnOptions;

import Territories.GermanicRegion.GermanicRealm;
import Territories.RealmDesign;
import Territories.World;
import Utilities.Realms.Battle;
import Utilities.Realms.GetArrayListOfRealmIds;
import Utilities.Realms.GetRealmObjectByName;
import Utilities.UserInputs.Inputs.NameInputWithSpaces;
import java.util.ArrayList;


public class AttackAnotherRealm {

    private boolean doesPlayerHaveAnArmy = true;

    public boolean attackAnotherRealm(Integer realmId) {
        // get attacking realms object
        RealmDesign attackingRealmsObject = World.getRealmsInTheWorld().get(realmId);
        // reset army to grab any newly recruited soldiers that were recently changed to a soldier
        attackingRealmsObject.resetArmyOfThisRealm();
        int sizeOfAttackingArmy = attackingRealmsObject.getArmyOfThisRealm().size();
        if(sizeOfAttackingArmy < 1){
            doesPlayerHaveAnArmy = false;
            if(attackingRealmsObject instanceof GermanicRealm){
                System.out.println("You currently have no warriors in your army.\nEdit a citizens object occupation to warrior which enlists that citizen into the army.");
            }else{
                System.out.println("You currently have no centurions in your army.\nEdit a citizens object occupation to centurion which enlists that citizen into the army.");
            }
        } else {
            // get all realm ids
            ArrayList<Integer> listOfRealmIds = GetArrayListOfRealmIds.getArrayListOfRealmIds();
            // remove players realm from list of all realms
            ArrayList<Integer> updatedRealmList = new ArrayList<>(listOfRealmIds);
            updatedRealmList.remove(realmId);
            // obtain which realm player wants to attack
            System.out.println("Type the name of which realm you are attacking");
            for (Integer thisRealmsId : updatedRealmList) {
                String realmName = World.getRealmsInTheWorld().get(thisRealmsId).getRealmName();
                System.out.println(realmName);
            }
            // begin getting user input for realm they would like to attack
            // check that entered realm exists and also is NOT the players own realm
            String enteredRealm = NameInputWithSpaces.nameInputWithSpaces();
            RealmDesign defendingRealmsObject = GetRealmObjectByName.getRealm(enteredRealm);
            // check if player entered a realm that exists
            while(defendingRealmsObject == null){
                System.out.println("Make sure to type in the name of the realm you would like to attack correctly.\nTry again.");
                enteredRealm = NameInputWithSpaces.nameInputWithSpaces();
                defendingRealmsObject = GetRealmObjectByName.getRealm(enteredRealm);
            }
            // check if player entered in their own realm
            while(defendingRealmsObject.getRealmId() == realmId){
                System.out.println("Are you trying to start a civil war!\nEnter in a realm that is not your own!");
                StringBuilder enteredNameStringBuilder = new StringBuilder();
                enteredNameStringBuilder.append(NameInputWithSpaces.nameInputWithSpaces());
                defendingRealmsObject = GetRealmObjectByName.getRealm(enteredNameStringBuilder.toString());
                // make sure new input is a realm that exists
                while(defendingRealmsObject == null){
                    System.out.println("Make sure to type in the name of the realm you would like to attack correctly.\nTry again.");
                    enteredRealm = NameInputWithSpaces.nameInputWithSpaces();
                    defendingRealmsObject = GetRealmObjectByName.getRealm(enteredRealm);
                }
            }
            ////////////////////////////////////////////////////////////////
            // attackingRealmsObject is the ATTACKERS REALM
            // defendingRealmObject is the DEFENDING REALM
            ////////////////////////////////////////////////////////////////

            // get defending realms name
            String defendingRealname = defendingRealmsObject.getRealmName();
            // see if the defending realm has an army
            int defendingRealmsArmySize = defendingRealmsObject.getArmyOfThisRealm().size();
            // if defenders have no standing army
            if(defendingRealmsArmySize < 1){
                System.out.println("The realm of "+defendingRealname+" has no standing army commander!\nThen attack the city and destroy everyone!");
                // run battle method vs citizens
                new Battle().battleVsCitizens(attackingRealmsObject, defendingRealmsObject);
            }else{
                // defending realm does have an army
                System.out.println("The realm of "+defendingRealname+" does have a standing army! We have a battle to fight commander!");
                // run battle method army vs army
                new Battle().battleVsArmy(attackingRealmsObject, defendingRealmsObject);
                // end code block if attacking player does have an army
            }
        }
        // code here will only run if attacker does not have an army
        // end attackAnotherRealm
        return doesPlayerHaveAnArmy;
    }
    // end class
}
