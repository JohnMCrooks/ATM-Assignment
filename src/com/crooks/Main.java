package com.crooks;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, Double> accounts = new HashMap<String, Double>();
    static Scanner scanner = new Scanner(System.in);
    static boolean logout = false;
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to the Bank of Yesterday\n");

        Account a1 = new Account();

        a1.login();

    }
}
