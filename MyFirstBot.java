package uz.mobiler;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyFirstBot extends TelegramLongPollingBot {
    int c=0;

    @Override
    public String getBotUsername() {
        return "nahotk1_bot";
    }

    @Override
    public String getBotToken() {
        return "5928785546:AAGkjk0oyzf1m7WMJrOo-JZTD6-5i9rvmPU";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()){
            Message message = update.getMessage();

            if (message.hasText()){
                String text = message.getText();

                if (text.equals("/start") || text.equals("/retry")){



                    SendMessage sendMessage = new SendMessage();
                    System.out.println(message.getFrom().getFirstName() + " botga start berdi");
                    SendMessage sendMessage1 = new SendMessage();
                    sendMessage1.setText("@" + message.getFrom().getUserName() + " botga start berdi");
                    sendMessage1.setParseMode(ParseMode.MARKDOWN);
                    sendMessage1.setChatId("5522204543");
                    try {
                        execute(sendMessage1);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                    sendMessage.setText("Assalomu Aleykum!!!\nBizning botning vazifa juda oddiy\nShunchaki lotindan krilga\nKrildan esa lotin ");
                    sendMessage.setParseMode(ParseMode.HTML);
                    sendMessage.setChatId(message.getChatId());

                    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                    replyKeyboardMarkup.setResizeKeyboard(true);
                    List<KeyboardRow> keyboardRowArrayList = new ArrayList<>();
                    KeyboardRow keyboardRow1 = new KeyboardRow();
                    KeyboardButton keyboardButton1 = new KeyboardButton();
                    keyboardButton1.setText("Lotin-Krill");
                    keyboardRow1.add(keyboardButton1);
                    KeyboardRow keyboardRow2 = new KeyboardRow();
                    KeyboardButton keyboardButton2 = new KeyboardButton();
                    keyboardButton2.setText("Krill-Lotin");
                    keyboardRow2.add(keyboardButton2);
                    KeyboardRow keyboardRow3 = new KeyboardRow();
                    KeyboardButton keyboardButton3 = new KeyboardButton();
                    keyboardButton3.setText("Share contact");
                    keyboardButton3.setRequestContact(true);
                    keyboardRow3.add(keyboardButton3);
                    KeyboardRow keyboardRow4 = new KeyboardRow();
                    KeyboardButton keyboardButton4 = new KeyboardButton();
                    keyboardButton4.setText("Share location");
                    keyboardRow4.add(keyboardButton4);
                    keyboardButton4.setRequestLocation(true);
                    keyboardRowArrayList.add(keyboardRow1);
                    keyboardRowArrayList.add(keyboardRow2);
                    keyboardRowArrayList.add(keyboardRow3);
                    keyboardRowArrayList.add(keyboardRow4);
                    replyKeyboardMarkup.setKeyboard(keyboardRowArrayList);
                    sendMessage.setReplyMarkup(replyKeyboardMarkup);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }else if (text.equals("Lotin-Krill") || text.equals("/lotinkril")){
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("So'z kiriting");
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setParseMode(ParseMode.MARKDOWN);

                    c=1;
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }else if (text.equals("Krill-Lotin") || text.equals("/krillotin")){
                    c=2;
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("сoз киритинг");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(message.getChatId());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }else if (c==1){
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText(krill(text));
                    sendMessage.setParseMode(ParseMode.HTML);
                    sendMessage.setChatId(message.getChatId());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }else if (c==2){
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText(lotin(text));
                    sendMessage.setParseMode(ParseMode.HTML);
                    sendMessage.setChatId(message.getChatId());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }

            }else if (message.hasContact()){
                Contact contact = message.getContact();
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Your name    ->     " + contact.getFirstName() + "\nPhone number -> " + contact.getPhoneNumber() + "\nUser id    ->   "+contact.getUserId()+"\nBoshiga qaytish     /retry");
                sendMessage.setChatId(message.getChatId());
                sendMessage.setParseMode(ParseMode.MARKDOWN);
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }else if (message.hasLocation()){
                Location location = message.getLocation();
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Your cordinate:\n" + location.getLatitude() +" , "+ location.getLongitude()+"\nUshbu cordinatani Googlemapda ishlatish mumkin");
                sendMessage.setParseMode(ParseMode.MARKDOWN);
                sendMessage.setChatId(message.getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public String krill(String text){
        String soz = "";
        for (int i=0; i<text.length(); i++){
            if (text.charAt(i) != text.charAt(text.length()-1)){
                if (text.charAt(i) == 's' && text.charAt(i+1) == 'h'){
                    soz += "ш";
                    i++;
                    continue;
                }else if (text.charAt(i) == 'S' && text.charAt(i+1) == 'h'){
                    soz += "Ш";
                    i++;
                    continue;
                }else if (text.charAt(i) == 'c' && text.charAt(i+1) == 'h'){
                    soz += "ч";
                    i++;
                    continue;
                }else if (text.charAt(i) == 'C' && text.charAt(i+1) == 'h'){
                    soz += "Ч";
                    i++;
                    continue;
                }else if (text.charAt(i) == 'o' && text.charAt(i+1) == '`'){
                    soz += "о";
                    i++;
                    continue;
                }else if (text.charAt(i) == 'O' && text.charAt(i+1) == '`'){
                    soz += "О";
                    i++;
                    continue;
                }else if (text.charAt(i) == 'O' && text.charAt(i+1) == '\''){
                    soz += "О";
                    i++;
                    continue;
                }else if (text.charAt(i) == 'o' && text.charAt(i+1) == '\''){
                    soz += "о";
                    i++;
                    continue;
                } else if (text.charAt(i) == 'Y' && text.charAt(i + 1) == 'a') {
                    soz += "Я";
                    i++;
                    continue;
                } else if (text.charAt(i) == 'y' && text.charAt(i + 1) == 'a') {
                    soz += "я";
                    i++;
                    continue;
                } else if (text.charAt(i) == 'Y' && text.charAt(i + 1) == 'u') {
                    soz += "Ю";
                    i++;
                    continue;
                } else if (text.charAt(i) == 'y' && text.charAt(i + 1) == 'u') {
                    soz += "ю";
                    i++;
                    continue;
                }
            }
            switch (text.charAt(i)){
                case 'Q':
                    soz += "К";
                    break;
                case 'q':
                    soz += "к";

                    break;
                case 'W':
                    soz += "Ш";

                    break;
                case 'w':
                    soz += "ш";

                    break;
                case 'E':
                    soz += "Э";

                    break;
                case 'e':
                    soz += "е";

                    break;
                case 'R':
                    soz += "Р";

                    break;
                case 'r':
                    soz += "р";

                    break;
                case 'T':
                    soz += "Т";

                    break;
                case 't':
                    soz += "т";

                    break;
                case 'Y':
                    soz += "Й";

                    break;
                case 'y':
                    soz += "й";

                    break;
                case 'U':
                    soz += "У";

                    break;
                case 'u':
                    soz += "у";

                    break;
                case 'I':
                    soz += "И";

                    break;
                case 'i':
                    soz += "и";

                    break;
                case 'O':
                    soz += "О";

                    break;
                case 'o':
                    soz += "о";

                    break;
                case 'P':
                    soz += "П";

                    break;
                case 'p':
                    soz += "п";

                    break;
                case 'A':
                    soz += "А";

                    break;
                case 'a':
                    soz += "а";

                    break;
                case 'S':
                    soz += "С";

                    break;
                case 's':
                    soz += "с";

                    break;
                case 'D':
                    soz += "Д";

                    break;
                case 'd':
                    soz += "д";

                    break;
                case 'F':
                    soz += "Ф";

                    break;
                case 'f':
                    soz += "ф";

                    break;
                case 'G':
                    soz += "Г";

                    break;
                case 'g':
                    soz += "г";

                    break;
                case 'H':
                    soz += "Х";

                    break;
                case 'h':
                    soz += "х";

                    break;
                case 'J':
                    soz += "Ж";

                    break;
                case 'j':
                    soz += "ж";

                    break;
                case 'K':
                    soz += "К";

                    break;
                case 'k':
                    soz += "к";

                    break;
                case 'L':
                    soz += "Л";

                    break;
                case 'l':
                    soz += "л";

                    break;
                case 'Z':
                    soz += "З";

                    break;
                case 'z':
                    soz += "з";

                    break;
                case 'X':
                    soz += "Х";

                    break;
                case 'x':
                    soz += "х";

                    break;
                case 'C':
                    soz += "Ч";

                    break;
                case 'c':
                    soz += "ч";

                    break;
                case 'V':
                    soz += "В";

                    break;
                case 'v':
                    soz += "в";

                    break;
                case 'B':
                    soz += "Б";

                    break;
                case 'b':
                    soz += "б";

                    break;
                case 'N':
                    soz += "Н";

                    break;
                case 'n':
                    soz += "н";

                    break;
                case 'M':
                    soz += "М";
                    break;
                case 'm':
                    soz += "м";

                    break;
                default:
                    soz += text.charAt(i);
            }
        }
            return soz;
    }
    public String lotin(String text){
        String soz = "";
        for (int i=0; i<text.length(); i++){
            if (text.charAt(i) == 'Ь' || text.charAt(i) == 'ь') continue;
            switch (text.charAt(i)){
                case 'Щ':
                    soz += "Sh";
                    break;
                case 'щ':
                    soz += "sh";
                    break;
                case 'Ц':
                    soz += "Ts";
                    break;
                case 'ц':
                    soz += "ts";
                    break;
                case 'Ы':
                    soz += "I";
                    break;
                case 'ы':
                    soz += "i";

                    break;
                case 'Ш':
                    soz += "Sh";

                    break;
                case 'ш':
                    soz += "sh";

                    break;
                case 'Э':
                    soz += "E";

                    break;
                case 'э':
                    soz += "e";

                    break;
                case 'Р':
                    soz += "R";

                    break;
                case 'р':
                    soz += "r";

                    break;
                case 'Т':
                    soz += "T";

                    break;
                case 'т':
                    soz += "t";

                    break;
                case 'Й':
                    soz += "Y";

                    break;
                case 'й':
                    soz += "y";

                    break;
                case 'У':
                    soz += "U";

                    break;
                case 'у':
                    soz += "u";

                    break;
                case 'И':
                    soz += "I";

                    break;
                case 'и':
                    soz += "i";

                    break;
                case 'О':
                    soz += "O";

                    break;
                case 'о':
                    soz += "o";

                    break;
                case 'П':
                    soz += "P";

                    break;
                case 'п':
                    soz += "p";

                    break;
                case 'А':
                    soz += "A";

                    break;
                case 'а':
                    soz += "a";

                    break;
                case 'С':
                    soz += "S";

                    break;
                case 'с':
                    soz += "s";

                    break;
                case 'Д':
                    soz += "D";

                    break;
                case 'д':
                    soz += "d";

                    break;
                case 'Ф':
                    soz += "F";

                    break;
                case 'ф':
                    soz += "f";

                    break;
                case 'Г':
                    soz += "G";

                    break;
                case 'г':
                    soz += "g";

                    break;
                case 'Ж':
                    soz += "J";

                    break;
                case 'ж':
                    soz += "j";

                    break;
                case 'К':
                    soz += "Q";

                    break;
                case 'к':
                    soz += "q";

                    break;
                case 'Л':
                    soz += "L";

                    break;
                case 'л':
                    soz += "l";

                    break;
                case 'З':
                    soz += "Z";

                    break;
                case 'з':
                    soz += "z";

                    break;
                case 'Х':
                    soz += "X";

                    break;
                case 'х':
                    soz += "x";

                    break;
                case 'Ч':
                    soz += "Ch";

                    break;
                case 'ч':
                    soz += "ch";

                    break;
                case 'В':
                    soz += "V";

                    break;
                case 'в':
                    soz += "v";

                    break;
                case 'Б':
                    soz += "B";

                    break;
                case 'б':
                    soz += "b";

                    break;
                case 'Н':
                    soz += "N";

                    break;
                case 'н':
                    soz += "n";

                    break;
                case 'М':
                    soz += "M";
                    break;
                case 'м':
                    soz += "m";
                    break;
                case 'Е':
                    soz += "E";


                    break;
                case 'е':
                    soz += "e";
                    break;
                default:
                    soz += text.charAt(i);
            }
        }
        return soz;
    }


}
