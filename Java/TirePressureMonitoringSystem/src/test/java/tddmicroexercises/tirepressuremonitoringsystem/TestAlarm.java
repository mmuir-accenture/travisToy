package tddmicroexercises.tirepressuremonitoringsystem;


import mockClasses.HighPressureSensor;
import mockClasses.LowPressureSensor;
import mockClasses.NormalPressureSensor;
import org.junit.*;

import java.util.Random;

import static org.junit.Assert.*;

public class TestAlarm {

    private final double LOW_PRESSURE_THRESHOLD = 17;
    private final double HIGH_PRESSURE_THRESHOLD = 21;
    private Alarm alarm;





    @Test
    public void WhenInstantiatingIsNotNull() {
        alarm = new Alarm();
        assertNotNull(alarm);
    }

    @Test
    public void WhenCheckingLowPressureAlarmSounds() {
        ISensor mockSensor = generateISensor(5);
        alarm = new Alarm(mockSensor);

        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void WhenCheckingHighPressureAlarmSounds() {
        ISensor mockSensor = generateISensor(22);
        alarm = new Alarm(mockSensor);

        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void WhenCheckingNormalPressureNoAlarm() {
        ISensor mockSensor = generateISensor(17);
        alarm = new Alarm(mockSensor);

        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void WhenCheckingRandomPressureAlarmRespondsCorrectly(){
        Random random = new Random();
        double psi = random.nextDouble()*22;
        ISensor mockSensor = generateISensor(psi);
        alarm = new Alarm(mockSensor);
        String sensorType = mockSensor.getClass().toString();

        alarm = new Alarm(mockSensor);

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
        if(psi < LOW_PRESSURE_THRESHOLD){
            return new LowPressureSensor();
        } else if (psi > HIGH_PRESSURE_THRESHOLD){
            return new HighPressureSensor();
        }
        return new NormalPressureSensor();
    }
}