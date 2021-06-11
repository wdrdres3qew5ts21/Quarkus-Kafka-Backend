package com.yutani.controller;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import com.yutani.service.AlienEventService;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

@RequestScoped
@Path("api")
// @Produces({ MediaType.WILDCARD })
// @Consumes(MediaType.APPLICATION_JSON)
public class AlienEventController {

    Logger logger = Logger.getLogger(AlienEventController.class.getName());

    @Inject
    AlienEventService alienEventService;

    @Inject
    @Channel("convert_stream") Publisher<String> incoming; 

    @GET
    @Path("/stream/debug")
    @Incoming("convert_stream")
    // @Outgoing("yutani_plan_topic")
    @Produces(MediaType.SERVER_SENT_EVENTS) 
    @SseElementType("text/plain") 
    public String stream(String incoming) {
        logger.info("Debug SSE Income : " + incoming);
        return incoming;
    }

    @GET
    @Path("/stream")
    @Outgoing("yutani_plan_topic")
    @Produces(MediaType.SERVER_SENT_EVENTS) 
    @SseElementType(MediaType.SERVER_SENT_EVENTS)
    public Publisher<String>  stream() {
        logger.info("SSE Publisher : " + this.incoming);
        return this.incoming;
    }

}
