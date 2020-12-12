package by.eis.testTask;

import by.eis.testTask.entity.CollisionContract;
import by.eis.testTask.entity.ComprehensiveContract;
import by.eis.testTask.entity.enums.ContractParams;
import by.eis.testTask.entity.enums.InsuranceObjects;
import by.eis.testTask.entity.enums.InsuranceTypes;
import by.eis.testTask.service.IContract;

import java.util.Map;

public class ContractFabric {
    public static IContract getContract(Map<Enum, String> params) {
        switch (InsuranceTypes.valueOf(params.get(ContractParams.INSURANCE_TYPE).toUpperCase())) {
            case COLLISION:
                return new CollisionContract(params);
            case COMPREHENSIVE:
                return new ComprehensiveContract(params);
        }
        return null;
    }
}
