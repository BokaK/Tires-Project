package mk.ukim.finki.tires.config;

/**
 * Created by user on 14.7.2017.
 */
import com.sendgrid.*;
import java.io.IOException;

public class SmsSendGrid{
    public static final String ACCOUNT_SID = "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";
    public static void main(String[] args) throws IOException {

        Email from = new Email("test@example.com");
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email("kabranova.boka@hotmail.com");
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(ACCOUNT_SID);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}