package Utilities.Population;

import Persons.PersonDesign;
import Territories.World;
import Utilities.UserInputs.Inputs.NumberInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GetCitizensObjectByName {

    // get any citizens object from a realm by name
    public static PersonDesign getCitizen(String name, ArrayList<PersonDesign> citizens) throws IndexOutOfBoundsException {
        PersonDesign person = null;
        try {
            List<PersonDesign> nameMatches = citizens.stream().filter(element -> element.getName().equals(name)).collect(Collectors.toList());
            if (nameMatches.size() == 0) {
                throw new IndexOutOfBoundsException("That person is not a citizen of the realm...");
            } else if (nameMatches.size() == 1) {
                person = nameMatches.get(0);
            } else {
                System.out.println("There are " + nameMatches.size() + " " + name + "'s in this realm.\nSelect which " + name + " you are referring to..");
                for(int i=0;i < nameMatches.size();i++){
                    int index = i+1;
                    String cellNumber = nameMatches.get(i).getCellNumber();
                    String personsAddress = nameMatches.get(i).getHomeAddress();
                    String citizen = String.format("%1$d. Phone#: %2$-11s Home Address: %3$s ",index , cellNumber, personsAddress);
                    System.out.println(citizen);
                }
                int selectionChoice = NumberInput.numberInput();
                person = nameMatches.get(selectionChoice-1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return person;
    }

    // get persons object from entire world by name
        public static PersonDesign getCitizen(String name, HashMap<Integer, PersonDesign> citizens) throws IndexOutOfBoundsException{
            // get ids for each realm that exists and put them into an ArrayList
            ArrayList<Integer> personIds = new ArrayList<>();
            for(Integer personId : citizens.keySet()){
                personIds.add(personId);
            }
            // get each realm's object and put those objects into an ArrayList
            ArrayList<PersonDesign> personObjects = new ArrayList<>();
            for(Integer id : personIds){
                personObjects.add(citizens.get(id));
            }
            PersonDesign person = null;
            try {
                List<PersonDesign> nameMatches = personObjects.stream().filter(element -> element.getName().equals(name)).collect(Collectors.toList());
                if (nameMatches.size() == 0) {
                    throw new IndexOutOfBoundsException("That person is not a citizen of the realm...");
                } else if (nameMatches.size() == 1) {
                    person = nameMatches.get(0);
                } else {
                    System.out.println("There are " + nameMatches.size() + " " + name + "'s in the world.\nSelect which " + name + " you are referring to..");
                    for(int i=0;i < nameMatches.size();i++){
                        int index = i+1;
                        String cellNumber = nameMatches.get(i).getCellNumber();
                        String realmName = World.getRealmsInTheWorld().get(nameMatches.get(i).getRealmPersonBelongsTo()).getRealmName();
                        String personsAddress = nameMatches.get(i).getHomeAddress();
                        String citizen = String.format("%1$d. Phone#: %2$-11s Home Address: %3$s, Realm: %4$s",index , cellNumber, personsAddress, realmName);
                        System.out.println(citizen);
                    }
                    int selectionChoice = NumberInput.numberInput();
                    person = nameMatches.get(selectionChoice-1);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            return person;
        }
    }

