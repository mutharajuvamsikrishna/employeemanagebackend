package com.oniesoft.serviceimpl;

import com.oniesoft.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService {
    @Value("${file.upload-dir}")
    private String uploadDir;

    public String saveFile(Long regno, String fileType, MultipartFile file) throws IOException {


        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String userDir = uploadDir + "/" + regno;
        String filePath = userDir + "/" + fileType + "_" + fileName;

        // Create the user directory if it doesn't exist
        Files.createDirectories(Path.of(userDir));

        // Save the file to the specified path
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, Path.of(filePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Failed to save file " + fileName, e);
        }

        return filePath;
    }
}
