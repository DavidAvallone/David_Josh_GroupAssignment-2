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
);