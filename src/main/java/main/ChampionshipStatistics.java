/**
 * Does math for the rally
 */
package main;
public class ChampionshipStatistics {
    /**
     * Find average points
     */
    public static double findAvgPoints(ChampionshipManager manager) {
        int total = manager.addAllPoints();
        if (manager.driverCount == 0) return 0;
        return (double) total / manager.driverCount;
    }

    /**
     * Find the best country
     */
    public static String findBestCountry(ChampionshipManager manager) {
        if (manager.driverCount == 0) return "None";
        String[] countries = new String[100];
        int[] countryPoints = new int[100];
        int countryCount = 0;

        // Add up points for each country
        for (int i = 0; i < manager.driverCount; i++) {
            String driverCountry = manager.drivers[i].getCountry(); // Fixed variable name
            int points = manager.drivers[i].getPoints();
            boolean found = false;
            for (int j = 0; j < countryCount; j++) {
                if (countries[j].equals(driverCountry)) { // Use driverCountry
                    countryPoints[j] = countryPoints[j] + points;
                    found = true;
                    break;
                }
            }
            if (!found) {
                countries[countryCount] = driverCountry; // Use driverCountry
                countryPoints[countryCount] = points;
                countryCount++;
            }
        }

        // Find the best country
        String bestCountry = countries[0];
        int bestScore = countryPoints[0];
        for (int i = 1; i < countryCount; i++) {
            if (countryPoints[i] > bestScore) {
                bestScore = countryPoints[i];
                bestCountry = countries[i];
            }
        }
        return bestCountry;
    }
}