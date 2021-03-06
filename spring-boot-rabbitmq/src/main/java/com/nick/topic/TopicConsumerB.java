package com.nick.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by dreamcatchernick on 15/09/2017.
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "topicQueueB",durable = "true"),
                exchange = @Exchange(value = "testTopicExchange",type = ExchangeTypes.TOPIC),
                key = "*.topic.*" )
)
public class TopicConsumerB {
    @RabbitHandler
    public void consume(String message) {
        System.out.println("Topic Consumer B  : " + message);
    }
}
