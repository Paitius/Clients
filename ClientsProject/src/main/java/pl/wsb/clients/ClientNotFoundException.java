package pl.wsb.clients;

public class ClientNotFoundException extends RuntimeException {
    private final String message;
    public ClientNotFoundException(String message){
        super();
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
