package com.anisse_bouainbi.tutorial.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore additional fields when converting from JSON
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // AUTO INCREMENT
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age; 
}
