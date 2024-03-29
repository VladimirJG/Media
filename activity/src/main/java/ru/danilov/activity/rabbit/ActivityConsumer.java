package ru.danilov.activity.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ActivityConsumer {
    private static final Logger logger = LoggerFactory.getLogger(ActivityConsumer.class);

    @RabbitListener(queues = {"newPublications", "newSubscriptionQueue"})
    public void processMessagePublication(String message) {
        logger.info("Received from Publication: {}", message);
    }
}
