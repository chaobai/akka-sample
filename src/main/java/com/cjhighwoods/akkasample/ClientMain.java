package com.cjhighwoods.akkasample;

import java.util.stream.IntStream;

import com.cjhighwoods.akkasample.Messages.Add;
import com.cjhighwoods.akkasample.Messages.Multiply;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class ClientMain {
    public static void main(String[] args) {
        System.out.println("Starting calculator client");
        ActorSystem system = ActorSystem.create("ClientSystem", ConfigFactory.load(("client")));
        ActorRef client = system.actorOf(Props.create(Client.class), "client");
        
        IntStream.range(1, 10).forEach(i -> {
            client.tell(new Add(i,i+1), ActorRef.noSender());
            client.tell(new Multiply(i,i+2), ActorRef.noSender());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
