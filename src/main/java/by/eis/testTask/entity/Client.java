package by.eis.testTask.entity;

import by.eis.testTask.entity.enums.ClientParams;

import java.io.Serializable;
import java.util.Map;

public class Client implements Serializable {
    private String name;
    private String surname;
    private Passport passport;

    public Client() {
    }

    public Client(String name, String surname, Passport passport) {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
    }

    public Client(String name, String surname,
                  String personalIDNumber, String series, String number) {
        this.name = name;
        this.surname = surname;
        this.passport = new Passport(personalIDNumber, series, number);
    }

    public Client(Map<Enum,String> params) {
        this.name = params.get(ClientParams.NAME);
        this.surname = params.get(ClientParams.SURNAME);
        this.passport = new Passport(params.get(ClientParams.PASSPORT_PERSONAL_ID),
                                        params.get(ClientParams.PASSPORT_SERIES),
                                        params.get(ClientParams.PASSPORT_NUMBER));
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passport=" + passport +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

}
