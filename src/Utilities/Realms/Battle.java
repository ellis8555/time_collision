package Utilities.Realms;

import Persons.PersonDesign;
import Territories.RealmDesign;
import Territories.World;
import Utilities.Population.RemoveCitizen;
import java.util.ArrayList;
import java.util.Random;

public class Battle {

    // method for army vs citizens
    public void battleVsCitizens(RealmDesign attackingRealm, RealmDesign defendersRealm) {
        ///////////////////
        // invading force
        ///////////////////

        ArrayList<Integer> attackingRealmsArmyIds = attackingRealm.getArmyOfThisRealm();

        ///////////////////
        // defending force
        ///////////////////

        ArrayList<Integer> defendingRealmsCitizens = defendersRealm.getCitizensIdOfThisRealm();

        ///////////////////
        // The battle
        ///////////////////

        // size of invading army
        int invadersCount = attackingRealmsArmyIds.size();
        // invading casualties
        int invadersCasualties = 0;
        // number of defenders
        int defendersCount = defendingRealmsCitizens.size();
        // defenders casualties
        int defendersCasualties = 0;

        int roundNumber = 1;
        do{
            // set random numbers for randomized winners of battle
            // higher odds of winning if soldier
            Random random = new Random();
            int number = random.nextInt(100);
            // get invading fighters status
            boolean isInvadingFighterTheRuler = isRuler(attackingRealmsArmyIds.get(0));
            // get defending fighters status
            boolean isDefendingFighterTheRuler = isRuler(defendingRealmsCitizens.get(0));
            // higher percent of winning
            boolean divByTwo = (number%2 == 0) ? true : false;
            // lower percent of winning
            boolean divByThree = (number%3 == 0) ? true : false;
            // if both fighters are rulers then odds of winning are 50%.
            if(isDefendingFighterTheRuler){
                if(divByTwo){
                    new RemoveCitizen().removeCitizen(attackingRealmsArmyIds.get(0), attackingRealm.getArmyOfThisRealm(), attackingRealm);
                    if(isInvadingFighterTheRuler){
                        attackingRealm.setRulerId();
                        System.out.println(attackingRealm.getRealmName()+"'s leader has been killed in the battle!");
                    }
                    invadersCount -= 1;
                    invadersCasualties++;
                }else{
                    new RemoveCitizen().removeCitizen(defendingRealmsCitizens.get(0), defendersRealm.getArmyOfThisRealm(), defendersRealm);
                    defendersRealm.setRulerId();
                    defendersCount -= 1;
                    defendersCasualties++;
                    System.out.println(defendersRealm.getRealmName()+"'s leader has been killed in the battle!");
                }
            } else {
                if(divByThree){
                    new RemoveCitizen().removeCitizen(attackingRealmsArmyIds.get(0), attackingRealm.getArmyOfThisRealm(), attackingRealm);
                    if(isInvadingFighterTheRuler){
                        attackingRealm.setRulerId();
                        System.out.println(attackingRealm.getRealmName()+"'s leader has been killed in the battle!");
                    }
                    invadersCount -= 1;
                    invadersCasualties++;
                }else{
                    new RemoveCitizen().removeCitizen(defendingRealmsCitizens.get(0), defendersRealm.getArmyOfThisRealm(), defendersRealm);
                    defendersCount -= 1;
                    defendersCasualties++;
                }
            }
        } while (invadersCount > 0 && defendersCount > 0);

        // if the defending realm is decimated
        if(defendersCount < 1){
            // message displaying the defending realm has been destroyed
            System.out.println(defendersRealm.getRealmName()+"'s population has been decimated and the realm has fallen into the history books!");
            // remove the realm from the game
            new RemoveRealmFromWorld().removeRealmFromWorld(defendersRealm);
            // else the invading force was defeated and the defending realm still exists
        } else {
            System.out.println(attackingRealm.getRealmName()+"'s invading army has been defeated and the realm is safe!");
        }
        // display battle stats
        System.out.println("What a horrendous battle!\nInvaders killed: "+invadersCasualties+"\nDefenders killed: "+defendersCasualties);
    }

