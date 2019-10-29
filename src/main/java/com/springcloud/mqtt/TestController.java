package com.springcloud.mqtt;

import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${spring.mqtt.default.topic}")
    private String defaultTopic;
    @Autowired
    private MqttGateway mqttGateway;

    @PostMapping("/send")
    public String sendMqtt(@RequestBody SendParam param) {
        mqttGateway.sendToMqtt(param.getData(), StringUtils.isEmpty(param.getTopic()) ? defaultTopic : param.getTopic());
        return "OK";
    }


}

