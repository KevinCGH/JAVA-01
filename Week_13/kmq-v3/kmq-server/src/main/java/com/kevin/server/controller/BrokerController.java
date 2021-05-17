package com.kevin.server.controller;

import com.kevin.server.service.ConsumerService;
import com.kevin.server.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/broker/v1")
@Validated
public class BrokerController {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/test")
    public String test() {
        return "Producer Endpoint was ready.";
    }

    @PostMapping("/write")
    public ResponseEntity writeMessage(@Valid @RequestBody RequestWrite request) {
        return ResponseEntity.ok(producerService.messageEnqueue(request.getTopic(), request.getContent()));
    }

//    @GetMapping("/read")
//    public ResponseEntity readMessage(@Valid @RequestParam @NotNull(message = "需要指定 topic") String topic,
//                                      @Valid @RequestParam @Min(value = 0, message = "offset 必须大于等于0") Integer offset) {
//        return ResponseEntity.ok(consumerService.messageDequeue(topic, offset));
//    }

    @GetMapping("/read")
    public ResponseEntity readMessage(@Valid RequestRead requestRead) {
        return ResponseEntity.ok(consumerService.messageDequeue(requestRead.getTopic(), requestRead.getOffset()));
    }
}
