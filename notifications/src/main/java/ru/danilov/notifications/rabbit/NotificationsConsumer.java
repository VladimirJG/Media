package ru.danilov.notifications.rabbit;

import com.example.new_publications.model.Publication;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationsConsumer {
    private static final Logger logger = LoggerFactory.getLogger(NotificationsConsumer.class);
    private final ObjectMapper objectMapper;
    private Publication publicationForSendToUser;

    @Autowired
    public NotificationsConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @RabbitListener(queues = "newSubscriptionQueue")
    public void processMessage(String message) {
        logger.info("Received from Publication: {}", message);
        publicationForSendToUser = objectMapper.readValue(message, Publication.class);
    }

    public Publication getPublicationForSendToUser() {
        return publicationForSendToUser;
    }
}
