package outbound;

import jakarta.enterprise.context.ApplicationScoped;
import service.models.SendEmailRequest;
import service.models.SendMessageRequest;
import service.ports.MessageAdapter;

@ApplicationScoped
public class EmailAdapter implements MessageAdapter {

    private final EmailSenderFactory emailSenderFactory;

    public EmailAdapter(EmailSenderFactory emailSenderFactory) {
        this.emailSenderFactory = emailSenderFactory;
    }

    @Override
    public void sendMessage(SendMessageRequest sendMessageRequest) {

        if (!(sendMessageRequest instanceof SendEmailRequest sendEmailRequest)) {
            throw new IllegalArgumentException("SendEmailRequest required");
        }

        emailSenderFactory.createEmailSender(sendEmailRequest)
                .ifPresent(emailSender -> emailSender.sendEmail(sendEmailRequest));
    }
}
