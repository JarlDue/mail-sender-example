package outbound;

import jakarta.enterprise.context.ApplicationScoped;
import service.models.SendEmailRequest;
import service.ports.EmailPort;

@ApplicationScoped
public class EmailAdapter implements EmailPort {

    private final EmailSenderFactory emailSenderFactory;

    public EmailAdapter(EmailSenderFactory emailSenderFactory) {
        this.emailSenderFactory = emailSenderFactory;
    }

    @Override
    public void sendEmail(SendEmailRequest sendEmailRequest) {
        emailSenderFactory.createEmailSender(sendEmailRequest)
                .ifPresent(emailSender -> emailSender.sendEmail(sendEmailRequest));
    }
}
