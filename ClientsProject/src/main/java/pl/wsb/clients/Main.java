package pl.wsb.clients;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Clientsimpl clients = new Clientsimpl();
        WarehouseImpl warehouse = new WarehouseImpl();

        Client client1 = new Client("Kamil", "Gebkea");
        Client client2 = new Client("Marek", "Burk");

        String client1Id = clients.createNewClient(client1.getFirstName(), client1.getLastName());
        String client2Id = clients.createNewClient(client2.getFirstName(),client2.getLastName());

    }
}