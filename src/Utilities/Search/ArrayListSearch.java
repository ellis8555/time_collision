package Utilities.Search;

import java.util.ArrayList;

public class ArrayListSearch {

    public int arrayListSearch(ArrayList<Integer> arrayList, int id){
        int count = 0;
        int placeHolder = 0;
        for(Integer i : arrayList){
            if(i == id){
                placeHolder = count;
            }
            count++;
        }
        return placeHolder;
    }
}
