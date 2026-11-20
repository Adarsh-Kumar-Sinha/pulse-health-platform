package com.pm.notificationservice.service;

import com.pm.notificationservice.model.NotificationRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class NotificationService {

  private static final Logger log = LoggerFactory.getLogger(NotificationService.class);
  private final List<NotificationRecord> notifications = new CopyOnWriteArrayList<>();

  public NotificationRecord dispatchPatientWelcomeNotification(String patientId, String name, String email) {
    String subject = "Welcome to PulseHealth Platform";
    String content = String.format("Dear %s, your patient profile has been successfully registered in our clinical management system.", name);

    NotificationRecord record = new NotificationRecord(
        UUID.randomUUID().toString(),
        patientId,
        name,
        email,
        subject,
        content,
        "DELIVERED"
    );

    notifications.add(record);
    log.info("Simulated Notification Dispatched: [ID={}, To={}, Subject='{}']",
        record.getId(), email, subject);

    return record;
  }

  public List<NotificationRecord> getAllNotifications() {
    return Collections.unmodifiableList(new ArrayList<>(notifications));
  }

  public int getNotificationCount() {
    return notifications.size();
  }
}
