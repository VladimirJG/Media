package ru.danilov.subscriptions.config;


import lombok.Getter;
import lombok.Setter;

/**
 * Класс для конфигурационных параметров очереди
 */
@Getter
@Setter
public class QueueConfigProperties {
    private String exchange;
    private String routingKey;
    private String queue;
}
