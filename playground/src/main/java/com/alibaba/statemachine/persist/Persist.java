package com.alibaba.statemachine.persist;

/**
 * Persist
 *
 * @author Frank Zhang
 * @date 2020-01-02 22:22
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler.PersistStateChangeListener;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import com.alibaba.statemachine.persist.Application.Order;

public class Persist {

    private final PersistStateMachineHandler handler;

    //tag::snippetA[]
    @Autowired
    private JdbcTemplate jdbcTemplate;
//end::snippetA[]

    private final PersistStateChangeListener listener = new LocalPersistStateChangeListener();

    public Persist(PersistStateMachineHandler handler) {
        this.handler = handler;
        this.handler.addPersistStateChangeListener(listener);
    }

    public String listDbEntries() {
        List<Order> orders = jdbcTemplate.query(
                "select id, state from orders",
                new RowMapper<Order>() {
                    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Order(rs.getInt("id"), rs.getString("state"));
                    }
                });
        StringBuilder buf = new StringBuilder();
        for (Order order : orders) {
            buf.append(order);
            buf.append("\n");
        }
        return buf.toString();
    }

    //tag::snippetB[]
    public void change(int order, String event) {
        Order o = jdbcTemplate.queryForObject("select id, state from orders where id = ?", new Object[] { order },
                new RowMapper<Order>() {
                    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Order(rs.getInt("id"), rs.getString("state"));
                    }
                });
        handler.handleEventWithState(MessageBuilder
                .withPayload(event).setHeader("order", order).build(), o.state);
    }

    //end::snippetB[]

    //tag::snippetC[]
    private class LocalPersistStateChangeListener implements PersistStateChangeListener {

        @Override
        public void onPersist(State<String, String> state, Message<String> message,
                              Transition<String, String> transition, StateMachine<String, String> stateMachine) {
            if (message != null && message.getHeaders().containsKey("order")) {
                Integer order = message.getHeaders().get("order", Integer.class);
                jdbcTemplate.update("update orders set state = ? where id = ?", state.getId(), order);
            }
        }
    }
//end::snippetC[]

}
