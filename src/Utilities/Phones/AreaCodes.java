// an object of this class is created in class "Main's" main() method allowing access to area codes for all realms
// area codes for each new person is set upon that persons creation as "areaCode" property which searches this class' areaCodes LinkedHashMap "areaCodes"

package Utilities.Phones;
import java.util.HashMap;
import java.util.Map;

public class AreaCodes {

    ////////////////////////////////////////////
    // FIELDS
    ////////////////////////////////////////////
    public static HashMap<String, Integer> areaCodes = new HashMap<>();

    //////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////



    //////////////////////////////////////////
    // GETTERS
    /////////////////////////////////////////

    public static void getListOfAreaCodes(){
        if(areaCodes.size() > 0){
            for(Map.Entry<String, Integer> e : areaCodes.entrySet()){
                System.out.println(e.getKey()+" - "+e.getValue());
            }
        } else {
            System.out.println("There are no area codes as of yet!");
        }

    }

    //////////////////////////////////////////
    // UTILITY FUNCTIONS
    /////////////////////////////////////////

    public static void addRealmToDirectory(String name, int realmCode){
        areaCodes.put(name, realmCode);
    }
}
