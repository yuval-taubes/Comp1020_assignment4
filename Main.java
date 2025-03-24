public class Main {
    public static void main(String[] args) {
        Map map = new Map("map");
        
        // Load lakes from file
        System.out.println("Loading lakes from file...");
        map.loadLakes("lakes.txt");
        
        // Display loaded lakes
        System.out.println("\nLakes in the map:");
        for (Lake lake : map.getLakes()) {
            System.out.println(lake);
        }
        
        // Load portages from file
        System.out.println("\nLoading portages from file...");
        map.loadPortages("portages.txt");
        
        // Display loaded portages
        System.out.println("\nPortages in the map:");
        for (Portage portage : map.getPortages()) {
            System.out.println(portage);
        }
    }
}
