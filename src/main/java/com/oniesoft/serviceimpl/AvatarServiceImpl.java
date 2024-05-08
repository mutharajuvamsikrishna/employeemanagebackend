package com.oniesoft.serviceimpl;

import com.oniesoft.model.Avatar;
import com.oniesoft.repository.ProfileRepo;
import com.oniesoft.service.AvatarService;
import com.oniesoft.service.FileService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class AvatarServiceImpl implements AvatarService {
@Autowired
private ProfileRepo profileRepo;
@Autowired
private FileService fileService;
    @Override
    public void addAvatar(Avatar avatar, MultipartFile avatarFile) throws IOException {

        Avatar avatar1 = profileRepo.save(avatar);
        // Save files and update file paths in the PerEmp entity
        if(avatar!=null) {
            String avatarpath = fileService.saveFile(avatar1.getRegno(), "avatar", avatarFile);
            avatar1.setProfile(avatarpath);
            profileRepo.save(avatar1);
        }
    }

    @Override

    @Transactional
    public void deleteAvatarImage(String empId) {
        profileRepo.deleteByEmpId(empId);
    }
}
