package by.eis.testTask.entity;

import by.eis.testTask.entity.enums.InsuranceCases;
import by.eis.testTask.service.IContract;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ComprehensiveContract extends InsuranceContract implements IContract, Serializable {

    public ComprehensiveContract(Map<Enum, String> params) {

        super(params);
        for (InsuranceCases value : InsuranceCases.values()) {
            super.addInsuranceCase(value);
        }
        super.setType("comprehensive");
    }
}
