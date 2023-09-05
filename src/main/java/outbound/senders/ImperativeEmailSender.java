package outbound.senders;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import outbound.senders.domainloggers.EmailSenderLogger;
import service.models.SendEmailRequest;

@ApplicationScoped
public class ImperativeEmailSender implements outbound.EmailSender{

    private final Mailer mailer;
    private final EmailSenderLogger emailSenderLogger;

    public ImperativeEmailSender(Mailer mailer, EmailSenderLogger emailSenderLogger) {
        this.mailer = mailer;
        this.emailSenderLogger = emailSenderLogger;
        emailSenderLogger.setTypeOfEmailSender("Imperative");
    }

    @Override
    public void sendEmail(SendEmailRequest sendEmailRequest) {
        emailSenderLogger.logSendingEmail(sendEmailRequest);
        mailer.send(Mail.withText(sendEmailRequest.getRecipient().getAddress(), sendEmailRequest.getSubject(), sendEmailRequest.getContent()));
        emailSenderLogger.logEmailSent(sendEmailRequest);
    }
}
