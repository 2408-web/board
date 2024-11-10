package com.example.board_final.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class BoardVO {

    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private int boardViews;
    private LocalDateTime boardRegisterDate;
    private LocalDateTime boardUpdateDate;
    private String providerId;

}
