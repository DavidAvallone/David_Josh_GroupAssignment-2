import dao.PlayerDao;
import entity.Player;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
public class CLI {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PlayerDao dao = new PlayerDao();


    public CLI(){

    }
    public void run_program(){
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create");
            System.out.println("2. Read All");
            System.out.println("3. Read by ID");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            try {
                switch (choice) {
                    case 1:
                        createPlayer();
                        break;
                    case 2:
                        readAllPlayers();
                        break;
                    case 3:
                        readPlayerById();
                        break;
                    case 4:
                        updatePlayer();
                        break;
                    case 5:
                        deletePlayer();
                        break;
                    case 6:
                        System.out.println("Exiting the program. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (SQLException | ParseException e) {
                e.printStackTrace();
                System.out.println("An error occurred while performing the operation. Please try again.");
            }
        }
    }

    private static void createPlayer() throws SQLException, ParseException {
        System.out.println("Enter player details:");

        Player player = new Player();
        System.out.print("Name: ");
        player.setPlayer_name(scanner.nextLine());


        System.out.print("Date of Birth (MM-dd-yyyy): ");
        String dobString = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        dateFormat.setLenient(false);
        java.util.Date utilDate = dateFormat.parse(dobString);
        java.sql.Date dob = new java.sql.Date(utilDate.getTime());
        player.setPlayer_dob(dob);

        System.out.print("Height: ");
        player.setPlayer_height(scanner.nextDouble());

        System.out.print("Weight: ");
        player.setPlayer_weight(scanner.nextDouble());

        scanner.nextLine(); // Consume the newline character

        System.out.print("Nationality: ");
        player.setPlayer_nationality(scanner.nextLine());

        System.out.print("Main Position: ");
        player.setMain_position(scanner.nextLine());

        System.out.print("Salary: ");
        player.setPlayer_salary(scanner.nextDouble());

        dao.create(player);
        System.out.println("Player created successfully.");
    }

    private static void readAllPlayers() throws SQLException {
        List<Player> players = dao.list();
        System.out.println("All Players:");
        for (Player player : players) {
            System.out.println(player);
        }
    }

    private static void readPlayerById() throws SQLException {
        System.out.print("Enter player ID: ");
        int playerId = scanner.nextInt();
        Player player = dao.read(playerId);
        if (player != null) {
            System.out.println("Player details:\n" + player);
        } else {
            System.out.println("Player not found with ID: " + playerId);
        }
    }

    private static void updatePlayer() throws SQLException, ParseException {
        System.out.print("Enter player ID to update: ");
        int playerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Player existingPlayer = dao.read(playerId);
        if (existingPlayer != null) {
            System.out.println("Enter new player details:");

            System.out.print("Name: ");
            existingPlayer.setPlayer_name(scanner.nextLine());

            System.out.print("Date of Birth (MM-dd-yyyy): ");
            String dobString = scanner.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            dateFormat.setLenient(false);
            java.util.Date utilDate = dateFormat.parse(dobString);
            java.sql.Date dob = new java.sql.Date(utilDate.getTime());
            existingPlayer.setPlayer_dob(dob);

            System.out.print("Height: ");
            existingPlayer.setPlayer_height(scanner.nextDouble());

            System.out.print("Weight: ");
            existingPlayer.setPlayer_weight(scanner.nextDouble());

            scanner.nextLine(); // Consume the newline character

            System.out.print("Nationality: ");
            existingPlayer.setPlayer_nationality(scanner.nextLine());

            System.out.print("Main Position: ");
            existingPlayer.setMain_position(scanner.nextLine());

            System.out.print("Salary: ");
            existingPlayer.setPlayer_salary(scanner.nextDouble());

            dao.update(existingPlayer);
            System.out.println("Player updated successfully.");
        } else {
            System.out.println("Player not found with ID: " + playerId);
        }
    }

    private static void deletePlayer() throws SQLException {
        System.out.print("Enter player ID to delete: ");
        int playerId = scanner.nextInt();
        dao.delete(dao.read(playerId));

    }
}

