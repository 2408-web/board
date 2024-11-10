package com.example.board_final.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class CommentVO {
    private long commentId;
    private long boardId;
    private String providerId;
    private String commentContent;
    private LocalDateTime commentRegisterDate;
    private LocalDateTime commentUpdateDate;

}
