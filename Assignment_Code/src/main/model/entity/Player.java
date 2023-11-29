package entity;

/*
create table player(
    id_player int auto_increment not null,
    player_name VARCHAR(255),
    player_nationality VARCHAR(255),
    player_height double,
    player_weight double,
    player_dob date,
    player_salary double,
    main_position VARCHAR(255),
    constraint id_player_pk primary key(id_player)
)
 */

import java.sql.Date;

public class Player extends AbstractEntity{

    private int id_player;
    private double player_height;

    private double player_weight;
    private String player_name;
    private String player_nationality;
    private java.sql.Date player_dob;
    private String main_position;
    private double player_salary;

    public Player(){
    }

    public int getId_player() {
        return id_player;
    }

    public void setId_player(int id_player) {
        this.id_player = id_player;
    }

    public double getPlayer_height() {
        return player_height;
    }

    public void setPlayer_height(double player_height) {
        this.player_height = player_height;
    }

    public double getPlayer_weight() {
        return player_weight;
    }

    public void setPlayer_weight(double player_weight) {
        this.player_weight = player_weight;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_nationality() {
        return player_nationality;
    }

    public void setPlayer_nationality(String player_nationality) {
        this.player_nationality = player_nationality;
    }

    public Date getPlayer_dob() {
        return player_dob;
    }

    public void setPlayer_dob(Date player_dob) {
        this.player_dob = player_dob;
    }

    public String getMain_position() {
        return main_position;
    }

    public void setMain_position(String main_position) {
        this.main_position = main_position;
    }

    public double getPlayer_salary() {
        return player_salary;
    }

    public void setPlayer_salary(double player_salary) {
        this.player_salary = player_salary;
    }
}