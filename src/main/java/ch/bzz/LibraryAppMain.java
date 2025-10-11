package ch.bzz;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.sql.DriverManager;

public class LibraryAppMain {

    public static String[] commands = {"quit", "help", "listBooks, importBooks"};
    public static ArrayList<Book> books = new ArrayList<>();
    public static final String DELIMITER = "\t";

    public static void main(String[] args) throws SQLException, IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");
        properties.load(fis);
        String dbUrl = properties.getProperty("DB_URL");
        String dbUser = properties.getProperty("DB_USER");
        String dbPassword = properties.getProperty("DB_PASSWORD");
        try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            try (Statement stmt = con.createStatement()) {
                try (ResultSet resultSet = stmt.executeQuery("SELECT id, isbn, title, author, publication_year FROM books")) {
                    while (resultSet.next()) {
                        books.add(new Book(
                                resultSet.getString("id"),
                                resultSet.getString("isbn"),
                                resultSet.getString("title"),
                                resultSet.getString("author"),
                                resultSet.getString("publication_year")
                        ));
                    }
                }
            }

        }
        books.add(new Book("1", "978-3-8362-9544-4", "Java ist auch eine Insel", "Christian Ullenboom", "2023"));
        books.add(new Book("2", "978-3-658-43573-8", "Grundkurs Java", "Dietmar Abts", "2024"));
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {

            System.out.println("Enter command:");

            String command = sc.nextLine();
            System.out.println(command);

            if (!Arrays.asList(commands).contains(command)) {
                System.out.println("Unknown command: " + command + " Type 'help' for a list of commands.");
            } else if (Objects.equals(command, "quit")) {
                running = false;
            } else if (Objects.equals(command, "help")) {
                System.out.println("Available commands:");
                System.out.println("\tquit \thelp");
            }
            else if (Objects.equals(command, "listBooks")) {
                for (Book book : books) {
                    System.out.println(book);
                }
            }
            else if (Objects.equals(command, "importBooks")) {
                String path = command.replace("importBooks ", "");
                List<List<String>> records = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] values = line.split(DELIMITER);
                        records.add(Arrays.asList(values));
                    }
                }
                records.forEach(record -> {
                    System.out.println(record.getFirst());
                });

            }

        }


    }

}
