package service.models;

import org.immutables.value.Value;
import service.enums.ProcessingModel;

@Value.Immutable
public interface SendEmailRequest {

    EmailAddress getRecipient(); // Using Email type instead of String

    String getSubject();

    String getContent();

    ProcessingModel getProcessingModel();

}
