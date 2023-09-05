package outbound.senders;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import service.models.SendEmailRequest;

@ApplicationScoped
public class ReactiveEmailSender implements outbound.EmailSender{

    private final ReactiveMailer reactiveMailer;

    public ReactiveEmailSender(ReactiveMailer reactiveMailer) {
        this.reactiveMailer = reactiveMailer;
    }

    @Override
    public void sendEmail(SendEmailRequest sendEmailRequest) {
        System.out.printf("sending email reactively to %s%n", sendEmailRequest.getRecipient());
        reactiveMailer.send(Mail.withText(sendEmailRequest.getRecipient().getAddress(), sendEmailRequest.getSubject(), sendEmailRequest.getContent())).subscribe().with(
                item -> System.out.println("Email sent successfully."),
                failure -> System.err.println("Failed to send email: " + failure.getMessage())
        );
    }
}