    // method for army vs army

    public void battleVsArmy(RealmDesign attackingRealm, RealmDesign defendersRealm) {
        ///////////////////
        // invading force
        ///////////////////

        ArrayList<Integer> attackingRealmsArmyIds = attackingRealm.getArmyOfThisRealm();

        ///////////////////
        // defending force
        ///////////////////

        ArrayList<Integer> defendingRealmsArmy = defendersRealm.getArmyOfThisRealm();

        ///////////////////
        // The battle
        ///////////////////

        // size of invading army
        int invadersCount = attackingRealmsArmyIds.size();
        // invading casualties
        int invadersCasualties = 0;
        // number of defenders
        int defendersCount = defendingRealmsArmy.size();
        // defenders casualties
        int defendersCasualties = 0;

        int roundNumber = 1;
        do{
            // set random numbers for randomized winners of battle
            // higher odds of winning if soldier
            Random random = new Random();
            int number = random.nextInt(100);
            // get invading fighters status
            boolean isInvadingFighterTheRuler = isRuler(attackingRealmsArmyIds.get(0));
            // get defending fighters status
            boolean isDefendingFighterTheRuler = isRuler(defendingRealmsArmy.get(0));
            // higher percent of winning
            boolean divByTwo = (number%2 == 0) ? true : false;
            // lower percent of winning
            boolean divByThree = (number%3 == 0) ? true : false;
            // if both fighters are rulers then odds of winning are 50%.
            if(isDefendingFighterTheRuler){
                if(divByTwo){
                    new RemoveCitizen().removeCitizen(attackingRealmsArmyIds.get(0), attackingRealm.getArmyOfThisRealm(), attackingRealm);
                    if(isInvadingFighterTheRuler){
                        attackingRealm.setRulerId();
                        System.out.println(attackingRealm.getRealmName()+"'s leader has been killed in the battle!");
                    }
                    invadersCount -= 1;
                    invadersCasualties++;
                }else{
                    new RemoveCitizen().removeCitizen(defendingRealmsArmy.get(0), defendersRealm.getArmyOfThisRealm(), defendersRealm);
                    defendersRealm.setRulerId();
                    defendersCount -= 1;
                    defendersCasualties++;
                    System.out.println(defendersRealm.getRealmName()+"'s leader has been killed in the battle!");
                }
            } else {
                if(divByTwo){
                    new RemoveCitizen().removeCitizen(attackingRealmsArmyIds.get(0), attackingRealm.getArmyOfThisRealm(), attackingRealm);
                    if(isInvadingFighterTheRuler){
                        attackingRealm.setRulerId();
                        System.out.println(attackingRealm.getRealmName()+"'s leader has been killed in the battle!");
                    }
                    invadersCount -= 1;
                    invadersCasualties++;
                }else{
                    new RemoveCitizen().removeCitizen(defendingRealmsArmy.get(0), defendersRealm.getArmyOfThisRealm(), defendersRealm);
                    defendersCount -= 1;
                    defendersCasualties++;
                }
            }
        } while (invadersCount > 0 && defendersCount > 0);
        // if defenders army has been defeated then run battle method army vs citizens
        if(defendersCount < 1){
            // message displaying the defending army has been defeated
            System.out.println(defendersRealm.getRealmName()+"'s army has been defeated! The citizens must fight for their own survival!");
            new Battle().battleVsCitizens(attackingRealm, defendersRealm);
        } else {
            System.out.println(attackingRealm.getRealmName()+"'s invading army has been defeated and the realm is safe!");
        }
        System.out.println("What a horrendous battle!\nInvaders killed: "+invadersCasualties+"\nDefenders killed: "+defendersCasualties);
    }

    // helper method for battle methods
    private boolean isRuler(Integer personId){
        PersonDesign person = World.getWorldsPeopleObjectsMAPPED().get(personId);
        return person.getIsRulerOfTheRealm();
    }
}
