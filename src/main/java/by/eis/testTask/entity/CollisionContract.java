package by.eis.testTask.entity;

import by.eis.testTask.entity.enums.InsuranceCases;
import by.eis.testTask.service.IContract;

import java.io.Serializable;
import java.util.Map;

public class CollisionContract extends InsuranceContract implements IContract, Serializable {

    public CollisionContract(Map<Enum, String> params) {
        super(params);
        super.addInsuranceCase(InsuranceCases.ACCIDENT);
        super.setType("collision");
    }

}
