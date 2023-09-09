package service.models;

import service.enums.MessageType;

public interface SendMessageRequest {

    String getSubject();
    String getContent();

    MessageType getType();

}
