// Imports

import java.text.DecimalFormat;

public class SimpleThermostat implements Thermostat{

  private static final DecimalFormat decimalRounding = new DecimalFormat("0.00");
  private double degreesC;
  private String StringID;

  /**
   * Creates a SimpleThermostat object with the provided ID and degrees in Celsius.
   * @param ID A String argument passed as the unique ID for the Simple Thermostat.
   * @param degreesC An integer argument of the degrees in Celsius for the SimpleThermostat.
   * @throws IllegalArgumentException - When either the degrees given is greater than 50 or
   *      the unique ID passed is blank.
   */
  public SimpleThermostat(String ID, double degreesC) throws IllegalArgumentException{
    if(ID=="" | ID ==" "){
      throw new IllegalArgumentException("Invalid ID. ID can not be blank.");
    }

    if(degreesC > 50){
      throw new IllegalArgumentException("Invalid degrees in Celsius. Must be less than 50 degrees.");
    }

    StringID = ID;
    this.degreesC = degreesC;
  }


  /**
   * A method to retrieve the SimpleThermostats unique ID.
   * @return A String that is the SimpleThermostats unique ID.
   */
  @Override
  public String getID() { return StringID;}

  /**
   * Returns the SimpleThermostat Celsius temperature converted to Kelvin and as a double.
   * @return A double representing the Kelvin conversion of the SimpleThermostats degrees in Celsius.
   */
  @Override
  public double getSetTemperature() {return Math.floor(degreesC+273.15);}

  /**
   * Increases the set temperature of the SimpleThermostat by 0.1 degrees Celsius.
   */
  @Override
  public void increaseSetTemperature() {this.degreesC= this.degreesC +0.01;}

  /**
   * Decreases the set temperature of the SimpleThermostat by 0.1 degrees Celsius.
   */
  @Override
  public void decreaseSetTemperature() {this.degreesC= this.degreesC -0.01;}


  /**
   * Checks if {@code this} SimpleThermostat is equal to provided object.
   * @param o An object that is an instance of Thermostat. If not return false.
   * @return Returns true if {@code this} is the same as Object o. False if not.
   */
  @Override
  public boolean equals(Object o){
    if(this == o){return true;}

    if(!(o instanceof Thermostat)){return false;}

    Thermostat that = (Thermostat) o;

    return (this.getID() == that.getID() &&
        (this.getSetTemperature()-that.getSetTemperature()-273.15) < 0.005);

  }

  /**
   * Creates A hashCode function from the SimpleThermostats degree's in kelvin
   * @return A hashcode value for the double from getSetTemperature.
   */
  @Override
  public int hashCode(){
      return Double.hashCode(this.getSetTemperature());
  }
}
