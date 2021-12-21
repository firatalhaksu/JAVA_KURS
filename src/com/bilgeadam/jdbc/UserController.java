package com.bilgeadam.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserController {
    public boolean updateUsers(long ID,String name, String surname){
        String sql = "UPDATE public.\"Users\" SET \"Name\"=?, \"Surname\"=? WHERE \"ID\"=?";
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setLong(3, ID);

            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("There is a problem with Database!");
            return false;
        }
    }
    public void addUser(long ID, String name){
        //UUID.randomUUID();
        String sql = "INSERT INTO public.\"Users\" (\"ID\", \"Name\", \"Surname\") values(?, ?, ?)";
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, ID);
            statement.setString(2, name.substring(0, name.lastIndexOf("\s")));
            statement.setString(3, name.substring(name.lastIndexOf("\s") + 1));

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("There is a problem with Database!");
        }
    }

    public long deleteUsers(){
        String sql = "DELETE FROM public.\"Users\"";
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);

           return statement.executeLargeUpdate();
        } catch (SQLException e) {
            System.out.println("There is a problem with Database!");
            return 0L;
        }
    }

    public boolean deleteUsers(long ID){
        String sql = "DELETE FROM public.\"Users\" WHERE \"ID\"=?";
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, ID);

            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("There is a problem with Database!");
            return false;
        }
    }

    public Set<User> getUsers(){
        String sql = "SELECT * FROM public.\"Users\"";
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet results = statement.executeQuery();
            return convertToUsers(results);
        } catch (SQLException e) {
            System.out.println("There is a problem with Database!");
            return Collections.emptySet();                            //BOŞ LİSTE döndürmek istersek...
        }
    }

    public User getUser(long ID){                                 //ID ile spesifik arama...
        String sql = "SELECT * FROM public.\"Users\" WHERE \"ID\"=?";
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, ID);

            ResultSet results = statement.executeQuery();
            return convertToUsers(results).stream().findFirst().orElse(null);
        } catch (SQLException e) {
            System.out.println("There is a problem with Database!");
            return null;
        }
    }

    private Set<User> convertToUsers(ResultSet results) throws SQLException {
        Set<User> users = new HashSet<>();
        while (results.next())
            users.add(new User(results.getLong("ID"),
                            results.getString("Name"),
                            results.getString("Surname")));
        return users;
    }
}