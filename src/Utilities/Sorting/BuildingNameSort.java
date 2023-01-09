package Utilities.Sorting;

import Buildings.BuildingDesign;

import java.util.Comparator;

public class BuildingNameSort implements Comparator<BuildingDesign> {
    @Override
    public int compare(BuildingDesign b1, BuildingDesign b2) {
        return b1.getName().compareTo(b2.getName());
    }
}
