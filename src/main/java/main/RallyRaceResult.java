/**
 * A rally race
 */
package main;
public class RallyRaceResult implements RaceResult {
    String raceName;
    String place;
    Driver[] drivers = new Driver[10]; // Max 10 drivers
    int[] positions = new int[10];
    int numDrivers = 0;

    /**
     * Make a new race
     */
    public RallyRaceResult(String raceName, String place) {
        this.raceName = raceName;
        this.place = place;
    }

    public String getRaceName() { return raceName; }
    public String getPlace() { return place; }

    /**
     * Add a driver and their position
     */
    public void saveResult(Driver driver, int position) {
        drivers[numDrivers] = driver;
        positions[numDrivers] = position;
        driver.addPoints(givePoints(position));
        numDrivers++;
    }

    /**
     * Points basedtalk based on position
     */
    public int givePoints(int position) {
        if (position == 1) return 25;
        if (position == 2) return 18;
        if (position == 3) return 15;
        if (position == 4) return 12;
        if (position == 5) return 10;
        if (position == 6) return 8;
        if (position == 7) return 6;
        if (position == 8) return 4;
        if (position == 9) return 2;
        if (position == 10) return 1;
        return 0;
    }

    public String toString() {
        String result = "Race: " + raceName + " (" + place + ")\n";
        for (int i = 0; i < numDrivers; i++) {
            result = result + "Position " + positions[i] + ": " +
                     drivers[i].getDriverName() + " - " + givePoints(positions[i]) + " points\n";
        }
        return result;
    }
}