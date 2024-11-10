package com.example.board_final.service;

import com.example.board_final.domain.dto.BoardDTO;
import com.example.board_final.domain.oauth.CustomOAuth2User;
import com.example.board_final.domain.vo.BoardVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface BoardService {

    void insertBoard(BoardVO board, List<MultipartFile> files);

    // 상세보기 페이지로 이동할 때!
    BoardDTO selectBoardDetail(Long boardId, CustomOAuth2User customUser);


    BoardVO selectBoard(long boardId);
    void updateBoard(BoardVO board, List<MultipartFile> files);
    void deleteBoard(Long boardId);
    List<BoardDTO> selectAll();
    List<BoardDTO> selectAllByDateASC();
    List<BoardDTO> selectAllByViews();
}
