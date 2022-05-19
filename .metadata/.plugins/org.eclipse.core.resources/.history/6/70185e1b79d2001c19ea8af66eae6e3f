package com.camel.micro.camelmicroservicesb.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
@Component
public class ActiveMQReceiverRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-queue")
        .log("Received......")
        .to("log:received-message-from-active-mq");
    }
    
}
