package by.eis.testTask;

import by.eis.testTask.entity.enums.*;
import by.eis.testTask.resource.ContractDB;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InsuranceMain {
    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("1. Add new insurance contract\n" +
                    "2. See all contracts\n" +
                    "3. Exit");

            try {
                Scanner scan = new Scanner(System.in);
                switch (scan.nextInt()) {
                    case 1:
                        try {
                            ContractDB.addContract(getContractParams());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.println("Choose output format:\n" +
                                "1. Json\n" +
                                "2. YAML\n" +
                                "3. Cancel");
                        switch (new Scanner(System.in).nextInt()) {
                            case 1:
                                seeAllInJson();
                                break;
                            case 2:
                                seeAllInYAML();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Incorrect input");
                                break;
                        }
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Incorrect input");
                        break;

                }
            } catch (Exception e) {
                System.out.println("Illegal input");
            }
        }
    }

    public static Map<Enum, String> getContractParams() {
        Map<Enum, String> params = new HashMap<Enum, String>();
        Scanner scan = new Scanner(System.in);
        for (ClientParams value : ClientParams.values()) {
            System.out.println(value+":");
            params.put(value,scan.nextLine());
        }
        for (ContractParams value : ContractParams.values()) {
            if (value!=ContractParams.INSURANCE_OBJECT && value!=ContractParams.INSURANCE_TYPE) {
                System.out.println(value + ":");
                params.put(value, scan.nextLine());
            }
        }

        System.out.println(ContractParams.INSURANCE_TYPE+":");
        for (int i = 0; i < InsuranceTypes.values().length; i++) {
            System.out.println((i+1)+". "+InsuranceTypes.values()[i]);
        }
        int tmp = scan.nextInt();
        for (int i = 0; i < InsuranceTypes.values().length; i++) {
            if (tmp == i+1) {
                params.put(ContractParams.INSURANCE_TYPE, InsuranceTypes.values()[i].name());
                break;
            }
        }

        System.out.println(ContractParams.INSURANCE_OBJECT+":");
        for (int i = 0; i < InsuranceObjects.values().length; i++) {
            System.out.println((i+1)+". "+InsuranceObjects.values()[i]);
        }
        tmp = scan.nextInt();
        for (int i = 0; i < InsuranceObjects.values().length; i++) {
            if (tmp == i+1) {
                params.put(ContractParams.INSURANCE_OBJECT, InsuranceObjects.values()[i].name());
                break;
            }
        }

        scan = new Scanner(System.in);
        switch (InsuranceObjects.valueOf(params.get(ContractParams.INSURANCE_OBJECT).toUpperCase())) {
            case APPARTEMENT:
                for (AppartementParams value : AppartementParams.values()) {
                    System.out.println(value + ":");
                    params.put(value, scan.nextLine());
                }
                break;
            case CAR:
                for (CarParams value : CarParams.values()) {
                    System.out.println(value + ":");
                    params.put(value, scan.nextLine());
                }
                break;
            case BYCICLE:
                for (BycicleParams value : BycicleParams.values()) {
                    System.out.println(value + ":");
                    params.put(value, scan.nextLine());
                }
                break;
        }
        return params;
    }

    public static void seeAllInJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map contractMapFromJson= mapper.readValue(new File("contracts.json"), Map.class);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String jsonOutput = gson.toJson(contractMapFromJson);
        System.out.println(jsonOutput);
    }

    public static void seeAllInYAML() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Map json= mapper.readValue(new File("contracts.yaml"), Map.class);
        System.out.println(mapper.writeValueAsString(json));

    }
}
