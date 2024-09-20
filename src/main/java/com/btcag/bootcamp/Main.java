package com.btcag.bootcamp;

import java.util.Scanner;

public class Main {

    private static final int ROWS = 15; // Spielfeldgröße
    private static final int COLS = 10;

    private static int robotRows = 0; // Roboterposition
    private static int robotCols = 0;

    public static void main(String[] args) {
        welcomeScreen();



        Scanner scanner = new Scanner(System.in);

        System.out.println("Was ist dein Name Krieger:");
        String playerName = scanner.nextLine();

        System.out.println("\n");

        System.out.println("Hallo tapferer " + playerName + "! Bereit für die Schlacht?");

        System.out.println("\n");

        System.out.println("Was ist der Name deiner Kampfmaschine:");
        String robotName = scanner.nextLine();

        System.out.println("\n");

        System.out.println(robotName + " wird erschaffen!");

        System.out.println("\n");

        System.out.println("Nun auf in die Schlacht:");
        field(robotRows, robotCols, robotName);

        System.out.println("\nFahre durch die Schlacht");
        while (true) {
            System.out.println("Wohin willst du fahren? w,s,a,d,q");
            char move = scanner.nextLine().charAt(0);

            if (move == 'q') {
                System.out.println("Spiel wird beendet");
                break;
            }

            movement(move);
            field(robotRows, robotCols, robotName);
        }


    }

    public static void welcomeScreen() {
        System.out.println(
                "================================\n" +
                        "         Willkommen bei         \n" +
                        "            ROBOWARS            \n" +
                        "================================\n" +

                        " __,_,\n" +
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

    public static void field(int robotRows, int robotCols, String robotName) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (i == robotRows && j == robotCols) {
                    System.out.print("[" + robotName.charAt(0) + "]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }



    }

    public static void movement(char direction) {
        switch (direction) {
            case 'w':
                if (robotRows > 0) {
                    robotRows--;
                }
                break;
            case 's':
                if (robotRows < ROWS -1) {
                    robotRows++;
                }
                break;
            case 'a':
                if (robotCols > 0) {
                    robotCols--;
                }
                break;
            case 'd':
                if (robotCols < COLS -1) {
                    robotCols++;
                }
                break;
            default:
                System.out.println("Ungültige Eingabe");
        }
    }

    public static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}