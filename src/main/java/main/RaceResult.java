/**
 * What every race should do
 */
package main;
public interface RaceResult {
    String getRaceName();
    String getPlace();
    void saveResult(Driver driver, int position);
    int givePoints(int position);
}