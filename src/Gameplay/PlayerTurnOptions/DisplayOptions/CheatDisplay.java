package Gameplay.PlayerTurnOptions.DisplayOptions;

import Buildings.BuildingDesign;
import Enums.Occupations.GermanicSkills;
import Enums.Occupations.RomanSkills;
import Persons.PersonDesign;
import Territories.GermanicRegion.GermanicRealm;
import Territories.RealmDesign;
import Territories.RomanRegion.RomanRealm;
import Territories.World;
import Utilities.Sorting.BuildingNameSort;
import Utilities.Sorting.NameSort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CheatDisplay {

    public void cheatDisplay(){
        System.out.println("\n********************************************************************************************");
        System.out.println("----------------------CHEAT MODE--------------------------CHEAT MODE------------------------");
        System.out.println("********************************************************************************************");
        System.out.println("\nCheat mode for demonstrative purposes only.\nIf I were to continue developing this game then a player would have to perform a raid or some other kind information seeking task from the enemy.\nWith risk of course. A successful raid could for instance yield information on an enemies citizen or building.\n");
        // get how many realms currently exist
        int realmCount = World.getRealmCount();
        System.out.println("There currently are "+realmCount+" realm's in the world!");
        // display how many realms there are of each germanic and roman
        int germanicRealmCount = GermanicRealm.getGermanicRealmCount();
        int romanRealmCount = RomanRealm.getRomanRealmCount();
        System.out.println("\nThere currently are "+germanicRealmCount+" Germanic realms and "+romanRealmCount+" Roman realms in the world.\n");
        // display each realm with its current ruler
        for(RealmDesign realm : World.getRealmObjects()){
            String realmName = realm.getRealmName();
            String rulerOfThisRealm = realm.displayRulerOfThisRealm();
            if(realm instanceof GermanicRealm){
                System.out.println(realmName+": "+ GermanicSkills.CHIEFTAIN+" - "+rulerOfThisRealm);
            }else{
                System.out.println(realmName+": "+ RomanSkills.CAESAR+" - "+rulerOfThisRealm);
            }
        }
        // display the worlds population
        int currentPopulation = World.getWorldPopulation();
        System.out.println("\nThe current population of the world is "+currentPopulation+"");
        // display how many of each germanic and roman citizens there are in the world
        int germanicCitizenCount = GermanicRealm.getGermanicCitizenCount();
        int romanCitizenCount = RomanRealm.getRomanCitizenCount();
        System.out.println("\nCurrently there are "+germanicCitizenCount+" Germanic citizens and "+romanCitizenCount+" Roman citizens in the world.");
        // display buildings that are not home to citizens
        System.out.println("\nList of all business buildings.\n");
        BuildingNameSort buildingNameSort = new BuildingNameSort();
        List<BuildingDesign> buildingList = (List<BuildingDesign>) World.getWorldsBuildingsObjects();
        Collections.sort(buildingList, buildingNameSort);
        List<String> sortedBuildingsList = buildingList.stream().filter(element ->
                element.getBuildingType() != "dwelling"
        ).filter(element -> element.getBuildingType() != "home").map(element -> {
            String businessName = element.getName();
            String phoneNumber = element.getPhoneNumber();
            String realmName = World.getRealmsInTheWorld().get(element.getRealmBuildingBelongsTo()).getRealmName();
            return String.format("%1$s | Call us today at %2$s: Located in the realm of %3$s", businessName, phoneNumber, realmName);
        }).collect(Collectors.toList());
        sortedBuildingsList.forEach(
                element -> System.out.println(element)
        );
        System.out.println();
        // display citizens of the world
        NameSort nameSort = new NameSort();
        ArrayList<PersonDesign> worldsCitizens = World.getWorldsCitizensObjects();
        Collections.sort(worldsCitizens, nameSort);
        System.out.println("Citizens of the world in alphabetic order by name");
        // display all citizens with a counter to number each citizen
        int personCount = 1;
        for(PersonDesign person : worldsCitizens){
            System.out.println();
            System.out.println(personCount+". -------");
            System.out.println(person);
            personCount++;
        }
    }

}
