package com.alibaba.statemachine;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.guard.Guard;

import java.util.EnumSet;

/**
 * SpringSample
 *
 * @author Frank Zhang
 * @date 2020-01-02 11:54
 */
public class SpringSample {
    static enum States {
        STATE1, STATE2
    }

    static enum Events {
        EVENT1, EVENT2
    }

    public static StateMachine<States, Events> buildMachine() throws Exception {
        StateMachineBuilder.Builder<States, Events> builder = StateMachineBuilder.builder();

        builder.configureStates()
                .withStates()
                .initial(States.STATE2)
                .states(EnumSet.allOf(States.class));

        Object bizContext = new Object();

        builder.configureTransitions()
                .withExternal()
                    .source(States.STATE1)
                    .target(States.STATE2)
                    .guard(guard(bizContext))
                    .action((ctx)-> System.out.println("Enter into Sate2: " + ctx.getEvent()))
                    .event(Events.EVENT1)
                    .and()
                .withExternal()
                    .source(States.STATE2).target(States.STATE1)
                    .action(transitAction())
                    .event(Events.EVENT2);

        return builder.build();
    }

    public static Guard<States, Events> guard(Object bizContext){
        return context -> {
                System.out.println("Enter into guard: " + context.getEvent()+" "+bizContext);
                return true;
        };
    }

    public static Action<States, Events> transitAction(){
        return new Action<States, Events>() {
            @Override
            public void execute(StateContext<States, Events> context) {
                System.out.println("SourceId : " + context.getSource().getId().toString());
                System.out.println("TargetId : " + context.getTarget().getId().toString());
            }
        };
    }

    public static void main(String[] args) throws Exception{
        StateMachine<States, Events> stateMachine = buildMachine();
        stateMachine.start();
        stateMachine.sendEvent(Events.EVENT1);
        System.out.println("Current state after Event1: " + stateMachine.getState());
        stateMachine.sendEvent(Events.EVENT2);
        System.out.println("Current state after Event2: " + stateMachine.getState());
    }
}
