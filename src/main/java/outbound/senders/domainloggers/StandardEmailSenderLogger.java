package outbound.senders.domainloggers;

import io.quarkus.arc.profile.IfBuildProfile;
import jakarta.enterprise.context.RequestScoped;
import service.models.SendEmailRequest;

@RequestScoped
@IfBuildProfile("prod")
public class StandardEmailSenderLogger implements EmailSenderLogger {

    private String typeOfEmailSender;

    @Override
    public void logSendingEmail(SendEmailRequest sendEmailRequest) {
        System.out.printf("sending email %s to %s%n", typeOfEmailSender, sendEmailRequest.getRecipient());
    }

    @Override
    public void logEmailSent(SendEmailRequest sendEmailRequest) {
        System.out.printf("email %s sent to %s%n", typeOfEmailSender, sendEmailRequest.getRecipient());
    }

    public void setTypeOfEmailSender(String typeOfEmailSender) {
        this.typeOfEmailSender = typeOfEmailSender;
    }
}
