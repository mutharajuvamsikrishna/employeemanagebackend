package com.oniesoft.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    public String saveFile(Long regno, String fileType, MultipartFile file) throws IOException;
}
