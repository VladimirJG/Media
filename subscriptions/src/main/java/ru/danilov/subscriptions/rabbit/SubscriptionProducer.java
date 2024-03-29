package ru.danilov.subscriptions.rabbit;

import com.example.new_publications.model.Publication;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.danilov.subscriptions.config.QueueConfigProperties;

@Service
public class SubscriptionProducer {
    private final RabbitTemplate rabbitTemplate;
    private final QueueConfigProperties properties;
    private final SubscriptionConsumer subscriptionConsumer;
    private final ObjectMapper objectMapper;

    public SubscriptionProducer(RabbitTemplate rabbitTemplate, QueueConfigProperties properties, SubscriptionConsumer subscriptionConsumer, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.properties = properties;
        this.subscriptionConsumer = subscriptionConsumer;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    public void send() {
        Publication receivedPublication = subscriptionConsumer.getReceivedPublication();
        String writtenValueAsString = objectMapper.writeValueAsString(receivedPublication);
        rabbitTemplate.convertAndSend(properties.getExchange(), properties.getRoutingKey(), writtenValueAsString);
    }
}
