package ru.danilov.subscriptions.rabbit;

import com.example.new_publications.model.Publication;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionConsumer {
    private static final Logger logger = LoggerFactory.getLogger(SubscriptionConsumer.class);
    private final ObjectMapper objectMapper;
    private Publication publication;

    public SubscriptionConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @RabbitListener(queues = "newPublications")
    public void processMessage(String message) {
        logger.info("Received from Publication: {}", message);
        this.publication = objectMapper.readValue(message, Publication.class);
    }

    public Publication getReceivedPublication() {
        return publication;
    }
}
