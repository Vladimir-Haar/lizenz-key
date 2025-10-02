package com.backend.entitysql;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class KeyTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "key_value")
    private String key_value;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    public KeyTest() {
    }

    public KeyTest(Long id, String key_value, LocalDateTime created_at) {
        this.id = id;
        this.key_value = key_value;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey_value() {
        return key_value;
    }

    public void setKey_value(String key_value) {
        this.key_value = key_value;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "KeyTest{" +
                "id=" + id +
                ", key_value='" + key_value + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}



