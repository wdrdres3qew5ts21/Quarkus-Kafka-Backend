package com.yutani.service;

import java.time.Duration;
import java.util.Random;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.reactivestreams.Publisher;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.annotations.Broadcast;

@ApplicationScoped
public class AlienEventService {

    long count = 0;

    Random random = new Random();

    Logger logger = Logger.getLogger(AlienEventService.class.getName());

    @Outgoing("alien_event")
    @Broadcast
    public Multi<Integer> process() {
        int nextInt = random.nextInt(100);
        Multi<Integer> randomInteger = Multi.createFrom().ticks().every(Duration.ofSeconds(5)).onOverflow().drop()
                .map(tick -> random.nextInt(100));
        return randomInteger;
    }


    @Incoming("alien_event") 
    @Outgoing("convert_stream")
    @Broadcast
    @Acknowledgment(Acknowledgment.Strategy.PRE_PROCESSING)
    public String convertAlientPlan(Integer incomingNumber) {
        logger.info("convertAlientPlan : " + incomingNumber);
        count++;
        String yutaniStamp = "Yutani Z56 ["+incomingNumber+"]";
        return yutaniStamp;
    }

}
