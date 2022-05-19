package com.camel.micro.camelmicroservicesb.routes;

import java.math.BigDecimal;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.camel.micro.camelmicroservicesb.CurrencyExchange;
@Component
public class ActiveMQReceiverRouter extends RouteBuilder{


	@Autowired
	MyCurrencyExchangeTransformer myCurrencyExchangeTransformer;
	
    @Override
    public void configure() throws Exception {
       from("activemq:my-activemq-queue")
       .log("${body}")
      .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class  )
      .bean(myCurrencyExchangeTransformer)
       .to("log:received-message-from-active-mq");
    	  
    }
    
}

@Component
class MyCurrencyExchangeTransformer{
	Logger logger =LoggerFactory.getLogger(MyCurrencyExchangeTransformer.class);
	public CurrencyExchange processmessage(CurrencyExchange currencyExchange) {
		logger.info(" Exchange multiple value :: "+currencyExchange.getConversionMultiple());
		currencyExchange.setConversionMultiple(currencyExchange.getConversionMultiple().multiply(BigDecimal.valueOf(1.2)));
		return currencyExchange;
	}
}
