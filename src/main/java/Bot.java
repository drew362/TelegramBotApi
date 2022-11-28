import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.io.IOException;
import java.util.HashMap;

public class Bot extends TelegramLongPollingBot {
    private static String BOT_TOKEN = "";
    private static String BOT_NAME = "";

//    private static final Map<String,String> getenv = System.getenv();

//    public Bot(String botName, String botToken){
//        super();
//        this.BOT_TOKEN = botToken;
//        this.BOT_NAME = botName;
//    }

    public String getBotUsername() {
        return BOT_NAME;
    }

    public String getBotToken() {
        return BOT_TOKEN;
    }

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());

        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

//        try {
//            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//            botsApi.registerBot(new Bot(getenv.get("BOT_NAME"), getenv.get("BOT_TOKEN")));
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
    }

    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
//        sendMessage.setReplyToMessageId(message.getMessageId()); //ответ на сообщение по id
        sendMessage.setText(text);
        try {
            sendMessage.setReplyMarkup(ReplyKeyboardMaker.getButtons());
//            setButtons(sendMessage);
            sendMessage(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        Model model = new Model();
        Message message = update.getMessage();
        HashMap<String, String> map = new HashMap<>();

        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "BTCUSDC":
                case "ETHUSDC":
                    try {
                        sendMsg(message, Binance.getBalance(message.getText(), model));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "Встречи":
                    sendMsg(message, "https://jazz.sber.ru/vb26or?psw=OAFUXBYBAxUYEVNKSRUUBhcbTg Синк" + "\n" +
                            "https://meetup.sberbank.ru/w/s/e7462311-2317-40c5-9a60-f29424ad0ee6  qa созвон" + "\n" +
                            "https://jazz.sberbank.ru/sber-enec0o?psw=OBkXAhQOABUFCRAUSxoXBgoDDQ НТ статус");
                    break;
                default:
                    try {
                        sendMsg(message, Weather.getWeather(message.getText(), model));
                    } catch (IOException e) {
                        sendMsg(message, "Ты гонишь!");
                    }
            }
        }
    }
}











