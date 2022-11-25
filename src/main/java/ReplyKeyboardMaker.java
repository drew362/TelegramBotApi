import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ReplyKeyboardMaker {
    public static ReplyKeyboardMarkup getButtons() {
        List<KeyboardRow> keyboardRowList = new ArrayList<>();           //список кнопок
        KeyboardRow keyboardFirstRow = new KeyboardRow();                // первая строка клавиатуры

        keyboardFirstRow.add(new KeyboardButton("BTCUSDC"));
        keyboardFirstRow.add(new KeyboardButton("ETHUSDC"));
        //   keyboardFirstRow.add(new KeyboardButton("/setting"));

        KeyboardRow keyboardSecondRow = new KeyboardRow();          //вторая строка клавиатуры
        keyboardSecondRow.add(new KeyboardButton("Чехов"));
        keyboardSecondRow.add(new KeyboardButton("Встречи"));
        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        return replyKeyboardMarkup;
    }
}
