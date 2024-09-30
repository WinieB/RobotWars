package com.btcag.bootcamp;

import java.util.Random;
import java.util.Scanner;

public class RoboWars {

    private static final int ROWS = 10; // Spielfeldgröße
    private static final int COLS = 15;

    private static final int staticRoboRow = 5;
    private static final int staticRoboCol = 7;

    private static int robotRows = 0; // Roboterposition
    private static int robotCols = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        welcomeScreen();

        System.out.println("Was ist dein Name Krieger:");
        String playerName = scanner.nextLine();
        System.out.println("Hallo tapferer " + playerName + "! Bereit für die Schlacht?");
        System.out.println("Was ist der Name deiner Kampfmaschine:");
        String robotName = scanner.nextLine();
        System.out.println(robotName + " wird erschaffen!");


        System.out.println("\nWas ist der Name vom statischen Roboter:");
        String staticRobotName = scanner.nextLine();
        System.out.println(staticRobotName + " wird erschaffen!");

        System.out.println("Nun auf in die Schlacht:");
        field(robotRows, robotCols, robotName, staticRoboRow, staticRoboCol, staticRobotName);

        System.out.println("\nFahre durch die Schlacht:");
        game(scanner, robotName, staticRobotName);


    }

    public static void welcomeScreen() {
        System.out.println(
                "================================\n" +
                        "         Willkommen bei         \n" +
                        "            ROBOWARS            \n" +
                        "================================\n" +
                        "  ,__,_,\n" +
                        "  [_|_/ \n" +
                        "   //\n" +
                        " _//    __\n" +
                        "(_|)   |@@|\n" +
                        " \\ \\__ \\--/ __\n" +
                        "  \\o__|----|  |   __\n" +
                        "      \\ }{ /\\ )_ / _\\\n" +
                        "      /\\__/\\ \\__O (__\n" +
                        "     (--/\\--)    \\__/\n" +
                        "     _)(  )(_\n" +
                        "    `---''---`\n" +
                        "================================\n" +
                        "      Bereit für den Kampf?     \n" +
                        "================================\n");
    }

    public static void game(Scanner scanner, String robotName, String staticRobotName) {
        while (true) { // true damit es immer weiterläuft, bis break uns rauswirft
            System.out.println("Wohin willst du fahren? w (hoch), s (runter), a (links), d (rechts), b (zum beenden)");
            char move = scanner.nextLine().charAt(0); // einlesen was gedrückt wurde

            if (move == 'b') { // wenn b gedrückt wird, wird die While-Schleife verlassen und das Spiel beendet
                System.out.println("Tschüss und bis bald!");
                break;
            }

            movement(move); // das movement von der Eingabe (w, s, a, d) wird in Movement berechnet und wiedergegeben

            if (robotRows == staticRoboRow && robotCols == staticRoboCol) {
                fight(robotName, staticRobotName);
                break;
            }

            System.out.println("\n");
            field(robotRows, robotCols, robotName, staticRoboRow, staticRoboCol, staticRobotName); // Das Spielfeld wird mit der neuen Position vom Roboter erstellt
        }

    }

    public static void field(int robotRows, int robotCols, String robotName, int staticRobotRow, int staticRobotCol, String staticRobotName) {
        for (int i = 0; i < ROWS; i++) { // Reihen auf 15 hochzählen
            for (int j = 0; j < COLS; j++) { // Spalte auf 10 hochzählen
                if (i == robotRows && j == robotCols) { // wenn der Roboter mit Rows und Cols übereinstimmt, wird [X] gedruckt, weil da der Roboter ist
                    System.out.print("[" + robotName.charAt(0) + "]");
                } else if (i == staticRoboRow && j == staticRoboCol) { // wenn die Position vom Roboter nicht übereinstimmt, wird [ ] gedruckt
                    System.out.print("[" + staticRobotName.charAt(0) + "]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println(); // wenn die Spalte fertig ist println, damit die nächste Reihe anfängt
        }


    }

    public static void movement(char direction) {
        switch (direction) { // switch als lesbare if- else Blöcke
            case 'w': // Tasteneingabe
                if (robotRows > 0) { // Roboterposition verändern
                    robotRows--;
                }
                break; // rausgehen, damit es nur einmal passiert
            case 's':
                if (robotRows < ROWS - 1) {
                    robotRows++;
                }
                break;
            case 'a':
                if (robotCols > 0) {
                    robotCols--;
                }
                break;
            case 'd':
                if (robotCols < COLS - 1) {
                    robotCols++;
                }
                break;
            default: // wenn keine Eingabe stimmt
                System.out.println("Ungültige Eingabe");
        }
    }

    public static void fight(String robotName, String staticRobotName) {
        System.out.println("KAMPF VON " + robotName + " UND " + staticRobotName + " BEGINNT!");

        int sumRobotPos = robotRows + robotCols;
        int sumStaticRobotPos = staticRoboRow + staticRoboCol;

        if (sumRobotPos % 2 == 0) {
            System.out.println(robotName + " hat gewonnen!");
        } else {
            System.out.println(staticRobotName + " hat gewonnen!");
        }

    }

    // ------------------------------------- nicht in use Methoden -------------------------------
    public static void fightHard(String robot1Name, String staticRobotName) {
        System.out.println("\nKAMPF BEGINNT zwischen " + robot1Name + " und " + staticRobotName + "!");

        // Simuliert die Vorbereitungsphase mit einigen Zeilen für den Kampf
        System.out.println(robot1Name + " erhebt seine Waffen...");
        System.out.println(staticRobotName + " aktiviert seine Schilde...");
        System.out.println("Beide Roboter sind bereit! Der Kampf startet in 3... 2... 1...");

        // Zeitverzögerung zur Steigerung der Spannung (optional)
        try {
            Thread.sleep(2000); // 2 Sekunden warten
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Verwende Random um den Gewinner zu bestimmen
        Random random = new Random();
        int result = random.nextInt(2); // Gibt entweder 0 oder 1 zurück

        if (result == 0) {
            System.out.println(robot1Name + " setzt einen vernichtenden Schlag und gewinnt den Kampf!");
        } else {
            System.out.println(staticRobotName + " kontert geschickt und gewinnt den Kampf!");
        }

        // Endnachricht für den Kampf
        System.out.println("Der Kampf ist vorbei. Der Gewinner ist gekrönt!");
    } // nicht in use weil kein Timer und kein Random

    public static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    } // nicht in use weil kein Timer

    public static void timer(int seconds) { // kann nun mit timer(5) z.B. 5 Sekunden warten
        try {
            Thread.sleep(seconds * 1000); // seconds wird mal 1000 gerechnet damit sekunden rauskommen

        } catch (InterruptedException e) { // um den Fehler zu behandeln
            System.out.println("Timer Fehler");
        }
    } // nicht in use weil kein Timer

}