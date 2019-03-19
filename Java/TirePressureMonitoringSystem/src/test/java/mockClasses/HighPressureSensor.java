package mockClasses;

import tddmicroexercises.tirepressuremonitoringsystem.ISensor;

public class HighPressureSensor implements ISensor {
    public double popNextPressurePsiValue() {
        return 22;
    }
}
