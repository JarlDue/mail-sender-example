package outbound;

import service.models.SendEmailRequest;

import java.util.Optional;

public interface EmailSenderFactory {

    Optional<EmailSender> createEmailSender(SendEmailRequest sendEmailRequest);

}
