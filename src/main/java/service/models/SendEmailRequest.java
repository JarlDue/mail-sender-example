package service.models;

import org.immutables.value.Value;
import service.enums.MessageType;
import service.enums.ProcessingModel;

@Value.Immutable
public interface SendEmailRequest extends SendMessageRequest {

    EmailAddress getRecipient(); // Using Email type instead of String

    ProcessingModel getProcessingModel();

    @Override
    default MessageType getType() {
        return MessageType.EMAIL;
    }

}
