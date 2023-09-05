package outbound.senders;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import service.models.SendEmailRequest;

@ApplicationScoped
public class ImperativeEmailSender implements outbound.EmailSender{

    private final Mailer mailer;

    public ImperativeEmailSender(Mailer mailer) {
        this.mailer = mailer;
    }

    @Override
    public void sendEmail(SendEmailRequest sendEmailRequest) {
        System.out.printf("sending email Imperatively to %s%n", sendEmailRequest.getRecipient());
        mailer.send(Mail.withText(sendEmailRequest.getRecipient().getAddress(), sendEmailRequest.getSubject(), sendEmailRequest.getContent()));
    }
}
