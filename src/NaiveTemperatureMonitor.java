import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a temperature monitor. It tracks several thermostats, and specifically
 * monitors how many of them have been set to too hot.
 */

public class NaiveTemperatureMonitor implements TemperatureMonitor {
  private final List<Thermostat> thermostatList;

  /**
   * Constructs a new NaiveTemperature Monitor and initializes its ArrayList.
   */
  public NaiveTemperatureMonitor() {
    this.thermostatList = new ArrayList<Thermostat>();
  }

  /**
   * Adds a Thermostat to the NaiveTemperatureMonitor ArrayList.
   * @param t A Thermostat to add to the NaiveTemperatureMonitor object.
   */
  @Override
  public void add(Thermostat t) {
    thermostatList.add(t);
  }

  /**
   * Removes a Thermostat from the NaiveTemperatureMonitor ArrayList.
   * @param t A Thermostat to remove from the NaiveTemperatureMonitor object.
   */
  @Override
  public void remove(Thermostat t) {
    thermostatList.remove(t);
  }

  /**
   * Gets the number of thermostats in NaiveTemperatureMonitor ArrayList.
   * @return an int of the number of Thermostats in NaiveTemperatureMonitor.
   */
  @Override
  public int getNumberOfThermostats() {
    return thermostatList.size();
  }

  /**
   * Checks if more than one thermostat is overheating in NaiveTemperatureMonitor Arraylist.
   * @return True if more than one thermostat is overheating. False otherwise.
   */
  @Override
  public boolean tooMuchHeating() {
    int count = 0;
    for (Thermostat t: thermostatList) {
      // Convert to BigDecimal to avoid arithmetic errors.
      int compare =
          BigDecimal.valueOf(t.getSetTemperature()).compareTo(
              BigDecimal.valueOf(23 + 273.15));
      if (compare == 1) {
        count += 1;
      }

    }
    return count > 1;
  }
}
