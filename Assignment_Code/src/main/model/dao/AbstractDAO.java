package dao;

import entity.AbstractEntity;
import entity.Player;

import java.sql.*;
import java.util.List;

public abstract class AbstractDAO<E extends AbstractEntity> {
    protected String ConUrl = "jdbc:mysql://localhost";
    protected String Port = "3306";
    protected String Database = "soccer_club";
    protected String Username = "root";
    protected String Password = "password123";

    public Connection getConnection() throws SQLException{
        String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
                +"&password="+Password;
        Connection con = DriverManager.getConnection(url);
        return con;
    }

    public void setTestDatabase(){
        this.Database = "soccer_club_test";
    }

    public abstract void create(E entity) throws SQLException;

    public abstract void create(Player entity) throws SQLException;

    public abstract E read(int id) throws SQLException;
    public abstract void update(E entity) throws SQLException;
    public abstract void delete(E entity) throws SQLException;

    public abstract List<E> list() throws SQLException;

}