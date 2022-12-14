package com.amigoscode.clients.notification;

import com.amigoscode.clients.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationClient {

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
