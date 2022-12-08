package com.carrot.backend.notification.controller;

import com.carrot.backend.notification.NotificationDto.NotificationDto;
import com.carrot.backend.notification.domain.Notification;
import com.carrot.backend.notification.service.NotificationService;
import com.carrot.backend.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequiredArgsConstructor
public class SseController {

    private final NotificationService notificationService;

    ExecutorService taskExecutor = Executors.newSingleThreadExecutor();
    @GetMapping(value="/sse/{userid}")
    public SseEmitter publish(@PathVariable String userid,
            @RequestHeader(value = "Last-Event-ID",required = false, defaultValue = "") String lastEventId) throws Exception {


        notificationService.subscribe(userid, lastEventId);
        SseEmitter emitter = new SseEmitter(60 * 1000L);
        List<NotificationDto> dto =  notificationService.findAllNotifications(userid);
        for(int i=0;i<=dto.size();i++){
            System.out.println("size : " + dto.size());

            emitter.send(SseEmitter.event().name("get").data(dto.get(i)));
        }


        return emitter;


    }

    @PostMapping(value="/applyJobs")
    public Notification apply (@RequestBody UserDto userDto){
    return null;
        //        return notificationService._applyJobs(userDto);
    }
}
