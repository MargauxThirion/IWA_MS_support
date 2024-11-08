package com.example.ms_support.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "support_questions")
@Access(AccessType.FIELD)
public class SupportQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;

    @Column(nullable = false)
    private Integer userId;

    @Column(length = 100, nullable = false)
    private String subject;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(length = 100, nullable = false)
    private String status = "open";

    // Getters and Setters
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
