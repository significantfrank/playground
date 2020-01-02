package com.alibaba.statemachine;

/**
 * StateMachineController
 *
 * @author Frank Zhang
 * @date 2020-01-02 22:07
 */
import java.util.EnumSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.service.StateMachineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.statemachine.StateMachineConfig.Events;
import com.alibaba.statemachine.StateMachineConfig.States;


@Controller
public class StateMachineController {

    public final static String MACHINE_ID_1 = "datajpapersist1";
    public final static String MACHINE_ID_2 = "datajpapersist2";
    private final static String[] MACHINES = new String[] { MACHINE_ID_1, MACHINE_ID_2 };

    private final StateMachineLogListener listener = new StateMachineLogListener();
    private StateMachine<StateMachineConfig.States, StateMachineConfig.Events> currentStateMachine;

    @Autowired
    private StateMachineService<States, Events> stateMachineService;

    @Autowired
    private StateMachinePersist<States, Events, String> stateMachinePersist;

    @RequestMapping("/")
    public String home() {
        return "redirect:/state";
    }

    @RequestMapping("/state")
    public String feedAndGetStates(
            @RequestParam(value = "events", required = false) List<Events> events,
            @RequestParam(value = "machine", required = false, defaultValue = MACHINE_ID_1) String machine,
            Model model) throws Exception {
        StateMachine<States, Events> stateMachine = getStateMachine(machine);
//        if (events != null) {
//            for (Events event : events) {
//                stateMachine.sendEvent(null)
//                        .blockLast();
//            }
//        }
        StateMachineContext<States, Events> stateMachineContext = stateMachinePersist.read(machine);
        model.addAttribute("allMachines", MACHINES);
        model.addAttribute("machine", machine);
        model.addAttribute("allEvents", getEvents());
        model.addAttribute("messages", createMessages(listener.getMessages()));
        model.addAttribute("context", stateMachineContext != null ? stateMachineContext.toString() : "");
        return "states";
    }

    //tag::snippetA[]
    private synchronized StateMachine<States, Events> getStateMachine(String machineId) throws Exception {
        listener.resetMessages();
//        if (currentStateMachine == null) {
//            currentStateMachine = stateMachineService.acquireStateMachine(machineId);
//            currentStateMachine.addStateListener(listener);
//            currentStateMachine.startReactively().block();
//        } else if (!ObjectUtils.nullSafeEquals(currentStateMachine.getId(), machineId)) {
//            stateMachineService.releaseStateMachine(currentStateMachine.getId());
//            currentStateMachine.stopReactively().block();
//            currentStateMachine = stateMachineService.acquireStateMachine(machineId);
//            currentStateMachine.addStateListener(listener);
//            currentStateMachine.startReactively().block();
//        }
        return currentStateMachine;
    }
//end::snippetA[]

    private Events[] getEvents() {
        return EnumSet.allOf(Events.class).toArray(new Events[0]);
    }

    private String createMessages(List<String> messages) {
        StringBuilder buf = new StringBuilder();
        for (String message : messages) {
            buf.append(message);
            buf.append("\n");
        }
        return buf.toString();
    }
}
