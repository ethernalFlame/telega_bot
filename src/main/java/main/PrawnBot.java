package main;

import java.util.List;

import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * @author prawn
 */
public class PrawnBot extends TelegramLongPollingBot {

    private static final String BOT_NAME = "main.PrawnBot";
    private static final String TOKEN = "678787257:AAGfbmm_yQfg3x29YAj_OkmajUmy50LP4bk";
    private ActionMapper actionMapper;

    public static void main(String[] args) {
        ApiContextInitializer.init(); // Инициализируем апи
        System.out.println("lol");
        TelegramBotsApi botapi = new TelegramBotsApi();
        DefaultBotOptions instance = ApiContext
                .getInstance(DefaultBotOptions.class);
        try {
            botapi.registerBot(new PrawnBot(instance));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        System.out.println("kek");
    }

    public PrawnBot(DefaultBotOptions options) {
        super(options);
        actionMapper = new ActionMapper(this);
    }

    public void onUpdateReceived(Update update) {
        System.out.println("ya tut");
        Message msg = update.getMessage();
        String txt = msg.getText();

        actionMapper.execute(msg, txt.split(" ")[0]);
    }

    public void onUpdatesReceived(List<Update> updates) {
        for (Update up:
             updates) {
            onUpdateReceived(up);
        }
    }

    public String getBotUsername() {
        return BOT_NAME;
    }

    public String getBotToken() {
        return TOKEN;
    }

    public void onClosing() {

    }

    public void sendMsg(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId());
        s.setText(text);
        try {
            sendMessage(s);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

}
