package com.example.board_final.controller;

import com.example.board_final.domain.vo.FileVO;
import com.example.board_final.service.FileService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/download")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
        // 파일 정보 조회
        FileVO fileVO = fileService.getFileById(fileId);

        // 실제 파일을 불러오는 로직 (FileSystemResource 사용 등)
        Path filePath = Paths.get("C:/upload/board/" + fileVO.getStoredFileName());
        Resource resource = new FileSystemResource(filePath);

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        // 파일명 인코딩 처리 등
        String encodedFileName = URLEncoder.encode(fileVO.getOriginalFileName(), StandardCharsets.UTF_8).replace("+", "%20");

        // Content-Disposition 설정
        String contentDisposition = "attachment; filename=\"" + encodedFileName + "\"";

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
            .body(resource);
    }

}
