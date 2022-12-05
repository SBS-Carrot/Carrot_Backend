package com.carrot.backend.notification.controller;

import com.carrot.backend.notification.domain.Notification;
import com.carrot.backend.notification.service.NotificationService;
import com.carrot.backend.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequiredArgsConstructor
public class SseController {

    private final NotificationService notificationService;

    ExecutorService taskExecutor = Executors.newSingleThreadExecutor();
    @GetMapping(value="/sse")
    public SseEmitter publish() throws Exception {

        final SseEmitter emitter = new SseEmitter();
        taskExecutor.execute(() -> {
            try {
                emitter.send("test data ");
                emitter.complete();
            } catch (Exception e) {
                emitter.completeWithError(e);
            }
        });
        return emitter;
    }

    @PostMapping(value="/applyJobs")
    public Notification apply (@RequestBody UserDto userDto){
        return notificationService._applyJobs(userDto);
    }
}
