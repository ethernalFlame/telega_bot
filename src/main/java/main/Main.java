package main;

import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * @author prawn
 */
public class Main {
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
}
