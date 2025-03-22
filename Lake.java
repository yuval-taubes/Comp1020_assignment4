
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
    public String getWaterQual(){
        return waterQual;
    }
    public String toString(){
        String result = name + " has " + waterQual + " water quality, and is connected to: "
        + Portage.listOtherEnd(portages, this); 
        return result;
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
    public Lake findLake(String name){
        for (Lake lake : lakes) {
            if (lake.getName().equals(name)) {
                return lake;
            }
        }
        return null;
    }
    

}