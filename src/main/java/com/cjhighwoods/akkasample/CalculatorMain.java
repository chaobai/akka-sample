package com.cjhighwoods.akkasample;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorSystem;

public class CalculatorMain {

    public static void main(String[] args) {
        
        System.out.println("Starting calculator system");
        
        ActorSystem system = ActorSystem.create("CalculatorSystem", ConfigFactory.load(("calculator")));
        
        System.out.println("Listening calculation request...");
    }
}