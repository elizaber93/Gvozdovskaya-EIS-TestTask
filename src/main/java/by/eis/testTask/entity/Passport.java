package by.eis.testTask.entity;

import java.io.Serializable;

public class Passport implements Serializable {
    private String personalIDNumber;
    private String series;
    private String number;

    public Passport() {
    }

    public Passport(String personalIDNumber, String series, String number) {
        this.personalIDNumber = personalIDNumber;
        this.series = series;
        this.number = number;
    }

    public String getPersonalIDNumber() {
        return personalIDNumber;
    }

    public void setPersonalIDNumber(String personalIDNumber) {
        this.personalIDNumber = personalIDNumber;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "personalIDNumber='" + personalIDNumber + '\'' +
                ", series='" + series + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
