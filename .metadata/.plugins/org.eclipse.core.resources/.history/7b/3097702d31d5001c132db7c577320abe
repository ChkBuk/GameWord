package com.camel.micro.camelmicroservicesa.router.b;

import java.util.Map;

import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyFileRouter extends RouteBuilder{

	
	@Autowired
	DeciderBean deciderBean;
    @Override
    public void configure() throws Exception {
        from("file:files/input")
        .routeId("Files-Input-Route")
        .transform().body(String.class)
        .choice()
          	.when(simple("${file:ext} == 'xml'"))  //"${file:ext} ends with 'xml'"
          	    .log("XML File")
          	//.when(simple("${body} contains 'USD'"))  // before we  need to transform body to String
          	   .when(method(deciderBean))
          	    .log("Not a XML File, but contain USD")
          	.otherwise()
          	 .log("Not a XML File")
          	 .end()
         // .to("direct://log-file-values")
        .to("file:files/output");
        
        
        // Reusable End point
//        from("direct:log-file-values")
//        .log("${messageHistory} ${file:absolute.path} ") // gives the whole flow
//        .log("${file:name}  ${file:name.ext}   ${file:name.noext}")
//        .log("${file:onlyname.noext} ${file:parent}  ${file:path}  ${file:absolute} ")
//        .log("${file:size} ${file:modified} ")
//        .log("${routeId} ${camelId}  ${body}");
    }
    
}

@Component
class DeciderBean{
	
	Logger logger = LoggerFactory.getLogger(DeciderBean.class);
	
	public boolean isThisConditionMet(String body, @Headers Map<String,String> headers, @ExchangeProperties Map<String,String> exchangeProperties) {
		logger.info("{} {} {}", body, headers, exchangeProperties);
		return true;
	}
}
