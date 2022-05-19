package com.camel.micro.camelmicroservicesa.router.b;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFileRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("file:files/input")
        .routeId("Files-Input-Route")
        .transform().body(String.class)
        .choice()
          	.when(simple("${file:ext} == 'xml'"))  //"${file:ext} ends with 'xml'"
          	    .log("XML File")
          	.when(simple("${body} contains 'USD'"))  // before we  need to transform body to String
          	    .log("Not a XML File, but contain USD")
          	.otherwise()
          	 .log("Not a XML File")
          	 .end()
          .to("direct://log-file-values")
        .to("file:files/output");
        
        
        // Reusable End point
        from("direct:log-file-values")
        .log("${messageHistory} ${file:absolute.path} ") // gives the whole flow
        .log("${file:name}  ${file:name.ext}   ${file:name.noext}")
        .log("${file:onlyname.noext} ${file:parent}  ${file:path}  ${file:absolute} ")
        .log("${file:size} ${file:modified} ")
        .log("${routeId} ${camelId}  ${body}");
    }
    
}
