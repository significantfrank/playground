package com.alibaba.statemachine.persist;

/**
 * StateMachineCommands
 *
 * @author Frank Zhang
 * @date 2020-01-02 22:25
 */
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

@Component
public class StateMachineCommands extends AbstractStateMachineCommands<String, String> {

    @CliCommand(value = "sm event", help = "Sends an event to a state machine")
    public String event(@CliOption(key = { "", "event" }, mandatory = true, help = "The event") final String event) {
        getStateMachine()
                .sendEvent(MessageBuilder
                        .withPayload(event).build());
        return "Event " + event + " send";
    }
}
