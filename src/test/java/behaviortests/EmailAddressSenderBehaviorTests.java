package behaviortests;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.MockMailbox;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.enums.ProcessingModel;
import service.models.*;
import service.models.EmailAddress;
import service.models.ImmutableEmailAddress;
import service.ports.EmailPort;

import java.util.List;

@QuarkusTest
public class EmailAddressSenderBehaviorTests {

    @Inject
    EmailPort emailPort;

    @Inject
    MockMailbox mockMailbox;

    @BeforeEach
    void init() {
        mockMailbox.clear();
    }

    private final String emailAddressString = "john.doe@test.dk";

    @Test
    void whenAttemptingToSendValidImperativeEmail_thenEmailIsSent() {
        SendEmailRequest sendEmailRequest = createSendEmailRequest(ProcessingModel.IMPERATIVE);
        emailPort.sendEmail(sendEmailRequest);

        List<Mail> mailList = mockMailbox.getMailsSentTo(emailAddressString);

        Assertions.assertAll("sending email Imperatively", ()
            -> Assertions.assertEquals(1, mailList.size()),
            () -> Assertions.assertEquals("Test", mailList.get(0).getSubject()),
            () -> Assertions.assertEquals("Hello World", mailList.get(0).getText()));
    }

    @Test
    void whenAttemptingToSendValidReactiveEmail_thenEmailIsSent() {
        SendEmailRequest sendEmailRequest = createSendEmailRequest(ProcessingModel.REACTIVE);
        emailPort.sendEmail(sendEmailRequest);

        List<Mail> mailList = mockMailbox.getMailsSentTo(emailAddressString);

        Assertions.assertAll("sending email Imperatively", ()
                        -> Assertions.assertEquals(1, mailList.size()),
                () -> Assertions.assertEquals("Test", mailList.get(0).getSubject()),
                () -> Assertions.assertEquals("Hello World", mailList.get(0).getText()));
    }

    @Test
    void whenAttemptingToSendValidAsyncEmail_thenEmailIsSent() {
        SendEmailRequest sendEmailRequest = createSendEmailRequest(ProcessingModel.ASYNC);
        emailPort.sendEmail(sendEmailRequest);
    }

    private SendEmailRequest createSendEmailRequest(ProcessingModel processingModel) {
        EmailAddress emailAddress = ImmutableEmailAddress.builder()
                .address(emailAddressString)
                .build();

        return ImmutableSendEmailRequest.builder()
                .recipient(emailAddress)
                .processingModel(processingModel)
                .content("Hello World")
                .subject("Test")
                .build();
    }
}
