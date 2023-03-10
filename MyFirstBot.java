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
                    sendMessage.setText("??o?? ????????????????");
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
                    soz += "??";
                    i++;
                    continue;
                }else if (text.charAt(i) == 'S' && text.charAt(i+1) == 'h'){
                    soz += "??";
                    i++;
                    continue;
                }else if (text.charAt(i) == 'c' && text.charAt(i+1) == 'h'){
                    soz += "??";
                    i++;
                    continue;
                }else if (text.charAt(i) == 'C' && text.charAt(i+1) == 'h'){
                    soz += "??";
                    i++;
                    continue;
                }else if (text.charAt(i) == 'o' && text.charAt(i+1) == '`'){
                    soz += "??";
                    i++;
                    continue;
                }else if (text.charAt(i) == 'O' && text.charAt(i+1) == '`'){
                    soz += "??";
                    i++;
                    continue;
                }else if (text.charAt(i) == 'O' && text.charAt(i+1) == '\''){
                    soz += "??";
                    i++;
                    continue;
                }else if (text.charAt(i) == 'o' && text.charAt(i+1) == '\''){
                    soz += "??";
                    i++;
                    continue;
                } else if (text.charAt(i) == 'Y' && text.charAt(i + 1) == 'a') {
                    soz += "??";
                    i++;
                    continue;
                } else if (text.charAt(i) == 'y' && text.charAt(i + 1) == 'a') {
                    soz += "??";
                    i++;
                    continue;
                } else if (text.charAt(i) == 'Y' && text.charAt(i + 1) == 'u') {
                    soz += "??";
                    i++;
                    continue;
                } else if (text.charAt(i) == 'y' && text.charAt(i + 1) == 'u') {
                    soz += "??";
                    i++;
                    continue;
                }
            }
            switch (text.charAt(i)){
                case 'Q':
                    soz += "??";
                    break;
                case 'q':
                    soz += "??";

                    break;
                case 'W':
                    soz += "??";

                    break;
                case 'w':
                    soz += "??";

                    break;
                case 'E':
                    soz += "??";

                    break;
                case 'e':
                    soz += "??";

                    break;
                case 'R':
                    soz += "??";

                    break;
                case 'r':
                    soz += "??";

                    break;
                case 'T':
                    soz += "??";

                    break;
                case 't':
                    soz += "??";

                    break;
                case 'Y':
                    soz += "??";

                    break;
                case 'y':
                    soz += "??";

                    break;
                case 'U':
                    soz += "??";

                    break;
                case 'u':
                    soz += "??";

                    break;
                case 'I':
                    soz += "??";

                    break;
                case 'i':
                    soz += "??";

                    break;
                case 'O':
                    soz += "??";

                    break;
                case 'o':
                    soz += "??";

                    break;
                case 'P':
                    soz += "??";

                    break;
                case 'p':
                    soz += "??";

                    break;
                case 'A':
                    soz += "??";

                    break;
                case 'a':
                    soz += "??";

                    break;
                case 'S':
                    soz += "??";

                    break;
                case 's':
                    soz += "??";

                    break;
                case 'D':
                    soz += "??";

                    break;
                case 'd':
                    soz += "??";

                    break;
                case 'F':
                    soz += "??";

                    break;
                case 'f':
                    soz += "??";

                    break;
                case 'G':
                    soz += "??";

                    break;
                case 'g':
                    soz += "??";

                    break;
                case 'H':
                    soz += "??";

                    break;
                case 'h':
                    soz += "??";

                    break;
                case 'J':
                    soz += "??";

                    break;
                case 'j':
                    soz += "??";

                    break;
                case 'K':
                    soz += "??";

                    break;
                case 'k':
                    soz += "??";

                    break;
                case 'L':
                    soz += "??";

                    break;
                case 'l':
                    soz += "??";

                    break;
                case 'Z':
                    soz += "??";

                    break;
                case 'z':
                    soz += "??";

                    break;
                case 'X':
                    soz += "??";

                    break;
                case 'x':
                    soz += "??";

                    break;
                case 'C':
                    soz += "??";

                    break;
                case 'c':
                    soz += "??";

                    break;
                case 'V':
                    soz += "??";

                    break;
                case 'v':
                    soz += "??";

                    break;
                case 'B':
                    soz += "??";

                    break;
                case 'b':
                    soz += "??";

                    break;
                case 'N':
                    soz += "??";

                    break;
                case 'n':
                    soz += "??";

                    break;
                case 'M':
                    soz += "??";
                    break;
                case 'm':
                    soz += "??";

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
            if (text.charAt(i) == '??' || text.charAt(i) == '??') continue;
            switch (text.charAt(i)){
                case '??':
                    soz += "Sh";
                    break;
                case '??':
                    soz += "sh";
                    break;
                case '??':
                    soz += "Ts";
                    break;
                case '??':
                    soz += "ts";
                    break;
                case '??':
                    soz += "I";
                    break;
                case '??':
                    soz += "i";

                    break;
                case '??':
                    soz += "Sh";

                    break;
                case '??':
                    soz += "sh";

                    break;
                case '??':
                    soz += "E";

                    break;
                case '??':
                    soz += "e";

                    break;
                case '??':
                    soz += "R";

                    break;
                case '??':
                    soz += "r";

                    break;
                case '??':
                    soz += "T";

                    break;
                case '??':
                    soz += "t";

                    break;
                case '??':
                    soz += "Y";

                    break;
                case '??':
                    soz += "y";

                    break;
                case '??':
                    soz += "U";

                    break;
                case '??':
                    soz += "u";

                    break;
                case '??':
                    soz += "I";

                    break;
                case '??':
                    soz += "i";

                    break;
                case '??':
                    soz += "O";

                    break;
                case '??':
                    soz += "o";

                    break;
                case '??':
                    soz += "P";

                    break;
                case '??':
                    soz += "p";

                    break;
                case '??':
                    soz += "A";

                    break;
                case '??':
                    soz += "a";

                    break;
                case '??':
                    soz += "S";

                    break;
                case '??':
                    soz += "s";

                    break;
                case '??':
                    soz += "D";

                    break;
                case '??':
                    soz += "d";

                    break;
                case '??':
                    soz += "F";

                    break;
                case '??':
                    soz += "f";

                    break;
                case '??':
                    soz += "G";

                    break;
                case '??':
                    soz += "g";

                    break;
                case '??':
                    soz += "J";

                    break;
                case '??':
                    soz += "j";

                    break;
                case '??':
                    soz += "Q";

                    break;
                case '??':
                    soz += "q";

                    break;
                case '??':
                    soz += "L";

                    break;
                case '??':
                    soz += "l";

                    break;
                case '??':
                    soz += "Z";

                    break;
                case '??':
                    soz += "z";

                    break;
                case '??':
                    soz += "X";

                    break;
                case '??':
                    soz += "x";

                    break;
                case '??':
                    soz += "Ch";

                    break;
                case '??':
                    soz += "ch";

                    break;
                case '??':
                    soz += "V";

                    break;
                case '??':
                    soz += "v";

                    break;
                case '??':
                    soz += "B";

                    break;
                case '??':
                    soz += "b";

                    break;
                case '??':
                    soz += "N";

                    break;
                case '??':
                    soz += "n";

                    break;
                case '??':
                    soz += "M";
                    break;
                case '??':
                    soz += "m";
                    break;
                case '??':
                    soz += "E";


                    break;
                case '??':
                    soz += "e";
                    break;
                default:
                    soz += text.charAt(i);
            }
        }
        return soz;
    }


}
