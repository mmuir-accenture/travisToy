package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.*;
import static org.junit.Assert.*;

public class TestAlarm {

    @Test
    public void WhenInstantiatingIsNotNull() {
        ISensor mockSensor = new Sensor();
        Alarm alarm = new Alarm(mockSensor);
        assertNotNull(alarm);
    }
}
