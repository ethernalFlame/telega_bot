package actions;

import org.telegram.telegrambots.api.objects.Message;

/**
 * @author prawn
 */
public abstract class AbstractTelegramAction {

    public AbstractTelegramAction() {}

    public abstract String getMessage(Message m);
}
