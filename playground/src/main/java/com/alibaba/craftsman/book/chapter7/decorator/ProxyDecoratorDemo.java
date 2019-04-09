package com.alibaba.craftsman.book.chapter7.decorator;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * ProxyDecoratorDemo
 *
 * @author Frank Zhang
 * @date 2019-02-01 6:01 PM
 */
public class ProxyDecoratorDemo {
    public static void main(String[] args) throws SQLException{
        Connection connection = new ConnectionDecorator(new ConnectionProxy(new ConnectionImpl()));
        connection.close();
    }
}
