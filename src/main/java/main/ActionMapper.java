package main;

import java.util.HashMap;
import java.util.Map;

import actions.AbstractTelegramAction;
import actions.HappyBirthDay;
import actions.HelloAction;
import actions.HelpAction;
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
        if (abstractTelegramAction == null)
            prawnBot.sendMsg(m, "Я так не умею(");
        else
        prawnBot.sendMsg(m, abstractTelegramAction.getMessage(m));
    }

    private Map<String, AbstractTelegramAction> initMap() {
        Map<String, AbstractTelegramAction> map = new HashMap<String, AbstractTelegramAction>();
        map.put("/start", new HelloAction());
        map.put("/help", new HelpAction());
        map.put("/happyBirthday", new HappyBirthDay(prawnBot));
        return map;
    }

}
