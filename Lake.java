
import java.util.ArrayList;

public class Lake{
    private String name;
    private String waterQual;
    private ArrayList<Portage> portages = new ArrayList<>();
    public Lake(String name, String waterQual){
        this.name = name;
        this.waterQual = waterQual;
    }
    public String getName(){
        return name;
    }
    public String getWaterQuality(){
        return waterQual;
    }
    @Override
    public String toString() {
        String result = name + " has " + waterQual + " water quality, and is connected to: ";
        
        if (portages.isEmpty()) {
            return result + "no other lakes.";
        }
    
        for (Portage p : portages) {
            result += p.listOtherEnd(this) + ", ";
        }
    
        return result.substring(0, result.length() - 2); // Remove trailing ", "
    }
    
    public boolean addPortage(Portage portage){
        if(portage.ifSameOrOtherLake(this)){
            portages.add(portage);
            return true;
        }
        else{
            return false;
        }
    }
    public ArrayList<Portage> getPortageList(){
        return portages;
    }

    

}