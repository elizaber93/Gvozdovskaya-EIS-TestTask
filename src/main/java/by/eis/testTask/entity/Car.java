package by.eis.testTask.entity;

import by.eis.testTask.entity.enums.AppartementParams;
import by.eis.testTask.entity.enums.CarParams;
import by.eis.testTask.service.Insurable;

import java.io.Serializable;
import java.util.Map;

public class Car  extends InsuranceObject implements Insurable, Serializable {
    private final String type = "car";
    private String number;
    private String brand;
    private String model;
    private String registrationNumber;
    private String bodyNumber;

    public Car() {
    }

    public Car(int price, String number, String brand, String model) {
        super(price, false);
        this.number = number;
        this.brand = brand;
        this.model = model;
    }

    public Car(Map<Enum,String> params) {
        super(Integer.parseInt(params.get(CarParams.PRICE)), false);
        this.bodyNumber = params.get(CarParams.BODY_NUMBER);
        this.brand = params.get(CarParams.BRAND);
        this.model = params.get(CarParams.MODEL);
        this.number = params.get(CarParams.CAR_NUMBER);
        this.registrationNumber = params.get(CarParams.REGISTRATION_NUMBER);
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", bodyNumber='" + bodyNumber + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
