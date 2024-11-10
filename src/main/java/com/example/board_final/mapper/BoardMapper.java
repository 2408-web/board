package com.example.board_final.mapper;

import com.example.board_final.domain.dto.BoardDTO;
import com.example.board_final.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {


    Long getSeq();

    void insertBoard(BoardVO board);

    BoardDTO selectBoardDetail(Long boardId);

    BoardVO selectBoard(long boardId);

    void updateBoard(BoardVO board);

    void plusViews(long boardId);

    void deleteBoard(Long boardId);

    List<BoardDTO> selectAll();

    List<BoardDTO> selectAllByDateASC();

    List<BoardDTO> selectAllByViews();

}
