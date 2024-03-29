package ru.danilov.subscriptions.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscriptionConfig {

    @Bean("subConfig")
    @ConfigurationProperties("subscription")
    public QueueConfigProperties configProperties() {
        return new QueueConfigProperties();
    }

    @Bean
    public Queue newPublications(@Qualifier("subConfig") QueueConfigProperties properties) {
        return new Queue(properties.getQueue());
    }

    @Bean
    public TopicExchange topicExchange(@Qualifier("subConfig") QueueConfigProperties properties) {
        return new TopicExchange(properties.getExchange());
    }

    @Bean
    public Binding publicationBinding(Queue queue, TopicExchange topicExchange, QueueConfigProperties properties) {
        return BindingBuilder.bind(queue).to(topicExchange).with(properties.getRoutingKey());
    }
}
