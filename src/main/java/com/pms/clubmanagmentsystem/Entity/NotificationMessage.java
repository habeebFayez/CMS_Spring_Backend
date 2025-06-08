package com.pms.clubmanagmentsystem.Entity;

import javax.persistence.*;
import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;

@Entity
@Table(name = "NotificationMessage")
public class NotificationMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationMessageID;
    private String recipientToken;
    private String title;
    private String body;
    private String image;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "notification_data", joinColumns = @JoinColumn(name = "notification_message_id"))
    @MapKeyColumn(name = "data_key")
    @Column(name = "data_value")
    private Map<String, String> data;

    public Long getNotificationMessageID() {
        return notificationMessageID;
    }

    public void setNotificationMessageID(Long notificationMessageID) {
        this.notificationMessageID = notificationMessageID;
    }

    public String getRecipientToken() {
        return recipientToken;
    }

    public void setRecipientToken(String recipientToken) {
        this.recipientToken = recipientToken;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
