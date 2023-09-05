package outbound.senders;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.reactive.ReactiveMailer;
import jakarta.enterprise.context.ApplicationScoped;
import outbound.senders.domainloggers.EmailSenderLogger;
import service.models.SendEmailRequest;

@ApplicationScoped
public class ReactiveEmailSender implements outbound.EmailSender{

    private final ReactiveMailer reactiveMailer;
    private final EmailSenderLogger emailSenderLogger;

    public ReactiveEmailSender(ReactiveMailer reactiveMailer, EmailSenderLogger emailSenderLogger) {
        this.reactiveMailer = reactiveMailer;
        this.emailSenderLogger = emailSenderLogger;
        emailSenderLogger.setTypeOfEmailSender("Reactive");
    }

    @Override
    public void sendEmail(SendEmailRequest sendEmailRequest) {
        emailSenderLogger.logSendingEmail(sendEmailRequest);
        reactiveMailer.send(Mail.withText(sendEmailRequest.getRecipient().getAddress(), sendEmailRequest.getSubject(), sendEmailRequest.getContent())).subscribe().with(
                item -> emailSenderLogger.logEmailSent(sendEmailRequest),
                failure -> System.err.println("Failed to send email: " + failure.getMessage())
        );
    }
}
