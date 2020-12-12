package by.eis.testTask;

import by.eis.testTask.entity.Appartement;
import by.eis.testTask.entity.Bycicle;
import by.eis.testTask.entity.Car;
import by.eis.testTask.entity.enums.InsuranceObjects;
import by.eis.testTask.service.Insurable;

import java.util.Map;

public class InsuranceObjectFabric {
    public static Insurable getInsuranceObject(InsuranceObjects type, Map<Enum, String> params) {
        switch (type) {
            case APPARTEMENT: return new Appartement(params);
            case CAR: return new Car(params);
            case BYCICLE: return new Bycicle(params);
        }
        return null;
    }
}
