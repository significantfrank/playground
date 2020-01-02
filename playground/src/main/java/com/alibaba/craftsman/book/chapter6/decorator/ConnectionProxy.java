package com.alibaba.craftsman.book.chapter6.decorator;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * ConnectionProxy
 *
 * Proxy Pattern 代理模式
 *
 * @author Frank Zhang
 * @date 2019-02-01 5:59 PM
 */
public class ConnectionProxy extends ConnectionImpl {
    private Connection connection;

    public ConnectionProxy(Connection connection){
        this.connection = connection;
    }

    @Override
    public void close() throws SQLException {
        // Normal close: underlying connection is still open, so we
        // simply need to return this proxy to the pool

        // https://github.com/apache/commons-dbcp/blob/master/src/main/java/org/apache/commons/dbcp2/PoolableConnection.java

       // pool.returnObject(this);

        System.out.println("return to pool");
    }
}
