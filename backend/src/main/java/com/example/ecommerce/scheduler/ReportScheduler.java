package com.example.ecommerce.scheduler;

import com.example.ecommerce.model.ReportSetting;
import com.example.ecommerce.repository.ReportSettingRepository;
import com.example.ecommerce.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ReportScheduler {

    @Autowired
    private ReportSettingRepository reportSettingRepository;

    @Autowired
    private EmailService emailService;

    // Example: every day at 9 AM
    @Scheduled(cron = "0 0 9 * * ?")
    public void sendReports(){
        List<ReportSetting> settings = reportSettingRepository.findAll();
        for(ReportSetting rs : settings){
            String subject = "Your Scheduled Report";
            String body = "Hello, this is your " + rs.getFrequency() + " report!";
            emailService.sendEmail(rs.getEmail(), subject, body);
        }
    }
}
