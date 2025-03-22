public class Main {
    public static void main(String[] args) {
        // Create a map
        Map myMap = new Map("Algonquin Provincial Park");

        // Add lakes
        System.out.println("Adding lakes...");
        System.out.println(myMap.addLake("Cedar Lake", "excellent")); // true
        System.out.println(myMap.addLake("Radiant Lake", "good"));    // true
        System.out.println(myMap.addLake("Little Cedar Lake", "excellent")); // true
        System.out.println(myMap.addLake("Cedar Lake", "poor"));  // false (duplicate)

        // Add portages
        System.out.println("\nAdding portages...");
        System.out.println(myMap.addPortage("Cedar Lake", "Radiant Lake", 5.2)); // true
        System.out.println(myMap.addPortage("Cedar Lake", "Little Cedar Lake", 2.7)); // true
        System.out.println(myMap.addPortage("Radiant Lake", "Little Cedar Lake", 3.1)); // true
        System.out.println(myMap.addPortage("Cedar Lake", "Lake Nonexistent", 10.0)); // false (invalid lake)

        // Print map details
        System.out.println("\nMap Details:");
        System.out.println(myMap);

        // Calculate total portage distance
        System.out.println("\nTotal Portage Distance: " + myMap.getTotalPortageDistance() + " km"); // Should be 11.0 km
    }
}
