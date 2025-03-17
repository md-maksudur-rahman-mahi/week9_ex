package main;

/**
 * A car for asphalt roads
 */
public class AsphaltCar extends RallyCar {
    double air;
    double brakes;

    /**
     * Make an asphalt car
     */
    public AsphaltCar(String brand, String name, int power, double air, double brakes) {
        super(brand, name, power);
        this.air = air;
        this.brakes = brakes;
    }

    public double getAir() { return air; }
    public void setAir(double air) { this.air = air; }
    public double getBrakes() { return brakes; }
    public void setBrakes(double brakes) { this.brakes = brakes; }

    /**
     * How good is this car on asphalt?
     */
    public double findScore() {
        return (power * 0.7) + (air * 20) + (brakes * 15);
    }
}