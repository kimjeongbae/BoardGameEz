package org.example.container;


import org.example.board.Board;
import org.example.db.DBConnection;
import org.example.user.User;

import java.time.LocalDate;
import java.util.Scanner;


public class Global {
    private static Scanner scanner;
    private static User logineUser;

    private static DBConnection dbConnection;

    public static DBConnection getDBConnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }

        return dbConnection;
    }

    public static void initScanner () {
        scanner = new Scanner(System.in);
    }

    public static void exitScanner () {
        scanner.close();
    }

    public static Scanner getScanner () {
        return scanner;
    }

    public static User getLogineUser () {
        return logineUser;
    }

    public static void setLogineUser (User user) {
        logineUser = user;
    }

    public static String nowDateTime () {
        String now = LocalDate.now().toString();
        return  now;
    }



}
