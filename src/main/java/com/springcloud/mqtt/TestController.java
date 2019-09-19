package com.springcloud.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${spring.mqtt.default.topic}")
    private String defaultTopic;
    @Autowired
    private MqttGateway mqttGateway;

    @GetMapping("/send/{data}")
    public String sendMqtt(@PathVariable("data") String sendData) {
        mqttGateway.sendToMqtt(sendData, defaultTopic);
        return "OK";
    }
}