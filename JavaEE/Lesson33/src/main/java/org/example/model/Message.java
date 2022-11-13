package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Getter
@Value
@Builder
public class Message {
    int senderId;
    int recipientId;
    String text;
}
