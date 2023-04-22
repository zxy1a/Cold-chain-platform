package com.coldeye.coldnetty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public boolean send(String topic,String message){
        try {
            kafkaTemplate.send(topic, message);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return  true;
    }

}
