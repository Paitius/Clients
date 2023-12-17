package pl.wsb.clients;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class Clientsimpl implements Clients {
    // Holds all clients
    private final HashMap<String,String> dataClient;
    private final HashMap<String,LocalDate> dataClientCreationData;

    // Holds all clients with premium status
    private final HashMap<String,String> dataClientsPremiumAcc;


    public Clientsimpl(){
        this.dataClient = new HashMap<>();
        this.dataClientsPremiumAcc = new HashMap<>();
        this.dataClientCreationData = new HashMap<>();
    }


    @Override
    public String createNewClient(String firstName, String lastName) {


        // Generating iD client using randomUUID

        String clientId = UUID.randomUUID().toString();

        // Adding client to HashMap(iD, fullName)
        this.dataClient.put(clientId,(firstName + " " + lastName));
        this.dataClientCreationData.put(clientId,LocalDate.now());
        return clientId;
    }

    @Override
    public String activatePremiumAccount(String clientId) {

        // Checks if it does not exist in dataClientsPremiumAcc, if exist throw error, else add to db

        if(!dataClientsPremiumAcc.containsKey(clientId) && dataClient.containsKey(clientId)) {
            dataClientsPremiumAcc.put(clientId, dataClient.get(clientId));
            return dataClient.get(clientId);
        }
        else {throw new ClientNotFoundException("Client does not exist");}
    }

    @Override
    public String getClientFullName(String clientId) {

        if(!dataClient.containsKey(clientId)){
            throw new ClientNotFoundException("Client does not exist");
        }else {
            return dataClient.get(clientId);
        }
    }

    @Override
    public LocalDate getClientCreationDate(String clientId) {
        return dataClientCreationData.get(clientId);
    }

    @Override
    public boolean isPremiumClient(String clientId) {
        return dataClientsPremiumAcc.containsKey(clientId);
    }

    @Override
    public int getNumberOfClients() {
        return dataClient.size();
    }

    @Override
    public int getNumberOfPremiumClients() {
        return dataClientsPremiumAcc.size();
    }
}
