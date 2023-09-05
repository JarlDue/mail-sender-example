package outbound.senders.domainloggers;

import service.models.SendEmailRequest;

public interface EmailSenderLogger {

    void logSendingEmail(SendEmailRequest sendEmailRequest);
    void logEmailSent(SendEmailRequest sendEmailRequest);

    void setTypeOfEmailSender(String typeOfEmailSender);

}
