
/**
 * Thermostat interface.
 */
public interface Thermostat {

  /**
   * A method to get a thermostats unique ID.
   *
   * @return A string with the unique ID.
   */
  String getID();

  /**
   * A method to get the temperature in degrees Kelvin that the thermostat is set to.
   *
   * @return A double representing the degrees of the thermostat in Kelvin.
   */
  double getSetTemperature();

  /**
   * A method that increases the set temperature for the thermostat. (Implementation dependent
   * amount).
   */
  void increaseSetTemperature();

  /**
   * A method that decreases the set temperature for the thermostat. (Implementation dependent
   * amount).
   */
  void decreaseSetTemperature();

}


