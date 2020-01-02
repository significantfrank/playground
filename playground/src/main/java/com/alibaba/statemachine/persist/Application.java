package com.alibaba.statemachine.persist;

/**
 * Application
 *
 * @author Frank Zhang
 * @date 2020-01-02 22:19
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.Bootstrap;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;

@SpringBootApplication
public class Application  {

    //tag::snippetA[]
    @Configuration
    @EnableStateMachine
    static class StateMachineConfig
            extends StateMachineConfigurerAdapter<String, String> {

        @Override
        public void configure(StateMachineStateConfigurer<String, String> states)
                throws Exception {
            states
                    .withStates()
                    .initial("PLACED")
                    .state("PROCESSING")
                    .state("SENT")
                    .state("DELIVERED");
        }

        @Override
        public void configure(StateMachineTransitionConfigurer<String, String> transitions)
                throws Exception {
            transitions
                    .withExternal()
                    .source("PLACED").target("PROCESSING")
                    .event("PROCESS")
                    .and()
                    .withExternal()
                    .source("PROCESSING").target("SENT")
                    .event("SEND")
                    .and()
                    .withExternal()
                    .source("SENT").target("DELIVERED")
                    .event("DELIVER");
        }

    }
//end::snippetA[]

    //tag::snippetB[]
    @Configuration
    static class PersistHandlerConfig {

        @Autowired
        private StateMachine<String, String> stateMachine;

        @Bean
        public Persist persist() {
            return new Persist(persistStateMachineHandler());
        }

        @Bean
        public PersistStateMachineHandler persistStateMachineHandler() {
            return new PersistStateMachineHandler(stateMachine);
        }

    }
//end::snippetB[]

    //tag::snippetC[]
    public static class Order {
        int id;
        String state;

        public Order(int id, String state) {
            this.id = id;
            this.state = state;
        }

        @Override
        public String toString() {
            return "Order [id=" + id + ", state=" + state + "]";
        }

    }
//end::snippetC[]

    public static void main(String[] args) throws Exception {
        Bootstrap.main(args);
    }

}
