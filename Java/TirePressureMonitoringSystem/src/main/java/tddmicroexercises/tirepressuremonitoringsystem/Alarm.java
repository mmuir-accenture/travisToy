package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private final double LOW_PRESSURE_THRESHOLD = 17;
    private final double HIGH_PRESSURE_THRESHOLD = 21;
    ISensor sensor;

    private boolean alarmOn = false;

    public Alarm(){
        this.sensor = new Sensor();
    }

    public Alarm(ISensor injectedSensor){
        this.sensor = injectedSensor;
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }

}
