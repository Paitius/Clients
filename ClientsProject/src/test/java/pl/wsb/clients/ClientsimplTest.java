package pl.wsb.clients;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;

class ClientsimplTest {
    final Clientsimpl clientsimpl = new Clientsimpl();
    String clientId = clientsimpl.createNewClient("firstName", "lastName");


    @Test
    void shouldReturnFullNameIfStatusPremiumAccIsActivated() {

        // when
        String returnedClientFullNameIfPremiumAccActivated = clientsimpl.activatePremiumAccount(clientId);
        //then
        String expectedFullName= "firstName lastName";
        Assertions.assertEquals(expectedFullName, returnedClientFullNameIfPremiumAccActivated);
    }

    @Test
    void shouldReturnFullName() {
        //when
        String returnedFullName = clientsimpl.getClientFullName(clientId);
        //then
        String expectedFullName = "firstName lastName";
        Assertions.assertEquals(expectedFullName, returnedFullName);

    }

    @Test
    void shouldReturnLocalDataWhenClientAccWasCrated() {
        //when
        LocalDate returnedData = clientsimpl.getClientCreationDate(clientId);
        //then
        LocalDate expectedData = LocalDate.now();
        Assertions.assertEquals(expectedData,returnedData);
    }

    @Test
    void checkClientIsPremiumAccShouldReturnTrue() {
        //given
        clientsimpl.activatePremiumAccount(clientId);
        //when
        Boolean returnedValue = clientsimpl.isPremiumClient(clientId);
        //then
        Boolean expectedValue = true;
        Assertions.assertEquals(expectedValue, returnedValue);

    }

    @Test
    void checkIfClientDontHavePremiumAccShouldReturnFalse(){
        //when
        Boolean returnedValue = clientsimpl.isPremiumClient(clientId);
        //then
        Boolean expectedValue = false;
        Assertions.assertEquals(expectedValue, returnedValue);

    }

    @Test
    void shouldReturnNumbersOfClientsExistingInDataClients() {
        //when
        Integer returnedValue = clientsimpl.getNumberOfClients();
        //then
        Integer expectedValue = 1;
        Assertions.assertEquals(expectedValue, returnedValue);

    }

    @Test
    void shouldReturnZeroNumberOfPremiumAcc() {
        //when
        Integer returnedValue = clientsimpl.getNumberOfPremiumClients();
        //then
        Integer expectedValue = 0;
        Assertions.assertEquals(expectedValue, returnedValue);
    }

    @Test
    void shouldReturnNumberOfPremiumAccWithValue1(){
        clientsimpl.activatePremiumAccount(clientId);
        //when
        Integer returnedValue = clientsimpl.getNumberOfPremiumClients();
        //then
        Integer expectedValue = 1;
        Assertions.assertEquals(expectedValue, returnedValue);

    }
}