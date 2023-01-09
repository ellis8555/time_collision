package Utilities.Durations;

public class DisplayTimeServedInArmy {

    // get persons age
    public static String displayTimeServedInArmy(long getTime){
        long timeServed = getTime;
        StringBuilder displayTimeServed = new StringBuilder();
        if(timeServed<1_000){
            System.out.println("has served for "+timeServed+" milliseconds");
        } else if (timeServed<60_000) {
            long seconds = Math.round(timeServed/1000);
            long milliSeconds = timeServed%1000;
            displayTimeServed.append("has served for "+seconds+" seconds and "+milliSeconds+" milliseconds!");
        } else if (timeServed<3_600_000) {
            long minutes = Math.round(timeServed/60_000);
            long seconds = Math.round((timeServed%60_000)/1_000);
            long milliSeconds = timeServed-(minutes*60_000)-(seconds*1_000);
            displayTimeServed.append("has served for "+minutes+" minutes, "+seconds+" seconds and "+milliSeconds+" milliseconds!");
        } else {
            displayTimeServed.append("Im practically a veteran!");
        }
        return displayTimeServed.toString();
    }

}
