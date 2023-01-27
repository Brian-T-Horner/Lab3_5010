// Imports

/**
 * TemperatureMonitor interface.
 */
public interface TemperatureMonitor {

  /**
   * Adds a Thermostat to the TemperatureMonitor object.
   * @param t A Thermostat to add to the TemperatureMonitor object.
   */
  void add(Thermostat t);

  /**
   * Removes a Thermostat from the TemperatureMonitor object.
   * @param t A Thermostat to remove from the TemperatureMonitor object.
   */
  void remove(Thermostat t);

  /**
   * Returns the number of Thermostats in the TemperatureMonitor object.
   * @return An integer representing the number of Thermostats in the TemperatureMonitor object.
   */
  int getNumberOfThermostats();

  /**
   * Checks if two or more of the Thermostats have a temperature greater than 296.15 Kelvin.
   * @return True if more than one of the Thermostats are greater than 296.15 Kelvin. False if not.
   */
  boolean tooMuchHeating();



}
