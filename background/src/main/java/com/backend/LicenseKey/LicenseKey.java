package com.backend.LicenseKey;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "license_key")
public class LicenseKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "key_value")
    private String keyValue;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public LicenseKey() {
    }

    public LicenseKey(Long id, String keyValue, LocalDateTime createdAt) {
        this.id = id;
        this.keyValue = keyValue;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "LicenseKeyEntity{" +
                "id=" + id +
                ", keyValue='" + keyValue + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}



