package com.oniesoft.dto;


import java.util.List;

public class AvatarDto {
    private Long regno;
    private String empId;
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

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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
                ", empId='" + empId + '\'' +
                ", profile='" + profile + '\'' +
                ", filePaths=" + filePaths +
                ", fileContents=" + fileContents +
                '}';
    }
}
