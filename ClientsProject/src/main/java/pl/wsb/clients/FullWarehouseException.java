package pl.wsb.clients;

public class FullWarehouseException extends RuntimeException {
    private final String message;

    public FullWarehouseException(String message){
        super();
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
