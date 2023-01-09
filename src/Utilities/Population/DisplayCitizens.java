package Utilities.Population;

import Enums.Occupations.GermanicSkills;
import Enums.Occupations.RomanSkills;
import Persons.PersonDesign;
import Territories.GermanicRegion.GermanicRealm;
import Territories.World;
import Utilities.Sorting.NameSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DisplayCitizens {

    //////////////////////////////////////////
    // UTILITY DISPLAY METHODS
    /////////////////////////////////////////

    // takes in a list of citizens
    public static void displayCitizens(ArrayList<PersonDesign> citizens){
        NameSort nameSort = new NameSort();
        Collections.sort(citizens, nameSort);
        Stream<PersonDesign> persons = citizens.stream();
        List<String> names = persons.map(
                element -> {
                    String name = element.getName();
                    String address = element.getHomeAddress();
                    String personsRealm = World.getRealmsInTheWorld().get(element.getRealmPersonBelongsTo()).getRealmName();
                    String worldCitizens = String.format("%-9s | Address: %3$s, %2$s", name, personsRealm, address);
                    return worldCitizens;
                }
        ).collect(Collectors.toList());
        names.forEach(element -> System.out.println(element));
    }

    // takes in a list of citizens with a sort method
    public static void displayCitizens(ArrayList<PersonDesign> citizens, Comparator comparator){
        Collections.sort(citizens, comparator);
        Stream<PersonDesign> persons = citizens.stream();
        List<String> names = persons.map(
                element -> {
                    String worldCitizens;
                    String name = element.getName();
                    String address = element.getHomeAddress();
                    String occupation = element.getOccupation().toString();
                    boolean isGermanic = World.getRealmsInTheWorld().get(element.getRealmPersonBelongsTo()) instanceof GermanicRealm;
                    String personsRealm = World.getRealmsInTheWorld().get(element.getRealmPersonBelongsTo()).getRealmName();
                    boolean isRuler = element.getIsRulerOfTheRealm();
                    if(isRuler){
                        if(isGermanic){
                            worldCitizens = String.format("%-9s is the "+ GermanicSkills.CHIEFTAIN+" of %2$s. Palace located at, %3$s", name, personsRealm, address);
                        }else{
                            worldCitizens = String.format("%-9s is "+ RomanSkills.CAESAR +" of %2$s. Palace located at, %3$s", name, personsRealm, address);
                        }
                    }else{
                        worldCitizens = String.format("%-9s - %2$s. | Address: %4$s, %3$s", name, occupation, personsRealm, address);
                    }
                    return worldCitizens;
                }
        ).collect(Collectors.toList());
        names.forEach(element -> System.out.println(element));
    }

    // takes in a single citizen
    public static void displayCitizen(PersonDesign citizen){
                    String name = citizen.getName();
                    String address = citizen.getHomeAddress();
                    String personsRealm = World.getRealmsInTheWorld().get(citizen.getRealmPersonBelongsTo()).getRealmName();
                    String thisCitizen = String.format("%-9s | Address: %3$s, %2$s", name, personsRealm, address);
                    System.out.println(thisCitizen);
    }
}
