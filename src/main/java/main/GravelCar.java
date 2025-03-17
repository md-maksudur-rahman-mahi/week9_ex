/**
 * A car for gravel roads
 */
package main;
public class GravelCar extends RallyCar {
    double shock;
    double grip;

    /**
     * Make a gravel car
     */
    public GravelCar(String brand, String name, int power, double shock, double grip) {
        super(brand, name, power);
        this.shock = shock;
        this.grip = grip;
    }

    public double getShock() { return shock; }
    public void setShock(double shock) { this.shock = shock; }
    public double getGrip() { return grip; }
    public void setGrip(double grip) { this.grip = grip; }

    /**
     * How good is this car on gravel?
     */
    public double findScore() {
        return (power * 0.5) + (shock * 25) + (grip * 15);
    }
}