
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
        String result = name + " has " + waterQual + " water quality";
        return result;
    }
    public void addPortage(Portage portage){
        if(portage.otherEnd(name) == name);
        portages.add(portage);
    }
}