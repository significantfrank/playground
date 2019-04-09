package com.alibaba.craftsman.book.chapter4;

import com.alibaba.cola.event.EventBusI;
import com.alibaba.cola.exception.BizException;
import com.alibaba.craftsman.entity.Customer;
import com.alibaba.craftsman.entity.CustomerAddedEvent;
import lombok.Data;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * GoodFunction
 *
 * @author Frank Zhang
 * @date 2019-01-13 3:21 PM
 */
public class GoodFunction {
    PooledConnection connectionPool;
    EventBusI eventBus;

    public void addCustomer(Customer customer) throws SQLException {
        //1、参数校验
        if(customer.getName() == null){
            throw new IllegalArgumentException("Customer name must not be null");
        }
        if(customer.getEmail() == null){
            throw new IllegalArgumentException("Customer email must not be null");
        }

        //2、处理业务和入库
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = connectionPool.getConnection();
            Customer dbCustomer = queryCustomerByEmail(customer.getEmail());
            if(dbCustomer != null){
                throw new BizException("Customer with same email has already existed");
            }
            if(customer.isDomestic()){
                dbCustomer = queryCustomerByCellPhone(customer.getEmail());
                if(dbCustomer != null){
                    throw new BizException("Domestic Customer with same cell phone number has already existed");
                }
            }
            ps = c.prepareStatement("insert into customer values(?,?,?,?)");
            ps.setString(1, customer.getName());
            ps.setInt(2, customer.getAge());
            ps.setString(3, customer.getCellPhone());
            ps.setString(4, customer.getEmail());
            ps.execute();
            c.commit();
        }
        catch (SQLException ex){
            c.rollback();
            throw ex;
        }
        finally {
            try{
                c.close();
                if(ps != null){
                    ps.close();
                }
                if(rs != null){
                    rs.close();
                }
            }
            catch(SQLException ignored){
            }
        }

        //3、发送消息通知
        eventBus.fire(new CustomerAddedEvent(customer));
    }

    private Customer queryCustomerByCellPhone(String email) {
        return new Customer();
    }

    private Customer queryCustomerByEmail(String email) {
        return new Customer();
    }

    public void addCustomerIterateOne(Customer customer) throws SQLException{
        Map db = setupDBInfrastructure();
        try {
            checkConflict(customer);

            insertDB(customer, db);
        }
        catch (SQLException ex){
            rollbackTransactionFor(db);
        }
        finally {
            cleanUp(db);
        }

        sendMessage(customer);
    }

    private void sendMessage(Customer customer){
        eventBus.fire(new CustomerAddedEvent(customer));
    }

    private void cleanUp(Map db){
        Connection c = (Connection)db.get("connection");
        PreparedStatement ps = (PreparedStatement)db.get("preparedStatement");
        try{
            if (c != null){
                c.close();
            }
            if(ps != null){
                ps.close();
            }
        }
        catch(SQLException ignored){
        }
    }

    private void rollbackTransactionFor(Map db) throws SQLException{
        ((Connection)db.get("connection")).rollback();
    }

    private void checkConflict(Customer customer) {
        Customer dbCustomer = queryCustomerByEmail(customer.getEmail());
        if(dbCustomer != null){
            throw new BizException("Customer with same email has already existed");
        }
        if(customer.isDomestic()){
            dbCustomer = queryCustomerByCellPhone(customer.getEmail());
            if(dbCustomer != null){
                throw new BizException("Domestic Customer with same cell phone number has already existed");
            }
        }
    }

   private void insertDB(Customer customer, Map db) throws SQLException{
       Connection c = (Connection)db.get("connection");
       PreparedStatement ps = (PreparedStatement)db.get("preparedStatement");
       ps.setString(1, customer.getName());
       ps.setInt(2, customer.getAge());
       ps.setString(3, customer.getCellPhone());
       ps.setString(4, customer.getEmail());
       ps.execute();
       c.commit();
   }

   private Map setupDBInfrastructure() throws SQLException {
      Connection c = connectionPool.getConnection();
      PreparedStatement ps = c.prepareStatement("insert into customer values(?,?,?,?)");
      Map db = new HashMap();
      db.put("connection", c);
      db.put("preparedStatement", ps);
      return db;
   }

    public static void main(String[] args) {
        Connection connection = null;
    }
}
