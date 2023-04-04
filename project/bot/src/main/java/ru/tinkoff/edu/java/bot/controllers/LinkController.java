package ru.tinkoff.edu.java.bot.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.java.bot.dto.LinkUpdate;
import ru.tinkoff.edu.java.bot.service.UpdateService;

@RestController
public class LinkController {

    private UpdateService updateService;

    public LinkController(UpdateService updateService) {
        this.updateService = updateService;
    }

    @PostMapping(value = "updates")
    public void sendUpdate(@RequestBody LinkUpdate request){
        updateService.updateLink(request);
    }
}
