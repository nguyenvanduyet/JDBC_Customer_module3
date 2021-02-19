package com.module3.service;

import com.module3.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
    Connection getConnection (){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/customermanager",
                    "root",
                    "tk110817"
            );
        } catch (ClassNotFoundException e) {
            System.out.println("không có thư viện");
        } catch (SQLException throwables) {
            System.out.println("không có kết nối");
        }
        System.out.println("kết nối thành công");
        return connection;
    }
    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement p = connection.prepareStatement("select * from customer");
            ResultSet resultSet = p.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id,name,address);
                customers.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer save(int id, Customer customer) {
        Connection connection = getConnection();
        try {
            PreparedStatement p = connection.prepareStatement("insert into customer values (id,name,address)values(?,?,?)");
            p.setInt(1,id);
            p.setString(2,customer.getName());
            p.setString(3,customer.getAddress());
            p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer edit(int id, Customer customer) {
        Connection connection =getConnection();
        try {
            PreparedStatement p = connection.prepareStatement("update customer set name =?, address=? where id =?");
            p.setInt(3,id);
            p.setString(1, customer.getName());
            p.setString(2,customer.getAddress());
            p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return customer;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        Connection connection = getConnection();
        try {
            PreparedStatement p = connection.prepareStatement("select * from customer where id =?");
            p.setInt(1, id);
            ResultSet resultSet = p.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                customer = new Customer(id, name, address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }
    public List<Customer> findName(String name) {
        List<Customer> customers = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement p = connection.prepareStatement("select * from customer where name like ");
            p.setString(1,"%"+name+"%");
            ResultSet resultSet = p.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String address = resultSet.getString("address");
                customers.add(new Customer(id,name,address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }

    @Override
    public void delete(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement p = connection.prepareStatement("delete * from customer where id=?");
            p.setInt(1,id);
            p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}