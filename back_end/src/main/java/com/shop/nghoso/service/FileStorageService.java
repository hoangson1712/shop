package com.shop.nghoso.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    boolean uploadFile(MultipartFile file);
    Resource loadFile(String filename);
}
