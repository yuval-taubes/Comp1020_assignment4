import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Map {
    private String name;
    private ArrayList<Lake> lakes;
    private ArrayList<Portage> portages;

    public Map(String name) {
        this.name = name;
        this.lakes = new ArrayList<>();
        this.portages = new ArrayList<>();
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
        portages.add(newPortage);
        return true;
    }
    public ArrayList<Lake> getLakes(){
        return lakes;
    }
    public ArrayList<Portage> getPortages(){
        return portages;
    }

    public Lake findLake(String name) {
        for (Lake lake : lakes) {
            if (lake.getName().equals(name)) {
                return lake;
            }
        }
        return null;
    }

    public double getTotalPortageDistance(){
        ArrayList<Portage> countedPortages = new ArrayList<>();
        double totalDistance = 0;
    
        for (Lake lake : lakes) {
            for (Portage portage : lake.getPortageList()) {
                // Only count if it hasn't been added before
                if (!countedPortages.contains(portage)) {
                    countedPortages.add(portage);
                    totalDistance += portage.getDistance();
                }
            }
        }
        return totalDistance;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" contains the lakes:\n");
    
        for (Lake lake : lakes) {
            sb.append(lake.toString()).append("\n");
        }
    
        return sb.toString();
    }
    
       public void loadLakes(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 2) continue;
                
                String lakeName = parts[0].trim();
                String waterQuality = parts[1].trim();
                
                if (findLake(lakeName) != null) {
                    System.out.println("A lake with the name " + lakeName + " already exists! Not adding again.");
                } else {
                    addLake(lakeName, waterQuality);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }
    }

    public void loadPortages(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3) continue;
                
                String lakeName1 = parts[0].trim();
                String lakeName2 = parts[1].trim();
                double distance;
                
                try {
                    distance = Double.parseDouble(parts[2].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Error in number field. Ignoring the line!");
                    continue;
                }
                
                Lake lake1 = findLake(lakeName1);
                Lake lake2 = findLake(lakeName2);
                
                if (lake1 == null || lake2 == null) {
                    System.out.println("Failed to add portage!");
                    continue;
                }
                
                addPortage(lakeName1, lakeName2, distance);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }
    }

    // private Lake findLake(String name) {
    //     for (Lake lake : lakes) {
    //         if (lake.getName().equals(name)) {
    //             return lake;
    //         }
    //     }
    //     return null;
    // }

}
