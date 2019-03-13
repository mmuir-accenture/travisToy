package tddmicroexercises.tirepressuremonitoringsystem;


import mockClasses.LowPressureSensor;
import org.junit.*;
import static org.junit.Assert.*;

public class TestAlarm {

    @Test
    public void WhenInstantiatingIsNotNull() {
        ISensor mockSensor = new Sensor();
        Alarm alarm = new Alarm(mockSensor);
        assertNotNull(alarm);
    }

    @Test
    public void WhenCheckingLowPressureAlarmSounds() {
        ISensor mockSensor = new LowPressureSensor();
        Alarm alarm = new Alarm(mockSensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
}
