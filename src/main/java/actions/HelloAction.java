package actions;

import org.telegram.telegrambots.api.objects.Message;

/**
 * @author prawn
 */
public class HelloAction extends AbstractTelegramAction {

    public String getMessage(Message m) {
        if (m.getFrom().getUserName().equals("ad_notam"))
            return "Привет, кисонька)) \nЯ робот, но все еще Владислав) \nПо команде '/help' можешь узнать," +
                    " что я умею, помимо того, что круто трахаюсь";
        return "Салам Аллейкум";
    }
}
