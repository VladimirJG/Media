package ru.danilov.notifications.service;

import com.example.new_publications.model.Publication;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.danilov.notifications.dto.NotifyPublicationDto;
import ru.danilov.notifications.rabbit.NotificationsConsumer;

@Service
public class NotificationService {
    private final NotificationsConsumer notificationsConsumer;
    private final ModelMapper modelMapper;

    public NotificationService(NotificationsConsumer notificationsConsumer, ModelMapper modelMapper) {
        this.notificationsConsumer = notificationsConsumer;
        this.modelMapper = modelMapper;
    }

    public void sendNotificationToUser() {
        Publication publicationForSendToUser = notificationsConsumer.getPublicationForSendToUser();
        NotifyPublicationDto notifyPublicationDto = modelMapper.map(publicationForSendToUser, NotifyPublicationDto.class);
        //send to user
    }
}
