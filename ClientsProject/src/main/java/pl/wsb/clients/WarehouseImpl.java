package pl.wsb.clients;
import java.util.*;

public class WarehouseImpl implements Warehouse {
    // HashMap contains iD as a K, and HashMap as V -> metalType, massStoredByClient
    private final HashMap<String, HashMap<SupportedMetalType, Double>>dataWerHouse;
    private final HashMap<String, Boolean> isPremiumAcc;
    public WarehouseImpl(){
        this.dataWerHouse = new HashMap<>();
        this.isPremiumAcc = new HashMap<>();
    }

    /**
     * Creating empty HashMap, which contains SupportedMetalTypes, and set mass as 0
     * @return emptyDataClientWareHouse empty list with mass equal 0 for every time of metals
     */
    public HashMap<SupportedMetalType, Double> emptyClientWareHouse(){
        HashMap<SupportedMetalType, Double> emptyDataClientWareHouse = new HashMap<>();
        for (SupportedMetalType metalType : SupportedMetalType.values()) {
            emptyDataClientWareHouse.put(metalType, (double) 0);
        }
        return emptyDataClientWareHouse;
    }

    /**
     * Adding client to WareHouse. Set clientId as K, and HashMap contains SupportedMetalTypes with mass 0 for each as V
     * @param clientId
     */
    public void addClientToWareHouse(String clientId, Boolean premiumStatus){
        this.dataWerHouse.put(clientId, emptyClientWareHouse());
        this.isPremiumAcc.put(clientId, premiumStatus);
    }



    @Override
    public void addMetalIngot(String clientId, SupportedMetalType metalType, double mass) throws ClientNotFoundException, ProhibitedMetalTypeException, FullWarehouseException {
        double massIngot = getTotalVolumeOccupiedByClient(clientId) + (mass/SupportedMetalType.valueOf(metalType.toString()).getDensity());
        if (!Arrays.stream(SupportedMetalType.values()).toList().contains(metalType)){
            throw new ProhibitedMetalTypeException("Incorrect metal type");
        }
        if (!dataWerHouse.containsKey(clientId)){
            throw new ClientNotFoundException("Client does not exist in WareHouse");
        }
        if (massIngot > 5 ) {
            if ((massIngot< 10) && (isPremiumAcc.get(clientId))) {
                dataWerHouse.get(clientId).put(metalType, dataWerHouse.get(clientId).get(metalType) + mass);
            }else{
                throw new FullWarehouseException("Warehouse is full");
            }
        }else{
            dataWerHouse.get(clientId).put(metalType, dataWerHouse.get(clientId).get(metalType) + mass);
        }


    }

    @Override
    public Map<SupportedMetalType, Double> getMetalTypesToMassStoredByClient(String clientId) {
        return dataWerHouse.get(clientId);
    }

    @Override
    public double getTotalVolumeOccupiedByClient(String clientId) {
        // Calls getStoredMetalTypesByClient method by clientId, getting stored metalTypes by client with value != 0
        List<SupportedMetalType> storedMetals = getStoredMetalTypesByClient(clientId);
        double totalVolumeOccupiedByClient = 0;
        // for each metalTypes stored by client calculate volume (stored mass/ metal destiny)
        for (SupportedMetalType storedMetal : storedMetals) {
            double volumeOccupiedByClient = dataWerHouse.get(clientId).get(storedMetal);
            double metalDestiny = SupportedMetalType.valueOf(storedMetal.toString()).getDensity();
            totalVolumeOccupiedByClient += (volumeOccupiedByClient/metalDestiny);
        }
        return totalVolumeOccupiedByClient;
    }

    @Override
    public List<SupportedMetalType> getStoredMetalTypesByClient(String clientId) {
        HashMap<SupportedMetalType, Double> storedMetalsByClient = dataWerHouse.get(clientId);
        List<SupportedMetalType> listOfStoredMetalTypesByClient = new ArrayList<>();
        // filter all metals where mass != 0 and add to List
        for (SupportedMetalType metal : storedMetalsByClient.keySet()) {
            if (storedMetalsByClient.get(metal) > 0){
                listOfStoredMetalTypesByClient.add(metal);
            }
        }
        return listOfStoredMetalTypesByClient;
    }
}
