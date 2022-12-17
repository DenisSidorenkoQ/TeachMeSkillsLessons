package com.exmaple.springboot.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class MessageDto {
    int senderId;
    int recipientId;
    String text;
}
