package pl.wsb.clients;

public class ProhibitedMetalTypeException extends RuntimeException {
    private final String message;

    public ProhibitedMetalTypeException(String message){
        super();
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
