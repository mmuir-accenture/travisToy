package mockClasses;

import tddmicroexercises.tirepressuremonitoringsystem.ISensor;

public class LowPressureSensor implements ISensor {
    public double popNextPressurePsiValue() {
        return 5;
    }
}
