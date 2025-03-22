import java.util.*;
public class Portage {
    private double distance;
    private Lake lake1;
    private Lake lake2;

    public Portage(Lake lake1, Lake lake2, double distance){
        this.lake1 = lake1;
        this.lake2 = lake2;
        this.distance = distance;
    }
    
    
    public String getStartName(){
        return lake1.getName();
    }
    public String getEndName(){
        return lake2.getName();
    }
    public Lake getStart(){
        return lake1;
    }
    public Lake getEnd(){
        return lake2;
    }
    public double getDistance(){
        return distance;
    }
    public String toString(){
        String result = lake1.getName() + " and " + lake2.getName()
        + "are connected by a portage of " + String.format("%.2f", distance) + " km";
        return result;
    }
    public String listOtherEnd(Lake current) {
        return (current.equals(lake1)) ? lake2.getName() : lake1.getName();
    }
    
    public String otherEnd(String lakeName){
        if(lakeName.equals(lake1.getName())){
            return lake2.getName();
        }
        else if(lakeName.equals(lake2.getName())){
            return lake1.getName();
        }
        return null;
    }
    
    public Lake otherEnd(Lake lake){
        if(lake == lake1){
            return lake2;
        }
        else if(lake == lake2){
            return lake1;
        }
        else{
            return null;
        }
    }
    public boolean ifSameOrOtherLake(Lake lake){
        if(lake == lake1 || lake == lake2){
            return true;
        }
        else{
            return false;
        }
    }
}
