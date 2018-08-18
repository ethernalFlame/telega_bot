package actions;

import main.PrawnBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * @author prawn
 */
public class KisaAction extends AbstractTelegramAction {

    private PrawnBot prawnBot;
    private final Long PUCHEK_ID = 407378418L;

    public KisaAction(PrawnBot prawnBot) {
        this.prawnBot = prawnBot;
    }

    public String getMessage(Message m) {
        if (m.getFrom().getUserName().equals("ad_notam")) {
            SendMessage message = new SendMessage();
            message.setText(m.getText());
            message.setChatId(PUCHEK_ID);
            try {
                prawnBot.sendMessage(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                return "что - то пошло не так(";
            }
            return "Доехало";
        }
        return "Съеби по - хорошему, я записал, кто ты";
    }
}
