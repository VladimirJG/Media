package ru.danilov.notifications.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NotifyPublicationDto {
    private String name;
    private String description;
    private String userName;
    private String email;
    private String telephone;
}
