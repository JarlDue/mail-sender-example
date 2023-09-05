import org.junit.jupiter.api.Test;
import service.enums.ProcessingModel;
import service.models.*;
import service.models.EmailAddress;
import service.models.ImmutableEmailAddress;

import static org.junit.jupiter.api.Assertions.*;

public class SendMailConstructorTests {

    @Test
    void constructWithInvalidEmailExpectException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            EmailAddress testEmailAddress = ImmutableEmailAddress.builder()
                    .address("laslda.dk")
                    .build();
        });
    }
    @Test
    void constructWithValidEmail() {

        String testEmailString = "test.test@acme.dk";

        EmailAddress testEmailAddress = ImmutableEmailAddress.builder()
                .address(testEmailString)
                .build();

        assertNotNull(testEmailAddress);
        assertEquals(testEmailString, testEmailAddress.getAddress());
    }

    @Test
    void constructSendEmailRequest() {
        EmailAddress testEmailAddress = ImmutableEmailAddress.builder()
                .address("test.test@acme.dk")
                .build();

        SendEmailRequest sendEmailRequest = ImmutableSendEmailRequest.builder()
                .recipient(testEmailAddress)
                .subject("Test")
                .content("Test")
                .processingModel(ProcessingModel.ASYNC)
                .build();

        assertAll("sendEmailRequest",
                () -> assertNotNull(sendEmailRequest),
                () -> assertEquals(testEmailAddress,sendEmailRequest.getRecipient()),
                () -> assertEquals("Test",sendEmailRequest.getSubject()),
                () -> assertEquals("Test",sendEmailRequest.getContent()));
    }
}