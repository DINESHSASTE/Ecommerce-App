package com.example.ecommerce.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "report_setting")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String frequency;
    private String email;
}
