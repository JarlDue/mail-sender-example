package service.ports;

import service.models.SendMessageRequest;

public interface MessageAdapter {
    void sendMessage(SendMessageRequest sendMessageRequest);
}
