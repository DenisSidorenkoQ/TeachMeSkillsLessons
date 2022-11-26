package com.exmaple.springboot.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MessageDto {
    int senderId;
    int recipientId;
    String text;
}
