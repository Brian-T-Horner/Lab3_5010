// Imports
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class SimpleThermostatTest {

  /**
   * Tests the constructor with valid inputs.
   */
  @Test
  public void testConstructor(){
    Thermostat constructTest;
    constructTest = new SimpleThermostat("Construct test.", 15);
  }

  /**
   * Tests the constructor with a blank ID that should raise IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructBlankID(){
    Thermostat blankID;
    blankID = new SimpleThermostat("", 20);
  }

  /**
   * Tests the constructor wth a Celsius temperature greater than 50.
   *    Should raise an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructGreater50(){
    Thermostat greaterThan50;
    greaterThan50 = new SimpleThermostat("Greater than 50 degrees", 100);
  }

  /**
   * Tests the getID method with expected inputs.
   */
  @Test
  public void testGetID(){
    Thermostat idTest;
    idTest = new SimpleThermostat("Test ID", 25);
    assertEquals("Test ID", idTest.getID());
  }

  /**
   * Tests the getSetTemperature method with expected inputs.
   */
  @Test
  public void testGetSetTemperature(){
    Thermostat testGetSet;
    testGetSet = new SimpleThermostat("GetSetThermostat", 22.3);
    assertEquals(295.45, testGetSet.getSetTemperature(), 0.005);
  }


  /**
   * Tests the increaseSetTemperature with expected inputs.
   */
  @Test
  public void testIncreaseSetTemperature(){
    Thermostat testIncrease;
    testIncrease = new SimpleThermostat("TestIncrease", 10.2);
    assertEquals(283.36, testIncrease.getSetTemperature(), 0.005);
  }


  /**
   * Tests the decreaseSetTemperature method with expected inputs.
   */
  @Test
  public void testDecreaseSetTemperature(){
    Thermostat testDecrease;
    testDecrease = new SimpleThermostat("TestDecrease", -0.15);
    assertEquals(272.99, testDecrease.getSetTemperature(), 0.005);
  }

}
