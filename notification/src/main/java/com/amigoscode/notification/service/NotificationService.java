package com.amigoscode.notification.service;

import com.amigoscode.clients.dto.NotificationRequest;
import com.amigoscode.notification.model.Notification;
import com.amigoscode.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.getToCustomerId())
                        .toCustomerEmail(notificationRequest.getToCustomerEmail())
                        .message(notificationRequest.getMessage())
                        .sender("Amigoscode")
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
