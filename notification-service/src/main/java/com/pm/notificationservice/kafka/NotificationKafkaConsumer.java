package com.pm.notificationservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import com.pm.notificationservice.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class NotificationKafkaConsumer {

  private static final Logger log = LoggerFactory.getLogger(NotificationKafkaConsumer.class);
  private final NotificationService notificationService;

  public NotificationKafkaConsumer(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @KafkaListener(topics = "patient", groupId = "notification-service")
  public void consumePatientEvent(byte[] event) {
    try {
      PatientEvent patientEvent = PatientEvent.parseFrom(event);
      log.info("Notification Service received PatientEvent: PatientId={}, Name={}, Email={}",
          patientEvent.getPatientId(),
          patientEvent.getName(),
          patientEvent.getEmail());

      notificationService.dispatchPatientWelcomeNotification(
          patientEvent.getPatientId(),
          patientEvent.getName(),
          patientEvent.getEmail()
      );
    } catch (InvalidProtocolBufferException e) {
      log.error("Failed to deserialize PatientEvent in NotificationKafkaConsumer: {}", e.getMessage());
    }
  }
}
