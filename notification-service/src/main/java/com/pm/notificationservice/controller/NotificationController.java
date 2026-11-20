package com.pm.notificationservice.controller;

import com.pm.notificationservice.model.NotificationRecord;
import com.pm.notificationservice.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

  private final NotificationService notificationService;

  public NotificationController(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @GetMapping
  public ResponseEntity<List<NotificationRecord>> getNotifications() {
    return ResponseEntity.ok(notificationService.getAllNotifications());
  }

  @GetMapping("/status")
  public ResponseEntity<Map<String, Object>> getStatus() {
    Map<String, Object> status = new HashMap<>();
    status.put("service", "notification-service");
    status.put("status", "UP");
    status.put("dispatchedCount", notificationService.getNotificationCount());
    return ResponseEntity.ok(status);
  }
}
