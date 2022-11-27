package com.exmaple.springboot.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Message {
    int senderId;
    int recipientId;
    String text;
}
