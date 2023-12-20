package org.example;

import org.example.container.Global;

public class Main {
    public static void main(String[] args) {
        Global.initScanner();
        new App().run();
        Global.exitScanner();
        }
    }
