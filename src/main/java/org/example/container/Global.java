package org.example.container;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
import java.util.Scanner;

public class Global {
    Scanner sc = new Scanner(System.in);

    public static void initScanner () {
        scanner = new Scanner(System.in);
    }

    public static void exitScanner () {
        scanner.close();
    }

    public static Scanner getScanner () {
        return scanner;
    }


}
