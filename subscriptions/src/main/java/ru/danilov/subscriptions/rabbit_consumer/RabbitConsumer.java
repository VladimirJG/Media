package ru.danilov.subscriptions.rabbit_consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitConsumer.class);
    @RabbitListener(queues = "newPublications")
    public void processMessage(String message) {
        logger.info("Received from Publication: {}", message);
    }
}
