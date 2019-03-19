package mockClasses;

import tddmicroexercises.tirepressuremonitoringsystem.ISensor;

public class NormalPressureSensor implements ISensor {
    public double popNextPressurePsiValue() {
        return 17;
    }
}
