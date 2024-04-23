package com.oniesoft.service;

import com.oniesoft.model.Avatar;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AvatarService {
    public void addAvatar(Avatar avatar, MultipartFile avatarFile) throws IOException;
}
