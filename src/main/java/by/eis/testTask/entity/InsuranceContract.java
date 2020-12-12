package by.eis.testTask.entity;

import by.eis.testTask.InsuranceObjectFabric;
import by.eis.testTask.entity.enums.ClientParams;
import by.eis.testTask.entity.enums.ContractParams;
import by.eis.testTask.entity.enums.InsuranceCases;
import by.eis.testTask.entity.enums.InsuranceObjects;
import by.eis.testTask.resource.ClientDB;
import by.eis.testTask.service.IContract;
import by.eis.testTask.service.Insurable;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InsuranceContract implements IContract, Serializable {

    private String number;
    private String type;
    private Client client;
    private Insurable insuranceObject;
    private int contractTerm;
    private String signingDate;
    private Set<InsuranceCases> insuranceCasesList = new HashSet<InsuranceCases>();


    public InsuranceContract() {
    }

    public InsuranceContract(Client client, Insurable insuranceObject, int contractTerm, String signingDate) {
        this.client = client;
        this.insuranceObject = insuranceObject;
        this.contractTerm = contractTerm;
        this.signingDate = signingDate;
    }

    public InsuranceContract(Map<Enum, String> params) {
        this.number = params.get(ContractParams.CONTRACT_NUMBER);
        if(!ClientDB.getClients().containsKey(params.get(ClientParams.PASSPORT_PERSONAL_ID))) {
            try {
                ClientDB.addClient(params);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        this.client = ClientDB.getClients().get(params.get(ClientParams.PASSPORT_PERSONAL_ID));

        this.insuranceObject = InsuranceObjectFabric.getInsuranceObject(InsuranceObjects.valueOf(params.get(ContractParams.INSURANCE_OBJECT).toUpperCase()),params);
        this.contractTerm = Integer.parseInt(params.get(ContractParams.CONTRACT_TERM));
        this.signingDate = params.get(ContractParams.SIGNING_DATE);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Insurable getInsuranceObject() {
        return insuranceObject;
    }

    public void setInsuranceObject(Insurable insuranceObject) {
        this.insuranceObject = insuranceObject;
    }

    public int getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(int contractTerm) {
        this.contractTerm = contractTerm;
    }

    public String getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(String signingDate) {
        this.signingDate = signingDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Set<InsuranceCases> getInsuranceCasesList() {
        return insuranceCasesList;
    }

    public void setInsuranceCasesList(Set<InsuranceCases> insuranceCasesList) {
        this.insuranceCasesList = insuranceCasesList;
    }

    public void addInsuranceCase(InsuranceCases insuranceCase) {
        this.insuranceCasesList.add(insuranceCase);
    }

    @Override
    public String toString() {
        return "InsuranceContract{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", client=" + client +
                ", insuranceObject=" + insuranceObject +
                ", contractTerm=" + contractTerm +
                ", signingDate='" + signingDate + '\'' +
                ", insuranceCasesList=" + insuranceCasesList +
                '}';
    }
}
