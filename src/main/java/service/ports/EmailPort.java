package service.ports;

import service.models.SendEmailRequest;

public interface EmailPort {
    void sendEmail(SendEmailRequest sendEmailRequest);
}
