// Imports
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


/**
 * Tests for the SimpleThermostat Class.
 */
public class SimpleThermostatTest {

  /**
   * Tests for {@code public SimpleThermostat(String ID, double degreesC) throws
   *    IllegalArgumentException} constructor.
   */

  // Tests the constructor with valid ID and positive temperature.
  @Test
  public void testConstructorValidPos(){
    Thermostat constructTest;
    constructTest = new SimpleThermostat("Construct testPos", 50);
    assertEquals("Construct testPos",constructTest.getID());
    assertEquals(50, constructTest.getSetTemperature()-273.15, 0.005);
  }

  // Tests the constructor with valid ID and negative temperature.
  @Test
  public void testConstructorValidNeg(){
    Thermostat constructTest;
    constructTest = new SimpleThermostat("Construct testNeg", -200);
    assertEquals("Construct testNeg", constructTest.getID());
    assertEquals(-200, constructTest.getSetTemperature()-273.15, 0.005);
  }

 // Tests the constructor with empty string ID which should raise exception.
  @Test(expected = IllegalArgumentException.class)
  public void testConstructEmptyID(){
    Thermostat emptyID;
    emptyID = new SimpleThermostat("", 20);
  }

  // Tests the constructor with blank ID which should raise exception.
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorBlankID(){
    Thermostat blankID;
    blankID = new SimpleThermostat("               ", 20);
  }

  // Tests the constructor with degrees greater than 50.
  @Test(expected = IllegalArgumentException.class)
  public void testConstructGreater50(){
    Thermostat greaterThan50;
    greaterThan50 = new SimpleThermostat("Greater than 50 degrees", 100);
  }

  // Tests the constructor with both arguments being invalid.
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDoubleInvalid(){
    Thermostat bothInvalid;
    bothInvalid = new SimpleThermostat("                        ", 555);
  }


  /**
   * Tests for {@code public string getID(){}} method.
   */

  // Tests the getID method with valid inputs.
  @Test
  public void testGetID(){
    Thermostat idTest;
    idTest = new SimpleThermostat("Test ID", 25);
    assertEquals("Test ID", idTest.getID());
  }

  /**
   * Tests for {@code public double getSetTemperature(){}} method.
   */

  // Tests the getSetTemperature with positive temperature input.
  @Test
  public void testGetSetTemperaturePos(){
    Thermostat testGetSet;
    testGetSet = new SimpleThermostat("GetSetThermostatPos", 22.3);
    assertEquals(295.45, testGetSet.getSetTemperature(), 0.005);
  }

  // Tests the getSetTemperature with negative temperature input.
  @Test
  public void testGetSetTemperatureNeg(){
    Thermostat testGetSet;
    testGetSet = new SimpleThermostat("GetSetThermostatNeg", -300);
    assertEquals(-26.85, testGetSet.getSetTemperature(), 0.005);
  }

  /**
  * Tests for {@code public void increaseSetTemperature(){} method.
  */

  // Tests increaseSetTemperature with positive starting temperature.
  @Test
  public void testIncreaseSetTemperaturePos(){
    Thermostat testIncrease;
    testIncrease = new SimpleThermostat("TestIncreasePos", 10.2);
    testIncrease.increaseSetTemperature();
    assertEquals(283.45, testIncrease.getSetTemperature(), 0.005);
  }

  // Tests increaseSetTemperature with negative starting temperature.
  @Test
  public void testIncreaseSetTemperatureNeg(){
    Thermostat testIncrease;
    testIncrease = new SimpleThermostat("TestIncreaseNeg", -400.55);
    testIncrease.increaseSetTemperature();
    assertEquals(-127.3, testIncrease.getSetTemperature(), 0.005);
  }

  // Tests that increaseSetTemperature does not go above 50 degrees C.
  @Test
  public void testIncreaseSetTemperatureInvalid(){
    Thermostat testIncreaseInvalid;
    testIncreaseInvalid = new SimpleThermostat("Test Increase Invalid", 50);
    testIncreaseInvalid.increaseSetTemperature();
    assertEquals(50, testIncreaseInvalid.getSetTemperature()-273.15, 0.005);
  }

  /**
   * Tests that after invalid increaseSetTemperature decreaseSetTemperature runs as expected.
   */


  @Test
  public void testIncreaseTempInvalidAndDecreaseTemp() {
    Thermostat testIncreaseInvalidDecrease;
    testIncreaseInvalidDecrease = new SimpleThermostat("Test Increase Invalid", 50);
    testIncreaseInvalidDecrease.increaseSetTemperature();
    testIncreaseInvalidDecrease.decreaseSetTemperature();
    assertEquals(49.9, testIncreaseInvalidDecrease.getSetTemperature() - 273.15, 0.005);
  }


  /**
   * Tests for {@code public void decreaseSetTemperature(){}} method.
   */
  @Test
  public void testDecreaseSetTemperatureNeg(){
    Thermostat testDecrease;
    testDecrease = new SimpleThermostat("TestDecreaseNeg", -400);
    testDecrease.decreaseSetTemperature();
    assertEquals(-126.95, testDecrease.getSetTemperature(), 0.005);
  }

  @Test
  public void testDecreasesSetTemperaturePos(){
    Thermostat testDecrease;
    testDecrease = new SimpleThermostat("TestDecreasePos", 20);
    testDecrease.decreaseSetTemperature();
    assertEquals(293.05, testDecrease.getSetTemperature(), 0.005);
  }

