package dao;

import entity.AbstractEntity;
import entity.Player;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class PlayerDao extends AbstractDAO<Player>{

    @Override
    public void create(Player entity) throws SQLException {
        String sql="INSERT INTO player(player_height, player_weight,player_name,player_nationality,player_dob,main_position,player_salary) VALUES(?,?,?,?,?,?,?)";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setDouble(1,entity.getPlayer_height() );
        pst.setDouble(2, entity.getPlayer_weight() );
        pst.setString(3, entity.getPlayer_name() );
        pst.setString(4, entity.getPlayer_nationality() );
        pst.setDate(5, entity.getPlayer_dob() );
        pst.setString(6, entity.getMain_position() );
        pst.setDouble(7, entity.getPlayer_salary());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()){
            entity.setId_player(rs.getInt(1));
        }
        con.close();
    }

    @Override
    public Player read(int id) throws SQLException {
        String sql="SELECT * FROM player WHERE id_player = ?";;
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,id);
        ResultSet rs = pst.executeQuery();
        Player p = null;
        if(rs.next()){
            p = new Player();
            p.setId_player(rs.getInt("id_player"));
            p.setPlayer_dob(rs.getDate("player_dob"));
            p.setPlayer_name(rs.getString("player_name"));
            p.setPlayer_height(rs.getDouble("player_height"));
            p.setPlayer_weight(rs.getDouble("player_weight"));
            p.setPlayer_nationality(rs.getString("player_nationality"));
            p.setPlayer_salary(rs.getDouble("player_salary"));
            p.setMain_position(rs.getString("main_position"));
        }
        con.close();
        return p;
    }

    @Override
    public void update(Player entity) throws SQLException {
        Connection con = getConnection();
        String sql = "UPDATE player SET player_dob = ?, player_name = ?,player_height = ?, player_weight = ?," +
                " player_nationality = ?, player_salary = ?, main_position = ? WHERE id_player = ?";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setDate(1, new java.sql.Date(entity.getPlayer_dob().getTime()));
        pst.setString(2, entity.getPlayer_name());
        pst.setDouble(3, entity.getPlayer_height());
        pst.setDouble(4, entity.getPlayer_weight());
        pst.setString(5, entity.getPlayer_nationality());
        pst.setDouble(6, entity.getPlayer_salary());
        pst.setString(7, entity.getMain_position());
        pst.setInt(8, entity.getId_player());

        pst.executeUpdate();
        con.close();
    }

    @Override
    public void delete(Player entity) throws SQLException {
        String sql = "DELETE FROM player WHERE id_player = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, entity.getId_player() );
        pst.executeUpdate();
        con.close();
    }

    @Override
    public List<Player> list() throws SQLException {
        List<Player> lstPlayer = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM player ORDER BY player_name";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Player p = new Player();
            p.setId_player(rs.getInt("id_player"));
            p.setPlayer_dob(rs.getDate("player_dob"));
            p.setPlayer_name(rs.getString("player_name"));
            p.setPlayer_height(rs.getDouble("player_height"));
            p.setPlayer_weight(rs.getDouble("player_weight"));
            p.setPlayer_nationality(rs.getString("player_nationality"));
            p.setPlayer_salary(rs.getDouble("player_salary"));
            p.setMain_position(rs.getString("main_position"));
            lstPlayer.add(p);
        }
        con.close();
        return lstPlayer;
    }
}
