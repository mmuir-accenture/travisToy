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
    Alarm alarm;

    @Before
    public void setUp() throws Exception {
        double psi = random.nextDouble()*22;
        mockSensor = generateISensor(psi);
        alarm = new Alarm();
        alarm.setSensor(mockSensor);
    }




    @Test
    public void WhenInstantiatingIsNotNull() {

        assertNotNull(alarm);
    }

    @Test
    public void WhenCheckingLowPressureAlarmSounds() {
        ISensor mockSensor = generateISensor(5);
        alarm.setSensor(mockSensor);

        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void WhenCheckingHighPressureAlarmSounds() {
        ISensor mockSensor = generateISensor(22);
        alarm.setSensor(mockSensor);

        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void WhenCheckingNormalPressureNoAlarm() {
        ISensor mockSensor = generateISensor(17);
        alarm.setSensor(mockSensor);

        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void WhenCheckingRandomPressureAlarmRespondsCorrectly(){
        String sensorType = mockSensor.getClass().toString();

        alarm.setSensor(mockSensor);

        alarm.check();

        makeAssertion(sensorType, alarm.isAlarmOn());

    }

    private void makeAssertion(String sensorType, boolean alarmCheck) {
        switch(sensorType.toCharArray()[0]){
            case 'N':
                assertFalse(alarmCheck);
                break;
            case 'L':
            case 'H':
                assertTrue(alarmCheck);

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