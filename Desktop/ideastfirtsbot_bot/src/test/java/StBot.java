import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StBot extends TelegramLongPollingBot {



    public void onUpdateReceived(Update update) {

      //  System.out.println(update.getMessage().getText());
        // System.out.println(update.getMessage().getFrom().getFirstName());

        String command = update.getMessage().getText();

        SendMessage message = new SendMessage();

        if (command.equals("/myname")){
            System.out.println(update.getMessage().getFrom().getFirstName());

            message.setText(update.getMessage().getFrom().getFirstName());
        }

        if (command.equals("/mylastname")){
            System.out.println(update.getMessage().getFrom().getLastName());

            message.setText(update.getMessage().getFrom().getLastName());

        }

        if (command.equals("/myfullname")){
            System.out.println(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());

            message.setText(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
        }

        message.setChatId(update.getMessage().getChatId());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }

    public String getBotUsername() {
        return "ideastfirtsbot_bot";
    }

    public String getBotToken() {
        return "853784528:AAGLk1R_LjSBZzj5HpFVjSZIdOkzP272tlU";
    }
}
