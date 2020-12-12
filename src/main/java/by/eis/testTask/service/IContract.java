package by.eis.testTask.service;

import by.eis.testTask.entity.enums.InsuranceCases;

import java.util.Set;

public interface IContract {
    public Set<InsuranceCases> getInsuranceCasesList();
}
