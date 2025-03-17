/**
 * A racer who drives a car
 */
package main;
public class Driver {
    String driverName;
    String country;
    int points;
    RallyCar car;

    /**
     * Make a racer with just name and country
     */
    public Driver(String driverName, String country) {
        this.driverName = driverName;
        this.country = country;
        this.points = 0;
    }

    /**
     * Make a racer with a car too
     */
    public Driver(String driverName, String country, RallyCar car) {
        this.driverName = driverName;
        this.country = country;
        this.points = 0;
        this.car = car;
    }

    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public int getPoints() { return points; }
    public void addPoints(int points) { this.points = this.points + points; }
    public RallyCar getCar() { return car; }
    public void setCar(RallyCar car) { this.car = car; }

    public String toString() {
        return driverName + " (" + country + "): " + points + " points";
    }
}