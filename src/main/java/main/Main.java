/**
 * Main program to run the rally
 */
package main;
public class Main {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getBoss();

        // Make drivers
        Driver seb = new Driver("Sébastien Ogier", "France");
        Driver ott = new Driver("Ott Tänak", "Estonia");
        Driver kalle = new Driver("Kalle Rovanperä", "Finland");
        Driver thierry = new Driver("Thierry Neuville", "Belgium");

        // Make cars
        GravelCar gravel = new GravelCar("Toyota", "Yaris WRC", 380, 10.5, 9.2);
        AsphaltCar asphalt = new AsphaltCar("Hyundai", "i20 Coupe WRC", 380, 9.5, 9.8);

        // Give cars to drivers
        seb.setCar(gravel);
        ott.setCar(gravel);
        kalle.setCar(asphalt);
        thierry.setCar(asphalt);

        // Add drivers to manager
        manager.addDriver(seb);
        manager.addDriver(ott);
        manager.addDriver(kalle);
        manager.addDriver(thierry);

        // Race 1: Finland
        RallyRaceResult finland = new RallyRaceResult("Rally Finland", "Jyväskylä");
        finland.saveResult(seb, 1);
        finland.saveResult(ott, 2);
        finland.saveResult(kalle, 3);
        finland.saveResult(thierry, 4);
        manager.addRace(finland);

        // Switch cars
        seb.setCar(asphalt);
        kalle.setCar(gravel);

        // Race 2: Monte Carlo
        RallyRaceResult monte = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        monte.saveResult(kalle, 1);
        monte.saveResult(thierry, 2);
        monte.saveResult(seb, 3);
        monte.saveResult(ott, 4);
        manager.addRace(monte);

        // Show standings
        manager.showDrivers();

        // Show best driver
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        Driver best = manager.getBestDriver();
        System.out.println(best.getDriverName() + " with " + best.getPoints() + " points");

        // Show stats
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.totalDrivers);
        System.out.println("Total Races: " + ChampionshipManager.totalRaces);
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.findAvgPoints(manager));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findBestCountry(manager));
        System.out.println("Total Championship Points: " + manager.addAllPoints());

        // Show race results
        System.out.println("\n===== RACE RESULTS =====");
        for (int i = 0; i < manager.raceCount; i++) {
            System.out.println(manager.races[i]);
        }

        // Show car scores
        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance : " + gravel.findScore());
        System.out.println("Asphalt Car Performance : " + asphalt.findScore());
    }
}