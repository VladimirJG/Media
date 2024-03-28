package ru.danilov.rabbitMQ.publications.rabbit_publications;

import com.example.new_publications.model.Publication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.danilov.rabbitMQ.publications.config.QueueConfigProperties;

@Service
public class RabbitProducer {

    private final RabbitTemplate rabbitTemplate;
    private final QueueConfigProperties properties;

    public RabbitProducer(RabbitTemplate rabbitTemplate, QueueConfigProperties properties) {
        this.rabbitTemplate = rabbitTemplate;
        this.properties = properties;
    }

    public void send(String message) {
        rabbitTemplate.convertAndSend(properties.getExchange(), properties.getRoutingKey(), message);
    }

    public Publication createNewPublication(Publication publication) {
        return publication;
    }
}
