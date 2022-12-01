package com.carrot.backend.notification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@RestController
public class SseController {

    @GetMapping(value="/sse" ,produces = "text/event-stream")
    public void publish(HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        for(int i = 1; i <= 10; i++) {
            writer.write("data: { \"message\" : \"number : "+ i + "\" }\n\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writer.close();
    }
}
