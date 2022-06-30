package com.tubes;


import com.google.common.collect.Lists;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
                SendMessage sendMessage = new SendMessage();

                if (text.equals("/start")) {
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

                } else if (text.contains("-")) {
                    String ramalan = "";
                    Random rand = new Random();
                    String randomElement = "";
                    List<String> givenList = Lists.newArrayList("Pada dasarnya, anda termasuk tipe yang penuh keberuntungan, karena anda selalu merencanakan tindakan anda dengan hati-hati, terbuka terhadap peluang yang baru, dan tidak mudah putus asa. Anda juga memiliki beberapa keterampilan sosial, sehingga sejelek apapun wajah anda, kemungkinan besar anda mudah bergaul dengan orang lain! Sisi buruknya, anda suka sekali pamer. Mungkin anda hanya haus perhatian sewaktu masih kecil, sehingga kini anda merasa harus membuat kagum semua orang dengan kepandaian atau kekayaan anda",
                            "Anda adalah salah seorang penggemar gaya hidup yang santai dan mewah. Bagi anda, kualitas selalu lebih penting daripada harga yang murah.",
                            "Anda tidak suka membesar-besarkan diri. Bahkan, anda lebih sering mengalah kepada orang yang lebih cerewet daripada mempersoalkan hal-hal yang remeh. Meskipun demikian, anda bersemangat baja. Beberapa orang mungkin mengatakan anda sedikit kaku",
                            "Anda adalah pemikir sejati dengan sikap lembut disertai gaya duniawi yang mempesona yang mudah menarik orang lain kepada anda. Dikarenakan bakat alami anda akan bahasa dan kepekaan terhadap perasaan orang lain, maka anda memiliki potensi untuk menjadi seorang pembicara besar.",
                            "Anda memiliki cita-cita yang besar disertai semangat baja untuk mewujudkannya. Anda selalu siaga mencari kesempatan untuk memajukan kepentingan anda. Tetapi hal itu bukanlah untuk anda semata; anda juga sangat mempedulikan keluarga dan selalu siap membantu saudara yang membutuhkan perlindungan atau pengasuhan.",
                            "Anda menghormati tata krama dan berpegang teguh pada falsafah hidup anda. Kejujuran adalah salah satu prioritas anda, sehingga anda membenci ketidakadilan. Anda sangat setia terhadap teman tercinta anda yang sangat banyak",
                            "Anda termasuk tipe yang sensitif. Hati dan pikiran anda mungkin cukup dalam, tetapi terkadang orang lain menganggap anda tertutup. Barangkali anda telah mengembangkan penilaian yang tajam terhadap baik-buruknya watak manusia. Dengan bakat ini, anda dapat menjadi seorang diplomat yang piawai atau malahan seorang manipulator yang licik! Yang jelas, anda selalu berusaha terlihat baik didepan teman-teman anda.",
                            " kemungkinan anda bersifat lekas naik darah! Untungnya, secepat anda memuntahkan kemarahan anda secepat itu pula anda melupakan penyebabnya. Semoga orang lain sebaliknya mudah memaafkan anda pula! Perlu diingat, bukanlah suatu hal yang menyakitkan untuk mengakui kesalahan yang kita lakukan");

                    int numberOfElements = 2;

                    for (int i = 0; i < numberOfElements; i++) {
                        int randomIndex = rand.nextInt(givenList.size());
                        randomElement = givenList.get(randomIndex);
                        givenList.remove(randomIndex);

                    }

                    sendMessage.setText(randomElement+"\n\n\n\nUntuk ramalan selanjutnya silahkan langsung masukan tanggal lahir anda." +
                            "\nAtau kembali ke menu awal dengan tombol berikut /start !");
                    sendMessage.setChatId(message.getChatId());


                } else if (!text.contains("-") || !text.contains("/")) {

                    sendMessage.setText("Masukan Tanggal sesuai format");
                    sendMessage.setChatId(message.getChatId());
                }
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        } else if (update.hasCallbackQuery()) {
            Message message = update.getCallbackQuery().getMessage();
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());


            if (data.equals("Laki-Laki")) {
                SendMessage sendMessage1 = new SendMessage();
                sendMessage1.setText("Selanjutnya silahkan mas masukan Tanggal Lahir anda dengan format 'dd-mm-yyyy'!");
                sendMessage1.setChatId(message.getChatId());
                try {
                    execute(sendMessage1);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (data.equals("Perempuan")) {

                sendMessage.setText("Selanjutnya silahkan mbak masukan Tanggal Lahir anda dengan format 'dd-mm-yyyy!' ");
                sendMessage.setChatId(message.getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (data.equals("Menu Awal")) {

                sendMessage.setText("Silahkan ketuk tulisan berikut /start ");
                sendMessage.setChatId(message.getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setTanggal(String text) {
        String tanggal = text;
    }

}
