package com.cjhighwoods.akkasample;

import com.cjhighwoods.akkasample.Messages.CalcResult;
import com.cjhighwoods.akkasample.Messages.Operation;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.FromConfig;

public class Client extends UntypedActor {

    private ActorRef calculatorRouter;
    
    @Override
    public void preStart() throws Exception {
        calculatorRouter =
                getContext().actorOf(FromConfig.getInstance().props(Props.create(Calculator.class)), "calculatorRouter");
        super.preStart();
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof CalcResult) {
            System.out.println("Receiving calc result from " + getSender().path().address().hostPort());
            System.out.println(message.toString());
        } else if (message instanceof Operation) {
            System.out.println("Sending calc request: " + message.toString());
            calculatorRouter.tell(message, self());
        } else {
            unhandled(message);
        }
    }

}
