package tddmicroexercises.tirepressuremonitoringsystem;


import mockClasses.HighPressureSensor;
import mockClasses.LowPressureSensor;
import mockClasses.NormalPressureSensor;
import org.junit.*;

import java.util.Random;

import static org.junit.Assert.*;

public class TestAlarm {

    Random random = new Random();
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;
    ISensor mockSensor;

    @Before
    public void setUp() throws Exception {
        double psi = random.nextDouble()*22;
        mockSensor = generateISensor(psi);
    }




    @Test
    public void WhenInstantiatingIsNotNull() {
        ISensor mockSensor = new Sensor();
        Alarm alarm = new Alarm(mockSensor);

        assertNotNull(alarm);
    }

    @Test
    public void WhenCheckingLowPressureAlarmSounds() {
        ISensor mockSensor = generateISensor(5);
        Alarm alarm = new Alarm(mockSensor);

        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void WhenCheckingHighPressureAlarmSounds() {
        ISensor mockSensor = generateISensor(22);
        Alarm alarm = new Alarm(mockSensor);

        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void WhenCheckingNormalPressureNoAlarm() {
        ISensor mockSensor = generateISensor(17);
        Alarm alarm = new Alarm(mockSensor);

        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void WhenCheckingRandomPressureAlarmRespondsCorrectly(){
        String sensorType = mockSensor.getClass().toString();

        Alarm alarm = new Alarm(mockSensor);

        alarm.check();

        switch(sensorType.toCharArray()[0]){
            case 'N':
                assertFalse(alarm.isAlarmOn());
                break;
            case 'L':
            case 'H':
                assertTrue(alarm.isAlarmOn());

        }

    }

    private ISensor generateISensor(double psi){
        if(psi < LowPressureThreshold){
            return new LowPressureSensor();
        } else if (psi > HighPressureThreshold){
            return new HighPressureSensor();
        }
        return new NormalPressureSensor();
    }
}
