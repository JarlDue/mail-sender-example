package service.ports;

import service.models.SendMessageRequest;

public interface MessageService {

    void sendMessage(SendMessageRequest sendMessageRequest);

}
