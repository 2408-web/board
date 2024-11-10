package com.example.board_final.mapper;

import com.example.board_final.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    void insertFile(FileVO fileVO);
    List<FileVO> getFileListByBoardId(Long boardId);
    FileVO getFileById(Long fileId);
    void deleteFiles(long boardId);
}
