package com.devnips.mockitojunit5.service.notification;

import org.springframework.stereotype.Service;

/**
 * This service will publish events to message brokers like RabbitMQ etc.
 */
@Service
public class NotificationService {

    /**
     * Publish an event to the message broker
     *
     * @param event
     */
    public void publish(Event event) {
        // logic here to write to message broker
    }
}
