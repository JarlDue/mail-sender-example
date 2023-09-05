package outbound;

import service.models.SendEmailRequest;

public interface EmailSender {
    void sendEmail(SendEmailRequest sendEmailRequest);
}
