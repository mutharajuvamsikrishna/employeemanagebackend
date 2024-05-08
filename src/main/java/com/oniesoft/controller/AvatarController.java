package com.oniesoft.controller;

import com.oniesoft.dto.AvatarDto;
import com.oniesoft.model.Avatar;
import com.oniesoft.repository.ProfileRepo;
import com.oniesoft.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/profile/v1")
public class AvatarController {
    @Autowired
private AvatarService avatarService;
    @Autowired
    private ProfileRepo profileRepo;

    @PostMapping("/avatar")
    public ResponseEntity<?> addAvatarDetails(@RequestParam String empId,  MultipartFile avatarFile) throws IOException {
     Avatar Existavatar=   profileRepo.findByEmpId(empId);
        if(Existavatar!=null){
            avatarService.addAvatar(Existavatar,avatarFile);
            return ResponseEntity.ok("ok");
        }else {
            Avatar avatar = new Avatar();
            avatar.setEmpId(empId);
            avatarService.addAvatar(avatar, avatarFile);
            return ResponseEntity.ok("ok");
        }
    }
    @PutMapping("/avatar-update")
    public ResponseEntity<?> updateAvatar(@RequestParam Long regno,@RequestParam String empId,@RequestParam(required = false) MultipartFile avatarFile) throws IOException {

        Avatar avatar =profileRepo.findByEmpId(empId);
        avatarService.addAvatar(avatar, avatarFile);
        return ResponseEntity.ok("ok");

    }
    @GetMapping(value = "/getavatardetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AvatarDto> getAvatarDetails(@RequestParam String empId) {
              Avatar avatar = profileRepo.findByEmpId(empId);
        if (avatar != null) {
            List<String> filePaths = getFilePathsForAvatar(avatar);
            List<byte[]> fileContents = getFileContents(filePaths);
           AvatarDto avatarDto=new AvatarDto();
            avatarDto.setRegno(avatarDto.getRegno());
            avatarDto.setEmpId(avatarDto.getEmpId());
            avatarDto.setProfile(avatar.getProfile());
            avatarDto.setFileContents(fileContents);
            return ResponseEntity.ok(avatarDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    private List<String> getFilePathsForAvatar(Avatar avatar) {
        List<String> filePaths = new ArrayList<>();
        filePaths.add(avatar.getProfile());
        return filePaths;
    }
    private List<byte[]> getFileContents(List<String> filePaths) {
        List<byte[]> fileContents = new ArrayList<>();
        for (String filePath : filePaths) {
            if (filePath != null) {
                try {
                    byte[] content = Files.readAllBytes(Paths.get(filePath));
                    fileContents.add(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fileContents;
    }
    @DeleteMapping("/deletavatar")
    public ResponseEntity<?> deleteAvatar(@RequestParam String empId){
        avatarService.deleteAvatarImage(empId);
         return ResponseEntity.status(200).body("delete sucessfully");
    }
}

