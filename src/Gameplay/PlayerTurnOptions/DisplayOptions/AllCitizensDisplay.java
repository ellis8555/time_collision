package Gameplay.PlayerTurnOptions.DisplayOptions;

import Territories.World;
import Utilities.Population.DisplayCitizens;
import Utilities.Sorting.NameSort;

public class AllCitizensDisplay {

    public void displayPlayersCitizens(Integer realmId){
        NameSort nameSort = new NameSort();
        DisplayCitizens.displayCitizens(World.getRealmsInTheWorld().get(realmId).getCitizensObjects(), nameSort);
    }

}
