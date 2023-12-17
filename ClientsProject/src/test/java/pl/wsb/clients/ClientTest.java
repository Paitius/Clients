package pl.wsb.clients;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private final Client client = new Client("Kamil", "Gębka");

    @Test
    void shouldReturnFirstNameOfClient() {
        //
        //when
        String returnedFirstNameFromClient = client.getFirstName();
        //then
        String expectedName = "Kamil";
        Assertions.assertEquals(expectedName, returnedFirstNameFromClient);

    }

    @Test
    void shouldReturnLastNameOfClient() {
        //When
        String returnedLastNameFromClient = client.getLastName();
        //then
        String expectedLastName = "Gębka";
        Assertions.assertEquals(expectedLastName, returnedLastNameFromClient);
    }
}