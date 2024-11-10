package com.example.board_final.service;

import com.example.board_final.domain.vo.FileVO;
import com.example.board_final.mapper.FileMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private final FileMapper fileMapper;

    public FileServiceImpl(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }
    @Override
    public List<FileVO> getFileListByBoardId(Long boardId) {
        return fileMapper.getFileListByBoardId(boardId);
    }

    @Override
    public FileVO getFileById(Long fileId) {
        return fileMapper.getFileById(fileId);
    }
}
