package com.yutani.controller;

import java.util.HashMap;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RouteBase;
import io.quarkus.vertx.web.RoutingExchange;
import io.smallrye.mutiny.Multi;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.yutani.service.AlienEventService;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

@RequestScoped
@Path("api")
@Produces({MediaType.WILDCARD})
@Consumes(MediaType.APPLICATION_JSON)
public class AlienEventController {

    @Inject
    AlienEventService alienEventService;

    @GET
    @Path("/stream")
    @Incoming("convert_stream")
    @Outgoing("yutani_plan_topic")
    public String stream(String incoming) { 
        return incoming;
        
    }


}
