package com.pm.notificationservice.model;

import java.time.Instant;

public class NotificationRecord {
  private String id;
  private String patientId;
  private String recipientName;
  private String recipientEmail;
  private String subject;
  private String content;
  private String status;
  private Instant timestamp;

  public NotificationRecord() {
    this.timestamp = Instant.now();
  }

  public NotificationRecord(String id, String patientId, String recipientName, String recipientEmail, String subject, String content, String status) {
    this.id = id;
    this.patientId = patientId;
    this.recipientName = recipientName;
    this.recipientEmail = recipientEmail;
    this.subject = subject;
    this.content = content;
    this.status = status;
    this.timestamp = Instant.now();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public String getRecipientName() {
    return recipientName;
  }

  public void setRecipientName(String recipientName) {
    this.recipientName = recipientName;
  }

  public String getRecipientEmail() {
    return recipientEmail;
  }

  public void setRecipientEmail(String recipientEmail) {
    this.recipientEmail = recipientEmail;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }
}
