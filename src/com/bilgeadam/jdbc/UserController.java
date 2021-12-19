package com.bilgeadam.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class UserController {
    public void addUser(Long ID, String name){
        String sql = "INSERT INTO public.\"Users\" (\"ID\", \"Name\", \"Surname\") values(?, ?, ?)";

        try(Connection conn = Connector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, ID);
            statement.setString(2, name.substring(0, name.lastIndexOf("\s")));
            statement.setString(3, name.substring(name.lastIndexOf("\s")));

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("There is a problem with Database!");
        }
    }

    public Set<User> getUser(){
        String sql = "SELECT * FROM public.\"Users\"";

        try(Connection conn = Connector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet result = statement.executeQuery();
            return convertToUsers(result);

        } catch (SQLException e) {
            System.out.println("There is a problem with Database!");
            return null;
        }
    }

    private Set<User> convertToUsers(ResultSet result){
        return null;
    }
}
