package by.eis.testTask.entity;

import by.eis.testTask.entity.enums.AppartementParams;
import by.eis.testTask.service.Insurable;

import java.io.Serializable;
import java.util.Map;

public class Appartement extends InsuranceObject implements Insurable, Serializable {
    private final String type = "appartement";
    private double square;
    private String address;
    private int floor;

    public Appartement() {
    }

    public Appartement(double square, String address, int floor, int price) {
        super(price, true);
        this.square = square;
        this.address = address;
        this.floor = floor;
    }

    public Appartement(Map<Enum,String> params) {
        super(Integer.parseInt(params.get(AppartementParams.PRICE)), true);
            this.square = Double.parseDouble(params.get(AppartementParams.SQUARE));
            this.address = params.get(AppartementParams.ADDRESS);
            this.floor = Integer.parseInt(params.get(AppartementParams.FLOOR));

    }

    @Override
    public String toString() {
        return "Appartement{" +
                "type='" + type + '\'' +
                ", square=" + square +
                ", address='" + address + '\'' +
                ", floor=" + floor +
                '}';
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
