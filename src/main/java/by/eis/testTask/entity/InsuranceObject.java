package by.eis.testTask.entity;

import by.eis.testTask.entity.enums.AppartementParams;
import by.eis.testTask.service.Insurable;

import java.io.Serializable;
import java.util.Map;

public class InsuranceObject implements Insurable, Serializable {
    private int price;
    private boolean isRealty;

    public InsuranceObject() {
    }

    public InsuranceObject(int price, boolean isRealty) {
        this.price = price;
        this.isRealty = isRealty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
