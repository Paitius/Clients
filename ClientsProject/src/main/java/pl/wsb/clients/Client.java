package pl.wsb.clients;

public class Client {
    private final String lastName;
    private final String firstName;

    public Client(String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;

    }

    public String getFirstName(){
        return firstName;

    }

    public String getLastName(){
        return lastName;
    }

}
