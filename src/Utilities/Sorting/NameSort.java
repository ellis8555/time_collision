package Utilities.Sorting;

import Persons.PersonDesign;

import java.util.Comparator;

public class NameSort implements Comparator<PersonDesign> {
    @Override
    public int compare(PersonDesign p1, PersonDesign p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
