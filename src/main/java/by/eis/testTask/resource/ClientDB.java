package by.eis.testTask.resource;

import by.eis.testTask.entity.Client;
import by.eis.testTask.entity.enums.ClientParams;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ClientDB {
    private static Map<String, Client> clients = new HashMap<String, Client>();

    public static Map<String, Client> getClients() {
        try {
            getClientsDB();
        } catch(Exception e) {

        }
        return clients;
    }

    public static void setClients(Map<String, Client> clients) {
        ClientDB.clients = clients;
    }

    private static void getClientsDB() {
        File file = new File("clients.bin");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            clients = (Map<String, Client>) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addClient(Map<Enum, String> params) throws IOException {
        try {
            getClientsDB();
        } catch (Exception e) {

        }
        if (!clients.containsKey(params.get(ClientParams.PASSPORT_PERSONAL_ID))) {
            clients.put(params.get(ClientParams.PASSPORT_PERSONAL_ID), new Client(params));
            saveClientsDB();
        }
    }

    public static void saveClientsDB() throws IOException {
        File file = new File("clients.bin");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(clients);
        outputStream.flush();
        outputStream.close();

    }
}