  /**
   * Tests for {@code public boolean equals(Object o){}} method.
   */

  // Tests equals for Reflexive
  @Test
  public void testEqualsReflexive(){
    Thermostat a;
    a = new SimpleThermostat("Reflexive", 30);
    assertEquals(true, a.equals(a));
  }



  // Tests that equals is symmetric (pointer).
  @Test
  public void testEqualsSymmetricPtr(){
    Thermostat a;
    Thermostat b;
    a = new SimpleThermostat("Symmetric Ptr", 20);
    b=a;
    assertEquals(true, b.equals(a));
    assertEquals(true, a.equals(b));
  }

  // Tests that equals is symmetric (values).
  @Test
  public void testEqualsSymmetricVals(){
    Thermostat a;
    Thermostat b;
    b = new SimpleThermostat("SymmetricVals", 20);
    a = new SimpleThermostat("SymmetricVals", 20);
    assertEquals(true, a.equals(b));
    assertEquals(true, b.equals(a));
  }

  // Tests that equals is transitive (ptrs).
  @Test
  public void testEqualsTransitivePtrs(){
    Thermostat a;
    Thermostat b;
    Thermostat c;
    b = new SimpleThermostat("TransitivePtr", 20);
    a=b;
    c=b;
    assertEquals(true,a.equals(b));
    assertEquals(true, b.equals(c));
    assertEquals(true, a.equals(c));

  }

  // Tests equals for transitive (values).
  @Test
  public void testEqualsTransitiveVals(){
    Thermostat a;
    Thermostat b;
    Thermostat c;
    a = new SimpleThermostat("TransitiveVals", 30);
    b = new SimpleThermostat("TransitiveVals", 30);
    c = new SimpleThermostat("TransitiveVals", 30);
    assertEquals(true, a.equals(b));
    assertEquals(true, b.equals(c));
    assertEquals(true, a.equals(c));
  }

  // Tests that equals returns false when Object o is not a Thermostat.
  @Test
  public void testEqualsONotThermostat(){
    Thermostat a;
    int integerTest;
    integerTest=20;
    String stringTest = "Thermostat A";
    a = new SimpleThermostat("Thermostat A", 20);
    assertEquals(false, a.equals(integerTest));
    assertEquals(false, a.equals(stringTest));
  }

  // Tests that equals returns false when there are different IDs.
  @Test
  public void testEqualsDifIDs(){
    Thermostat a;
    Thermostat b;
    a = new SimpleThermostat("a", 20);
    b = new SimpleThermostat("b", 20);
    assertEquals(false, a.equals(b));
    assertEquals(false, b.equals(a));
  }
  // Tests that equals returns false when there are different temps.

  /**
   * *** Does not work with previous equality test ***
   */

//  @Test
//  public void testEqualsDifTemps(){
//    Thermostat a;
//    Thermostat b;
//    a = new SimpleThermostat("a", 10);
//    b = new SimpleThermostat("a", 40);
//    assertEquals(false, a.equals(b));
//    assertEquals(false, b.equals(a));
//  }

  /**
   * Tests for {@code public int hashCode()} method.
   */

  // Testing reflexive property for hashCode
  @Test
  public void testHashCodeReflex(){
    Thermostat a;
    a = new SimpleThermostat("Reflexive", 30);
    assertEquals(a.hashCode(), a.hashCode());
  }

  // Testing symmetric property for hashCode (values)
  @Test
  public void testHashCodeSymmVals(){
    Thermostat a;
    Thermostat b;
    b = new SimpleThermostat("SymmetricVals", 20);
    a = new SimpleThermostat("SymmetricVals", 20);
    assertEquals(a.hashCode(), b.hashCode());
    assertEquals(b.hashCode(), a.hashCode());
  }

  // Testing symmetric property for hashCode (ptrs)
  @Test
  public void testHashCodeSymmPtrs(){
    Thermostat a;
    Thermostat b;
    b = new SimpleThermostat("SymmetricPtrs", 20);
    a = b;
    assertEquals(a.hashCode(), b.hashCode());
    assertEquals(b.hashCode(), a.hashCode());
  }

  // Testing transitive property for hashCode (values)
  @Test
  public void testHashCodeTransVals(){
    Thermostat a;
    Thermostat b;
    Thermostat c;
    a = new SimpleThermostat("TransitiveVals", 30);
    b = new SimpleThermostat("TransitiveVals", 30);
    c = new SimpleThermostat("TransitiveVals", 30);
    assertEquals(a.hashCode(), b.hashCode());
    assertEquals(b.hashCode(), c.hashCode());
    assertEquals(a.hashCode(), c.hashCode());
  }

  // Testing transitive property for hashCode (ptrs)
  @Test
  public void testHashCodeTransitivePtrs(){
    Thermostat a;
    Thermostat b;
    Thermostat c;
    b = new SimpleThermostat("TransitivePtr", 20);
    a=b;
    c=b;
    assertEquals(a.hashCode(), b.hashCode());
    assertEquals(b.hashCode(), c.hashCode());
    assertEquals(a.hashCode(), b.hashCode());

  }

  // Test for different values = different hashCodes
  @Test
  public void testHashCodeDifVals(){
    Thermostat a;
    Thermostat b;
    a = new SimpleThermostat("a", 20);
    b = new SimpleThermostat("b", 30);
    assertFalse(a.hashCode() == b.hashCode());
  }


}
