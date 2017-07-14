package mk.ukim.finki.tires.config;

/**
 * Created by user on 14.7.2017.
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsNotification {
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC118dfdcbc0036205973d324fe4a2bf64";
    public static final String AUTH_TOKEN = "931b3091a7beecc6c679ddaadb5bff31";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("+38975405830"),
                new PhoneNumber("+14848123336"),
                "This is the ship that made the Kessel Run in fourteen parsecs?").create();

        System.out.println(message.getSid());
    }
}
