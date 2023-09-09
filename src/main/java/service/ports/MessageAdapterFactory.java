package service.ports;

import service.enums.MessageType;

public interface MessageAdapterFactory {

    MessageAdapter getMessageAdapter(MessageType type);

}
