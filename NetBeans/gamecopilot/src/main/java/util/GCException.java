package util;

public class GCException extends Exception {

    private String message;

    public GCException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
