import java.util.Scanner;
import java.util.ArrayList;

public class COMP1020A4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map currentMap = null;
        System.out.println("Welcome to the park canoe route tool!");

        while (true) {
            printMenu();
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 0:
                        System.out.println("Goodbye!");
                        scanner.close();
                        return;
                    case 1:
                        System.out.print("Please enter the name of your map: ");
                        String mapName = scanner.nextLine().trim();
                        currentMap = new Map(mapName);
                        System.out.println("New map created.");
                        break;
                    case 2:
                        if (currentMap == null) {
                            System.out.println("No map exists. Please create a map first.");
                        } else {
                            System.out.print("Please enter the name of the lake file: ");
                            String lakeFile = scanner.nextLine().trim();
                            currentMap.loadLakes(lakeFile);
                            System.out.println("Lake file processing complete.");
                        }
                        break;
                    case 3:
                        if (currentMap == null) {
                            System.out.println("No map exists. Please create a map first.");
                        } else {
                            System.out.print("Please enter the name of the portage file: ");
                            String portageFile = scanner.nextLine().trim();
                            currentMap.loadPortages(portageFile);
                            System.out.println("Portage file processing complete.");
                        }
                        break;
                    case 4:
                        if (currentMap == null) {
                            System.out.println("No map exists. Please create a map first.");
                        } else {
                            double total = currentMap.getTotalPortageDistance();
                            System.out.printf("The total distance of trails in the park is %.2f km.\n", total);
                        }
                        break;
                    case 5:
                        if (currentMap == null) {
                            System.out.println("No map exists. Please create a map first.");
                        } else {
                            System.out.println(currentMap.toString());
                        }
                        break;
                    case 6:
                        if (currentMap == null) {
                            System.out.println("No map exists. Please create a map first.");
                        } else {
                            System.out.print("Please enter the name of the first lake: ");
                            String lake1 = scanner.nextLine().trim();
                            System.out.print("Please enter the name of the second lake: ");
                            String lake2 = scanner.nextLine().trim();
                            boolean exists = currentMap.portageExists(lake1, lake2);
                            System.out.println(exists ? "There is a portage between " + lake1 + " and " + lake2
                                    : "There is not a portage between " + lake1 + " and " + lake2);
                        }
                        break;
                    case 7:
                        if (currentMap == null) {
                            System.out.println("No map exists. Please create a map first.");
                        } else {
                            System.out.print("Please enter the name of the first lake: ");
                            String startLake = scanner.nextLine().trim();
                            System.out.print("Please enter the name of the second lake: ");
                            String endLake = scanner.nextLine().trim();
                            boolean routeExists = currentMap.routeExists(startLake, endLake);
                            System.out.println(routeExists ? "There is a route between " + startLake + " and " + endLake
                                    : "There is not a route between " + startLake + " and " + endLake);
                        }
                        break;
                    case 8:
                        if (currentMap == null) {
                            System.out.println("No map exists. Please create a map first.");
                        } else {
                            System.out.print("Please enter the name of the first lake: ");
                            String start = scanner.nextLine().trim();
                            System.out.print("Please enter the name of the second lake: ");
                            String end = scanner.nextLine().trim();
                            ArrayList<Route> routes = currentMap.getAllRoutes(start, end);
                            if (routes.isEmpty()) {
                                System.out.println("No route exists between " + start + " and " + end + ".");
                            } else {
                                Route.sortRoutes(routes);
                                Route shortest = routes.get(0);
                                System.out.println("The shortest route is: " + shortest);
                            }
                        }
                        break;
                    case 9:
                        if (currentMap == null) {
                            System.out.println("No map exists. Please create a map first.");
                        } else {
                            System.out.print("Please enter the name of the first lake: ");
                            String startAll = scanner.nextLine().trim();
                            System.out.print("Please enter the name of the second lake: ");
                            String endAll = scanner.nextLine().trim();
                            ArrayList<Route> allRoutes = currentMap.getAllRoutes(startAll, endAll);
                            if (allRoutes.isEmpty()) {
                                System.out.println("No routes found between " + startAll + " and " + endAll + ".");
                            } else {
                                System.out.println("All routes between " + startAll + " and " + endAll + " are:");
                                for (Route r : allRoutes) {
                                    System.out.println(r);
                                }
                            }
                        }
                        break;
                    default:
                        System.out.println("Invalid input! Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options are:");
        System.out.println(" 1: Create a new map");
        System.out.println(" 2: Load lakes from file");
        System.out.println(" 3: Load portages from file");
        System.out.println(" 4: Print total distance of all trails in park");
        System.out.println(" 5: Print map info, including all lakes");
        System.out.println(" 6: Test for portage between two lakes");
        System.out.println(" 7: Test for route between two lakes");
        System.out.println(" 8: Find shortest route between two lakes");
        System.out.println(" 9: Find all routes between two lakes");
        System.out.println(" 0: Exit");
        System.out.print("Enter your choice (0-9): ");
    }
}