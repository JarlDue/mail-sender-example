package outbound.senders;

import jakarta.enterprise.context.ApplicationScoped;
import service.models.SendEmailRequest;

@ApplicationScoped
public class AsyncEmailSender implements outbound.EmailSender{
    @Override
    public void sendEmail(SendEmailRequest sendEmailRequest) {
        System.out.printf("sending email asynchronously to %s%n", sendEmailRequest.getRecipient());
    }
}
