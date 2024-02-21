package com.shop.nghoso.controller;

import com.shop.nghoso.payload.response.FileResponse;
import com.shop.nghoso.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileStorageController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam MultipartFile product){
        boolean isSuccess = fileStorageService.uploadFile(product);
        FileResponse fileResponse = new FileResponse();
        fileResponse.setSuccess(isSuccess);
        fileResponse.setImage_name(product.getOriginalFilename());
        return new ResponseEntity<>(fileResponse, HttpStatus.OK);
    }

    @GetMapping("/load/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> loadFile(@PathVariable String filename) {
        Resource file = fileStorageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
