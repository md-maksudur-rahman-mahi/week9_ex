/**
 * This is a basic car class that other cars will use
 */
package main;
public abstract class RallyCar {
    String brand;
    String name;
    int power;

    /**
     * Make a new car
     */
    public RallyCar(String brand, String name, int power) {
        this.brand = brand;
        this.name = name;
        this.power = power;
    }

    // Getters and setters
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getPower() { return power; }
    public void setPower(int power) { this.power = power; }

    /**
     * Every car needs to figure out how good it is
     */
    public abstract double findScore();

    public String toString() {
        return brand + " " + name + " (" + power + " HP)";
    }
}