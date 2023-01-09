package Utilities.Phones;

import Persons.PersonDesign;
import Territories.World;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Phonebook {

    //////////////////////////////////////////
    // UTILITY DISPLAY METHODS
    /////////////////////////////////////////

    public static void displayPhonebook(ArrayList<PersonDesign> citizens){
        Stream<PersonDesign> persons = citizens.stream();
        List<String> names = persons.map(
                element -> {
                    String name = element.getName();
                    String personsRealm = World.getRealmsInTheWorld().get(element.getRealmPersonBelongsTo()).getRealmName();
                    String personsHomePhoneNumber = element.getHomePhoneNumber();
                    String personsCellNumber = element.getCellNumber();
                    String personHomeAddress = element.getHomeAddress();
                    String citizen = String.format("%-9s Home - %5$s | Cell - %3$s | Address: %4$s, %2$s", name, personsRealm, personsCellNumber, personHomeAddress, personsHomePhoneNumber);
                    return citizen;
                }
        ).collect(Collectors.toList());
        names.forEach(element -> System.out.println(element));
    }
}
