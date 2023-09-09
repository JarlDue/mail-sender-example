package service;

import jakarta.enterprise.context.ApplicationScoped;
import outbound.EmailAdapter;
import service.enums.MessageType;
import service.ports.MessageAdapter;
import service.ports.MessageAdapterFactory;

@ApplicationScoped
public class StandardMessageAdapterFactory implements MessageAdapterFactory {

    private final EmailAdapter emailAdapter;

    public StandardMessageAdapterFactory(EmailAdapter emailAdapter) {
        this.emailAdapter = emailAdapter;
    }

    @Override
    public MessageAdapter getMessageAdapter(MessageType type) {
        switch (type) {
            case EMAIL:
                return emailAdapter;
            default:
                throw new IllegalArgumentException("Unknown message type: " + type);
        }
    }
}
