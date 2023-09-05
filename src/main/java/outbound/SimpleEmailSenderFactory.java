package outbound;

import jakarta.enterprise.context.ApplicationScoped;
import outbound.senders.AsyncEmailSender;
import outbound.senders.ImperativeEmailSender;
import outbound.senders.ReactiveEmailSender;
import service.models.SendEmailRequest;

import java.util.Optional;

@ApplicationScoped
public class SimpleEmailSenderFactory implements EmailSenderFactory{

    private final ImperativeEmailSender imperativeEmailSender;
    private final ReactiveEmailSender reactiveMailer;

    public SimpleEmailSenderFactory(ImperativeEmailSender imperativeEmailSender, ReactiveEmailSender reactiveMailer) {
        this.imperativeEmailSender = imperativeEmailSender;
        this.reactiveMailer = reactiveMailer;
    }

    public Optional<EmailSender> createEmailSender(SendEmailRequest sendEmailRequest) {
        switch (sendEmailRequest.getProcessingModel()) {
            case ASYNC -> {
                return Optional.of(new AsyncEmailSender());
            }
            case REACTIVE -> {
                return Optional.of(reactiveMailer);
            }
            case IMPERATIVE -> {
                return Optional.of(imperativeEmailSender);
            }
            default -> {
                throw new IllegalArgumentException("Unsupported processing model");
            }
        }
    }
}