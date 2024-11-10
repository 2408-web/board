package com.example.board_final.controller;

import com.example.board_final.domain.dto.BoardDTO;
import com.example.board_final.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardRestController {

    private final BoardService boardService;

    @Autowired
    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 클라이언트의 요청에 따라 게시글 목록을 정렬하여 반환
    @GetMapping("/sorted-list")
    public ResponseEntity<List<BoardDTO>> getSortedBoardList(@RequestParam String sort) {
        List<BoardDTO> sortedBoards;

        switch (sort) {
            case "newest":
                sortedBoards = boardService.selectAll();
                break;
            case "oldest":
                sortedBoards = boardService.selectAllByDateASC();
                break;
            case "views":
                sortedBoards = boardService.selectAllByViews();
                break;
            default:
                sortedBoards = boardService.selectAll();
        }

        return ResponseEntity.ok(sortedBoards);
    }

    @GetMapping("/list")
    public ApiDTO getBoardList() throws URISyntaxException {
        String baseUrl = "https://api.odcloud.kr/api/15125354/v1/uddi:a46a069c-278f-4d70-83a9-b688dafa222b";

        //인코딩키 사용
        String serviceKey = "H%2Bahbp5aXDNZ0LdPcjLNxuKXfsxdPG9ZOcZirzOzILBaRRhgkJ%2B26rzfc4qkRT6p7MG0tJRXPl3WA7AVRcJ0aw%3D%3D";

        //쿼리파라미터로 연결
        String url = baseUrl + "?serviceKey=" + serviceKey;

        HttpHeaders headers = new HttpHeaders();
        URI uri = new URI(url);

        headers.set("Authorization", serviceKey);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ApiDTO apiDTO = restTemplate.exchange(uri, HttpMethod.GET, entity, ApiDTO.class).getBody();

        return apiDTO;
    }
}
