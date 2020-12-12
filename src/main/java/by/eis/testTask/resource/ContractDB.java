package by.eis.testTask.resource;

import by.eis.testTask.ContractFabric;
import by.eis.testTask.entity.enums.ContractParams;
import by.eis.testTask.service.IContract;;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ContractDB implements  Serializable{
    private static Map<String, IContract> contracts = new HashMap<String, IContract>();

    public static void getContractDB() {
        File file = new File("contracts.bin");
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            contracts = (Map<String,IContract>)inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void addContract(Map<Enum, String> params) throws IOException {
        try {
            getContractDB();
        } catch (Exception e) {

        }
        if (!contracts.containsKey(params.get(ContractParams.CONTRACT_NUMBER))) {
            contracts.put(params.get(ContractParams.CONTRACT_NUMBER), ContractFabric.getContract(params));
            //сохранить файл

        }
        saveContractsDB();
        saveContractsAsJson();
        saveContractsAsYAML();
    }

    public static void saveContractsAsJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("contracts.json"), contracts);

    }
    public static void saveContractsDB() throws IOException {
        File file = new File("contracts.bin");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(contracts);
        outputStream.flush();
        outputStream.close();

    }

    public static void saveContractsAsYAML() throws IOException {
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        om.writeValue(new File("contracts.yaml"), contracts);
    }

    public static Map<String, IContract> getContracts() {
        getContractDB();
        return contracts;
    }

    @Override
    public String toString() {
        return contracts.toString();
    }
}
