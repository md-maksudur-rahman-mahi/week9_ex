/**
 * Manages the whole rally
 */
package main;
public class ChampionshipManager {
    private static ChampionshipManager boss = null;
    static int totalDrivers = 0;
    static int totalRaces = 0;
    Driver[] drivers = new Driver[100]; // Big array for drivers
    RaceResult[] races = new RaceResult[100];   // Big array for races
    int driverCount = 0;
    int raceCount = 0;

    /**
     * Only one boss can exist
     */
    private ChampionshipManager() {}

    /**
     * Get the boss
     */
    public static ChampionshipManager getBoss() {
        if (boss == null) {
            boss = new ChampionshipManager();
        }
        return boss;
    }

    /**
     * Add a driver
     */
    public void addDriver(Driver driver) {
        drivers[driverCount] = driver;
        driverCount++;
        totalDrivers++;
    }

    /**
     * Add a race
     */
    public void addRace(RaceResult race) {
        races[raceCount] = race;
        raceCount++;
        totalRaces++;
    }

    /**
     * Show all drivers sorted by points
     */
    public void showDrivers() {
        System.out.println("Championship Standings:");
        // Simple bubble sort
        for (int i = 0; i < driverCount - 1; i++) {
            for (int j = 0; j < driverCount - i - 1; j++) {
                if (drivers[j].getPoints() < drivers[j + 1].getPoints()) {
                    Driver temp = drivers[j];
                    drivers[j] = drivers[j + 1];
                    drivers[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < driverCount; i++) {
            System.out.println((i + 1) + ". " + drivers[i]);
        }
    }

    /**
     * Get the best driver
     */
    public Driver getBestDriver() {
        Driver best = drivers[0];
        for (int i = 1; i < driverCount; i++) {
            if (drivers[i].getPoints() > best.getPoints()) {
                best = drivers[i];
            }
        }
        return best;
    }

    /**
     * Add up all points
     */
    public int addAllPoints() {
        int sum = 0;
        for (int i = 0; i < driverCount; i++) {
            sum = sum + drivers[i].getPoints();
        }
        return sum;
    }
}