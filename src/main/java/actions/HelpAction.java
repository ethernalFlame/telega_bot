package actions;

import org.telegram.telegrambots.api.objects.Message;

/**
 * @author prawn
 */
public class HelpAction extends AbstractTelegramAction {


    public String getMessage(Message m) {
        String s =
                "/start - Приветствие\n" +
                "/help - Помощь\n";
        if (m.getFrom().getUserName().equals("ad_notam"))
            s += "/happyBirthday - поздравления для любимой\n" +
                    "/kisa - нифкусна( и грусна";
        return s;
    }
}
