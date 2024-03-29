package ru.danilov.subscriptions.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danilov.subscriptions.rabbit.SubscriptionProducer;

@RestController
public class SubscriptionController {
    private final SubscriptionProducer subscriptionProducer;
    Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

    @Autowired
    public SubscriptionController(SubscriptionProducer subscriptionProducer) {
        this.subscriptionProducer = subscriptionProducer;
    }

    @GetMapping("/sub")
    public void sendSub() {
        logger.info("logging send to Notification");
        subscriptionProducer.send();
    }
}
