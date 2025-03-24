import java.util.ArrayList;

public class Route {
    private String startLake;
    private String endLake;
    private ArrayList<Portage> portages;

    public Route(String endLake, ArrayList<Portage> portages) {
        this.endLake = endLake;
        //so says instructions
        this.portages = new ArrayList<>(portages);

        if (!portages.isEmpty()) {
            Portage firstPortage = portages.get(0);
            if (firstPortage.getStartName().equals(endLake)) {
                startLake = firstPortage.getEndName();
            } else {
                startLake = firstPortage.getStartName();
            }
        } else {
            startLake = "Unknown";
        }
    }

    public double getDistance() {
        double totalDistance = 0;
        for (Portage p : portages) {
            totalDistance += p.getDistance();
        }
        return totalDistance;
    }

    public String toString() {
        String result = "Route from " + startLake + " to " + endLake +
                        " is " + String.format("%.2f", getDistance()) + " km: ";

        if (portages.isEmpty()) {
            return result + startLake + ", " + endLake;
        }

        result += startLake;
        for (Portage p : portages) {
            result += ", " + p.otherEnd(startLake);
        }

        return result;
    }

    public int compareTo(Route other) {
        return Double.compare(this.getDistance(), other.getDistance());
    }

    public static void sortRoutes(ArrayList<Route> routes) {
        int n = routes.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (routes.get(j).compareTo(routes.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            Route temp = routes.get(i);
            routes.set(i, routes.get(minIndex));
            routes.set(minIndex, temp);
        }
    }
}
