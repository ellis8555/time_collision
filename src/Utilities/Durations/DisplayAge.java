package Utilities.Durations;

public class DisplayAge {

    // get persons age
    public String displayAge(long getAge){
        long age = getAge;
        StringBuilder displayAge = new StringBuilder();
        if(age<1_000){
            System.out.println("Im "+age+" milliseconds old!");
        } else if (age<60_000) {
            long seconds = Math.round(age/1000);
            long milliSeconds = age%1000;
            displayAge.append("Im "+seconds+" seconds and "+milliSeconds+" milliseconds old!");
        } else if (age<3_600_000) {
            long minutes = Math.round(age/60_000);
            long seconds = Math.round((age%60_000)/1_000);
            long milliSeconds = age-(minutes*60_000)-(seconds*1_000);
            displayAge.append("Im "+minutes+" minutes, "+seconds+" seconds and "+milliSeconds+" milliseconds of age!");
        } else {
            displayAge.append("Im way to old for you to comprehend! Like over one hour old!");
        }
        return displayAge.toString();
    }
}
