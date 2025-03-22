import java.util.ArrayList;
import java.util.HashSet;

public class Map {
    String name;
    ArrayList<Lake> lakes;

    public Map(String name) {
        this.name = name;
        this.lakes = new ArrayList<>();
    }

    public boolean addLake(String name, String waterQual) {
        if (findLake(name) != null) { // Check if the lake already exists
            return false;
        }
        lakes.add(new Lake(name, waterQual));
        return true;
    }

    public boolean addPortage(String lakeName1, String lakeName2, double distance) {
        Lake lake1 = findLake(lakeName1);
        Lake lake2 = findLake(lakeName2);

        if (lake1 == null || lake2 == null) {
            return false; // Portage can't be added if one of the lakes doesn't exist
        }

        Portage newPortage = new Portage(lake1, lake2, distance);
        lake1.addPortage(newPortage);
        lake2.addPortage(newPortage);
        return true;
    }

    public Lake findLake(String name) {
        for (Lake lake : lakes) {
            if (lake.getName().equals(name)) {
                return lake;
            }
        }
        return null;
    }

    public double getTotalPortageDistance() {
        HashSet<Portage> uniquePortages = new HashSet<>();
        for (Lake lake : lakes) {
            uniquePortages.addAll(lake.getPortageList());
        }

        double totalDistance = 0;
        for (Portage portage : uniquePortages) {
            totalDistance += portage.getDistance();
        }
        return totalDistance / 2; // Since each portage is counted twice
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" contains the lakes:\n");
    
        for (Lake lake : lakes) {
            sb.append(lake.toString()).append("\n");
        }
    
        return sb.toString();
    }
    

}
