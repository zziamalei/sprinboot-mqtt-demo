package com.springcloud.mqtt;

import lombok.Data;

@Data
class SendParam {
    private String topic;

    private String data;

}