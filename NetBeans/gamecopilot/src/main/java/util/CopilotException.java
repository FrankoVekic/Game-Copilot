package util;

public class CopilotException extends Exception {

    private String message;

    public CopilotException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
