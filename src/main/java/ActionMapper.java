import java.util.HashMap;
import java.util.Map;

import actions.AbstractTelegramAction;
import org.telegram.telegrambots.api.objects.Message;

/**
 * @author prawn
 */
public class ActionMapper {

    private PrawnBot prawnBot;
    private Map<String, AbstractTelegramAction> actionMap;
    //private


    public ActionMapper(PrawnBot prawnBot) {
        this.prawnBot = prawnBot;
        actionMap = initMap();
    }

    public void execute(Message m, String s) {
        AbstractTelegramAction abstractTelegramAction = actionMap.get(s);
        prawnBot.sendMsg(m, abstractTelegramAction.getMessage());
    }

    private Map<String, AbstractTelegramAction> initMap() {
        Map<String, AbstractTelegramAction> map = new HashMap<String, AbstractTelegramAction>();
        map.put("/start", new AbstractTelegramAction("Привет"));


        return map;
    }

}
