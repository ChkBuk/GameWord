package com.camel.micro.camelmicroservicesa.router.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaSenderRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
//        from("timer:active-mq-timer?period=1000")
//        .transform().constant("My message for Active MQ")
//        .log("${body}")
//        .to("activemq:my-activemq-queue");
//    	from("file:files/json")
//        .log("${body}")
//        .to("activemq:my-activemq-queue");
//       
    	
    	from("file:files/json")
        .log("${body}")
        .to("kafka:myKafkaTopic");
       
    }
    
}
