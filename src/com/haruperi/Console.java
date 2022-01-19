package com.haruperi;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        System.out.println(prompt);
        while (true) {
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                 break;
                System.out.println("Enter a Value Between "+min+ " and "+max);
        }
        return value;
    }
}
