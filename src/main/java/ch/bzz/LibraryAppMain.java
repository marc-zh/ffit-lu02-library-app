package ch.bzz;

import java.util.Scanner;

public class LibraryAppMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Willkommen zur LibraryApp!");
        System.out.println("Tippe 'help' für Befehle oder 'quit' zum Beenden.");

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("help")) {
                System.out.println("Verfügbare Befehle:");
                System.out.println("help - zeigt alle Befehle");
                System.out.println("quit - beendet das Programm");
            } else if (input.equals("quit")) {
                System.out.println("Programm wird beendet...");
                running = false;
            } else {
                System.out.println("Unbekannter Befehl: " + input);
            }
        }

        scanner.close();
    }
}
