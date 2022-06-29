package com.tubes;


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class PrimbonJawa_bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "PrimbonJawa_bot";
    }

    @Override
    public String getBotToken() {
        return "5512231501:AAEzVRkiggV_O6XKqNO8I9pvhbDbrFwQ0EM";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                String text = message.getText();

                if (text.equals("/start")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Selamat Datang di PrimbonJawa_Bot. Untuk memulai, silahkan pilih jenis kelamin anda pada menu dibawah!");
                    sendMessage.setChatId(message.getChatId());

                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> inLineButtons = new ArrayList<>();
                    List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
                    InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
                    inlineKeyboardButton1.setText("Laki-Laki");
                    inlineKeyboardButton2.setText("Perempuan");
                    inlineKeyboardButton3.setText("Menu Awal");
                    inlineKeyboardButton1.setCallbackData("Laki-Laki");
                    inlineKeyboardButton2.setCallbackData("Perempuan");
                    inlineKeyboardButton3.setCallbackData("Menu Awal");
                    inlineKeyboardButtonList.add(inlineKeyboardButton1);
                    inlineKeyboardButtonList.add(inlineKeyboardButton2);
                    inlineKeyboardButtonList.add(inlineKeyboardButton3);
                    inLineButtons.add(inlineKeyboardButtonList);
                    inlineKeyboardMarkup.setKeyboard(inLineButtons);
                    sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (update.hasCallbackQuery()) {
            Message message = update.getCallbackQuery().getMessage();
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());


            if (data.equals("Laki-Laki")) {
                sendMessage.setText("Selanjutnya silahkan mas masukan Tanggal Lahir anda dengan format 'dd/mm/yyyy'!");
                if(message.hasText()){
                    String text = message.getText();
                    if (text.equals("1")) {
                        sendMessage.setText("Selamat Datang di PrimbonJawa_Bot. Untuk memulai, silahkan pilih jenis kelamin anda pada menu dibawah!");
                        sendMessage.setChatId(message.getChatId());
                }
                } else if (data.equals("Perempuan")) {
                    sendMessage.setText("Selanjutnya silahkan mbak masukan Tanggal Lahir anda dengan format 'dd/mm/yyyy!' ");
                } else if (data.equals("Menu Awal")) {
                    sendMessage.setText("Silahkan tekan /start");
                }
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
