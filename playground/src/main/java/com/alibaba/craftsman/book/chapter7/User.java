package com.alibaba.craftsman.book.chapter7;

import java.util.Map;

/**
 * User
 *
 * @author Frank Zhang
 * @date 2019-05-11 20:22
 */
public class User {
    private Map<String, Role> roles;

    public Role getRole(String scenario){
        return roles.get(scenario);
    }

}
