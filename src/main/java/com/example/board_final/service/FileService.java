package com.example.board_final.service;

import com.example.board_final.domain.vo.FileVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileService {
    List<FileVO> getFileListByBoardId(Long boardId);
    FileVO getFileById(Long fileId);
}
