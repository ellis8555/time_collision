package Gameplay.PlayerTurnOptions.DisplayOptions;

import Persons.PersonDesign;
import Territories.World;
import Utilities.Phones.Phonebook;
import Utilities.Sorting.NameSort;

import java.util.ArrayList;
import java.util.Collections;

public class RealmsPhonebookDisplay {

    public void displayMyRealmsPhoneBook(Integer realmId){
        ArrayList<PersonDesign> citizens = World.getRealmsInTheWorld().get(realmId).getCitizensObjects();
        NameSort nameSort = new NameSort();
        Collections.sort(citizens, nameSort);
        Phonebook.displayPhonebook(citizens);
    }

}
