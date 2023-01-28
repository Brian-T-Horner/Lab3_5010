// Imports
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Tests for the NaiveTemperatureMonitor Class.
 */
public class NaiveTemperatureMonitorTest {

  /**
   * Tests for {@code public boolean tooMuchHeating()} method.
   */

  // Tests tooMuchHeating with no Thermostats.
  @Test
  public void testTooMuchHeatingNoTherms() {
    TemperatureMonitor test;
    test = new NaiveTemperatureMonitor();
    assertEquals(false, test.tooMuchHeating());

  }

  // Tests tooMuchHeating with only one thermostat.getSetTemperature > 23+273.15
  @Test
  public void testTooMuchHeatingOne() {
    TemperatureMonitor test;
    test = new NaiveTemperatureMonitor();
    Thermostat a;
    Thermostat b;
    Thermostat c;
    a = new SimpleThermostat("Thermostat a", 24);
    b = new SimpleThermostat("Thermostat b", 23);
    c = new SimpleThermostat("Thermostat c", 22);
    test.add(a);
    test.add(b);
    test.add(c);
    assertEquals(false, test.tooMuchHeating());
  }

  // Tests tooMuchHeating with multiple Thermostats over heating.
  @Test
  public void testTooMuchHeatingMultiple() {
    TemperatureMonitor test;
    test = new NaiveTemperatureMonitor();
    Thermostat a;
    Thermostat b;
    a = new SimpleThermostat("Thermostat a", 30);
    b = new SimpleThermostat("Thermostat b", 40);
    test.add(a);
    test.add(b);
    assertEquals(true, test.tooMuchHeating());
  }

}
