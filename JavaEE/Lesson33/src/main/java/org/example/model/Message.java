package org.example.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Message {
    int senderId;
    int recipientId;
    String text;
}
