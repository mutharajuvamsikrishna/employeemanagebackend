package com.oniesoft.dto;


import java.util.List;

public class AvatarDto {
    private Long regno;
    private String email;
    private String profile;
    private List<String> filePaths;
    private List<byte[]> fileContents;
public AvatarDto(){

}
    public Long getRegno() {
        return regno;
    }

    public void setRegno(Long regno) {
        this.regno = regno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<String> getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(List<String> filePaths) {
        this.filePaths = filePaths;
    }

    public List<byte[]> getFileContents() {
        return fileContents;
    }

    public void setFileContents(List<byte[]> fileContents) {
        this.fileContents = fileContents;
    }

    @Override
    public String toString() {
        return "AvatarDto{" +
                "regno=" + regno +
                ", email='" + email + '\'' +
                ", profile='" + profile + '\'' +
                ", filePaths=" + filePaths +
                ", fileContents=" + fileContents +
                '}';
    }
}
