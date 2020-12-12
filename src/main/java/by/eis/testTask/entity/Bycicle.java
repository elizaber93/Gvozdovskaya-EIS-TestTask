package by.eis.testTask.entity;

import by.eis.testTask.entity.enums.BycicleParams;
import by.eis.testTask.service.Insurable;

import java.io.Serializable;
import java.util.Map;

public class Bycicle  extends InsuranceObject implements Insurable, Serializable {
    private final String type = "bycicle";
    private String bodyNumber;
    private String brand;
    private String model;

    public Bycicle() {
    }

    public Bycicle(int price, String number, String brand, String model) {
        super(price, false);
        this.bodyNumber = number;
        this.brand = brand;
        this.model = model;
    }

    public Bycicle(Map<Enum,String> params) {
        super(Integer.parseInt(params.get(BycicleParams.PRICE)), false);
        this.bodyNumber = params.get(BycicleParams.BODY_NUMBER);
        this.brand = params.get(BycicleParams.BRAND);
        this.model = params.get(BycicleParams.MODEL);
    }

    @Override
    public String toString() {
        return "Bycicle{" +
                "bodyNumber='" + bodyNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public String getBodyNumber() {
        return bodyNumber;
    }

    public void setBodyNumber(String bodyNumber) {
        this.bodyNumber = bodyNumber;
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
