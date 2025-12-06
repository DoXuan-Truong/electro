package com.electro.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageRequest {
    private String content;
    private String image;
    private Integer status;
    private Long userId;
    private Long roomId;
}
