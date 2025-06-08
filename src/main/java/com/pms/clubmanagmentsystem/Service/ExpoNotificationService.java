package com.pms.clubmanagmentsystem.Service;

import com.pms.clubmanagmentsystem.Entity.NotificationMessage;
import com.pms.clubmanagmentsystem.Entity.User;
import com.pms.clubmanagmentsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

/**
 * Service class responsible for managing Expo push notifications.
 * This class communicates with the Expo Push Notification API to send
 * notifications and manages Expo push tokens within the system.
 */
@Service
public class ExpoNotificationService {
    @Autowired
    private UserRepository userRepository;
    private static final String EXPO_API_URL = "https://exp.host/--/api/v2/push/send";
    private final WebClient webClient = WebClient.create();

    public String sendExpoPushNotification(NotificationMessage message) {
        Map<String, Object> requestBody = Map.of(
                "to", message.getRecipientToken(),
                "title", message.getTitle(),
                "body", message.getBody(),
                "sound", "default", // Add sound
                "vibrate", new int[]{100, 200, 100}, // Vibrate pattern [ms]
                "mutableContent", true,
                "attachments",  List.of(Map.of("url", message.getImage())),
                "data", message.getData() != null ? message.getData() : Map.of()
        );

        return webClient.post()
                .uri(EXPO_API_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
    public boolean clearToken(User authUser) {
        try {
            User user = userRepository.getById(authUser.getUserID());
                user.setExpoPushToken(null);
                userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}