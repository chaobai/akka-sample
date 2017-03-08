package com.cjhighwoods.akkasample;

import com.cjhighwoods.akkasample.Messages.Add;
import com.cjhighwoods.akkasample.Messages.CalcResult;
import com.cjhighwoods.akkasample.Messages.Multiply;

import akka.actor.UntypedActor;

public class Calculator extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Add) {
            Add add = (Add) message;
            System.out.println(String.format("%s calculating %s ...", getSelf().path().name(), add));
            getSender().tell(new CalcResult(add, add.left + add.right), getSelf());
        } else if (message instanceof Multiply) {
            Multiply multiply = (Multiply) message;
            System.out.println(String.format("%s calculating %s ...", getSelf().path().name(), multiply));
            getSender().tell(new CalcResult(multiply, multiply.left * multiply.right), getSelf());
        }
    }
}
