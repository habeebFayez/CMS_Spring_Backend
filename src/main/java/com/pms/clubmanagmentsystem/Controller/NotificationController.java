package com.pms.clubmanagmentsystem.Controller;

import com.pms.clubmanagmentsystem.Entity.NotificationMessage;
import com.pms.clubmanagmentsystem.Entity.User;
import com.pms.clubmanagmentsystem.Service.ExpoNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing operations related to notifications.
 * Provides endpoints for sending notifications and clearing tokens.
 */
@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    private final ExpoNotificationService notificationService;

    @Autowired
    public NotificationController(ExpoNotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<?> sendNotification(@RequestBody NotificationMessage message) {
        try {
            String result = notificationService.sendExpoPushNotification(message);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
    @PutMapping("/clear-token")
    public ResponseEntity<?> clearToken(@AuthenticationPrincipal User authUser) {
        boolean deleteUserToken = notificationService.clearToken(authUser);

        return deleteUserToken
                ? ResponseEntity.status(HttpStatus.OK).build()
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}