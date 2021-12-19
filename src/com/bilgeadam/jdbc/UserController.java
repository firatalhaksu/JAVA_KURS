package com.bilgeadam.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserController {
    public void addUser(Long ID, String name){
        String sql = "INSERT INTO public.\"Users\" (\"ID\", \"Name\", \"Surname\") values(?, ?, ?)";

        try(Connection conn = Connector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, ID);
            statement.setString(2, name.substring(0, name.lastIndexOf("\s")));
            statement.setString(3, name.substring(name.lastIndexOf("\s")));

            statement.execute();


        } catch (SQLException e) {
            System.out.println("There is a problem with Database!");
        }
    }
}
