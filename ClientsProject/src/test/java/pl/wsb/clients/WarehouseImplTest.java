package pl.wsb.clients;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class WarehouseImplTest {

    final WarehouseImpl warehouseTest = new WarehouseImpl();
    String client1Id = "firstClientId";
    String client2Id = "secondClientId";

    @Test
    void getMetalTypesToMassStoredByClient() {
        //give
        warehouseTest.addClientToWareHouse(client1Id, true);
        warehouseTest.addMetalIngot(client1Id,SupportedMetalType.GOLD, 100);
        HashMap<SupportedMetalType, Double> expectedResult = warehouseTest.emptyClientWareHouse();
        //when
        Map<SupportedMetalType, Double> result =  warehouseTest.getMetalTypesToMassStoredByClient(client1Id);
        //then
        expectedResult.put(SupportedMetalType.GOLD, (double) 100);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void getTotalVolumeOccupiedByClient() {
        //give
        warehouseTest.addClientToWareHouse(client1Id, true);
        warehouseTest.addMetalIngot(client1Id,SupportedMetalType.GOLD, 19300);
        //when
        double result = warehouseTest.getTotalVolumeOccupiedByClient(client1Id);
        //then
        double expectedValue = 1;
        Assertions.assertEquals(expectedValue,result);

    }

    @Test
    void storedMetalsByClientShouldReturnEmpty() {
        //give
        warehouseTest.addClientToWareHouse(client1Id, true);
        //when
        List<SupportedMetalType> result = warehouseTest.getStoredMetalTypesByClient(client1Id);
        //then
        List<SupportedMetalType> expectedValue = new ArrayList<>();
        Assertions.assertEquals(expectedValue,result);

    }
}