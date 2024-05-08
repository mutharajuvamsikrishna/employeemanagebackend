package com.oniesoft.serviceimpl;


import com.oniesoft.dto.AdminRegisterDto;
import com.oniesoft.model.AdminRegister;
import com.oniesoft.repository.AdminRegisterRepo;
import com.oniesoft.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    PasswordEncoder passwordEncoder;
@Autowired
    AdminRegisterRepo adminRegisterRepo;
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${adminemail}")
  private   String email;
    @Value("${defaultpassword}")
    private String password;
    @Value("${loginUrl}")
    private String loginUrl;
    private HashMap<String, AdminRegisterDto> userMap = new HashMap<>();
    @Override
    public String sendEmail(String receipent, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(receipent);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
        return "otp Sent Sucessfully";
    }
    @Override
    public String generateOTP() {
        // Generate a random 6-digit OTP
        int otp = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(otp);
    }

    @Override
    public AdminRegister saveRegdetails(@RequestBody AdminRegisterDto adminRegisterDto) {
           AdminRegisterDto adminRegisterDto1 =  getAdminregister(adminRegisterDto.getMob());
  if(adminRegisterDto1!=null) {

      if (adminRegisterDto.getOtp().equals(adminRegisterDto1.getOtp())) {
          AdminRegister adminRegister = new AdminRegister();
          adminRegister.setName(adminRegisterDto1.getName());
          adminRegister.setMob(adminRegisterDto1.getMob());
          adminRegister.setEmail(adminRegisterDto1.getEmail());
          adminRegister.setPassword(passwordEncoder.encode(adminRegisterDto1.getPassword()));
          adminRegister.setRoles(adminRegisterDto1.getRoles());
          AdminRegister adminRegister1 = adminRegisterRepo.save(adminRegister);
          removeAdminRegister(adminRegisterDto1.getMob());

          String subject="ONiE Soft ";
          String body="";
          String adminSubject="";
          String adminBody="";
          sendEmail(adminRegister.getEmail(),subject,body);
          sendEmail(email,adminSubject,adminBody);
          return adminRegister1;
      }
  }
        return null;
    }
    @Override
    public void setUserDetails(AdminRegisterDto adminRegister) {
        userMap.put(adminRegister.getMob(), adminRegister);
    }

    public AdminRegisterDto getAdminregister(String mob) {
        return userMap.get(mob);
    }
    @Override
    public List<AdminRegister> getAdminRegisters() {
        return adminRegisterRepo.findAll();
    }
    @Override
    public void removeAdminRegister(String mob){
        userMap.remove(mob);
    }

    @Override
    public AdminRegister getRegister(String empId) {
        return adminRegisterRepo.findByEmpId(empId);
    }

    @Override
    public AdminRegister addEmployeeByAdmin(AdminRegister adminRegister) {
        if(adminRegister.getEmpId()!=null){
            String userSubject = adminRegister.getName()+" Welcome to Onie Soft1.";
            String userBody ="Dear " + adminRegister.getName() + ",\n" +
                    "Hartley welcome to Onie Soft family.\n" +
                    "Thank you for trusting Onie Soft principles, policies and joining us today.\n\n" +
                    "These are your details ...\n" +
                    "Name: " + adminRegister.getName() + "\n" +
                    "Designation: " + adminRegister.getDesignation()+ "\n" +
                    "CTC: " + adminRegister.getCtc() + " LPA\n\n" +
                    "New Bee Portal Link: " + loginUrl + "\n" +
                    "Employee ID / Login ID: " + adminRegister.getEmpId()+ "\n" +
                    "Default Password: " + password + "\n\n" +
                    "Please ensure to change the password on first login.\n\n" +
                    "We wish you all the success and great learning in this new journey at Onie Soft.\n\n" +
                    "With Best Wishes,\n" +
                    "HR Team\n" +
                    "Onie Soft Pvt Ltd.";;
            sendEmail(adminRegister.getPersonalEmail(), userSubject, userBody);
            String adminSubject=adminRegister.getName()+" Joined";;
            sendEmail(email,adminSubject,userBody);
            adminRegisterRepo.save(adminRegister);
            return  adminRegister;
        }
        adminRegister.setPassword(passwordEncoder.encode(password));
        AdminRegister adminRegister1= adminRegisterRepo.save(adminRegister);
        String userSubject = adminRegister.getName()+" Welcome to Onie Soft.";
             adminRegister1.setEmpId("E-"+adminRegister1.getId());
             String empId=adminRegister1.getEmpId();
             adminRegisterRepo.save(adminRegister1);
        String userBody ="Dear " + adminRegister.getName() + ",\n" +
                "Hartley welcome to Onie Soft family.\n" +
                "Thank you for trusting Onie Soft principles, policies and joining us today.\n\n" +
                "These are your details ...\n" +
                "Name: " + adminRegister.getName() + "\n" +
                "Designation: " + adminRegister.getDesignation()+ "\n" +
                "CTC: " + adminRegister.getCtc() + " LPA\n\n" +
                "New Bee Portal Link: " + loginUrl + "\n" +
                "Employee ID / Login ID: " + empId+ "\n" +
                "Default Password: " + password + "\n\n" +
                "Please ensure to change the password on first login.\n\n" +
                "We wish you all the success and great learning in this new journey at Onie Soft.\n\n" +
                "With Best Wishes,\n" +
                "HR Team\n" +
                "Onie Soft Pvt Ltd.";;
        sendEmail(adminRegister.getPersonalEmail(), userSubject, userBody);
        String adminSubject=adminRegister.getName()+" Joined";;
        sendEmail(email,adminSubject,userBody);
       return  adminRegister1;
    }
}
