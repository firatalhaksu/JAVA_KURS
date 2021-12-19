package com.bilgeadam.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserController {
    public void addUser(Long ID, String name){
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

           return statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("There is a problem with Database!");
            return 0L;
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
            return null;
            //return Collections.emptySet();                            //BOŞ LİSTE döndürmek istersek...
        }
    }

    public User getUsers(long ID){                                 //ID ile spesifik arama...
        String sql = "SELECT * FROM public.\"Users\" WHERE ID=?";

        try(Connection conn = Connector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, ID);

            ResultSet results = statement.executeQuery();
            return convertToUsers(results).stream().findFirst().orElse(null);

        } catch (SQLException e) {
            System.out.println("There is a problem with Database!");
            return null;
            //return Collections.emptySet();                            //BOŞ LİSTE döndürmek istersek...
        }
    }

    private Set<User> convertToUsers(ResultSet results) throws SQLException {

        Set<User> users = new HashSet<>();
        while (results.next()){
            users.add(new User(results.getLong("ID"),
                            results.getString("Name"),
                            results.getString("Surname")));
        }

        return users;
    }
}
