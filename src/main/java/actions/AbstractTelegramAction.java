package actions;

/**
 * @author prawn
 */
public class AbstractTelegramAction {
    private String message;

    public AbstractTelegramAction(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
