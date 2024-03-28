package ru.danilov.rabbitMQ.publications.controller;

import com.example.new_publications.model.Publication;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danilov.rabbitMQ.publications.rabbit_publications.RabbitProducer;

@RestController
@RequestMapping("/rabbit")
public class PublicationController {
    private final RabbitProducer rabbitProducer;
    private final ObjectMapper objectMapper;

    @Autowired
    public PublicationController(RabbitProducer rabbitProducer, ObjectMapper objectMapper) {
        this.rabbitProducer = rabbitProducer;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @PostMapping()
    public Publication createNewPublication(@RequestBody Publication publication) {
        String stringPublication = objectMapper.writeValueAsString(publication);
        rabbitProducer.send(stringPublication);
        return rabbitProducer.createNewPublication(publication);
    }
}
