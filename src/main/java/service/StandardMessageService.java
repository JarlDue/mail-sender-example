package service;

import jakarta.enterprise.context.ApplicationScoped;
import service.models.SendMessageRequest;
import service.ports.MessageAdapterFactory;
import service.ports.MessageService;

@ApplicationScoped
public class StandardMessageService implements MessageService {

    private final MessageAdapterFactory messageAdapterFactory;

    public StandardMessageService(MessageAdapterFactory messageAdapterFactory) {
        this.messageAdapterFactory = messageAdapterFactory;
    }

    @Override
    public void sendMessage(SendMessageRequest sendMessageRequest) {
        //add message to db.
        messageAdapterFactory.getMessageAdapter(sendMessageRequest.getType())
                .sendMessage(sendMessageRequest);
        //subscribe and wait for confirmation that message is sent.
    }
}
