package com.example.ecommerce.controller;

import com.example.ecommerce.model.ReportSetting;
import com.example.ecommerce.repository.ReportSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/report-settings")
public class ReportSettingController {

    @Autowired
    private ReportSettingRepository repository;

    @GetMapping
    public List<ReportSetting> getAll(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<ReportSetting> create(@RequestBody ReportSetting reportSetting){
        return ResponseEntity.ok(repository.save(reportSetting));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportSetting> update(@PathVariable Long id, @RequestBody ReportSetting rs){
        ReportSetting existing = repository.findById(id).orElseThrow();
        existing.setEmail(rs.getEmail());
        existing.setFrequency(rs.getFrequency());
        return ResponseEntity.ok(repository.save(existing));
    }
}
