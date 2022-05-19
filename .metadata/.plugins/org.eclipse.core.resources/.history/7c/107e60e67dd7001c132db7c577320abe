package com.camel.micro.camelmicroservicesa.router.pattern;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EipPatternsRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
    	
    	// Pipeline
    	//Content  based routing - choice()
    	//Multicast
//        from("timer:multicast?period=10000")
//        .multicast()
//        .to("log:something1", "log:something2", "log:something3");
//        
        from("file:files/csv")
        .convertBodyTo(String.class)
        //.unmarshal().csv()  // to get output line by line
        .split(body(),",")
        .to("activemq:split-queue");
    }
    
}
