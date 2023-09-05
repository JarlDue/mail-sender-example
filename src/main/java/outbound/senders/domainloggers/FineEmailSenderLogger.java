package outbound.senders.domainloggers;

import io.quarkus.arc.profile.IfBuildProfile;
import jakarta.enterprise.context.ApplicationScoped;
import service.models.SendEmailRequest;

@ApplicationScoped
@IfBuildProfile("test")
public class FineEmailSenderLogger implements EmailSenderLogger {

    private String typeOfEmailSender;

    @Override
    public void logSendingEmail(SendEmailRequest sendEmailRequest) {
        System.out.printf("sending email using the %sSender to %s, with content %s - ", typeOfEmailSender, sendEmailRequest.getRecipient(), sendEmailRequest.getContent());
    }

    @Override
    public void logEmailSent(SendEmailRequest sendEmailRequest) {
        System.out.printf("email is sent using %sSender to %s, with content %s - ", typeOfEmailSender, sendEmailRequest.getRecipient(), sendEmailRequest.getContent());
    }

    @Override
    public void setTypeOfEmailSender(String typeOfEmailSender) {
        this.typeOfEmailSender = typeOfEmailSender;
    }
}
