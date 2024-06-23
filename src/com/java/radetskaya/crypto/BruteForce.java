package com.java.radetskaya.crypto;

import java.util.Scanner;

public class BruteForce {



    public static void bruteforce() {
        char[] input;
        int key;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть текст для розкодування: ");
        String ip = sc.nextLine();
        input = ip.toCharArray();
        for (key = 1; key < 32; key++) {
            for (int i = 0; i < input.length; i++) {
                if (input[i] == ' ')
                    continue;
                else {
                    if (input[i] >= 'А' && input[i] <= 'Я') {
                        input[i] = (char) (input[i] - key);
                        if (input[i] < 'А') {
                            input[i] = (char) (input[i] + 32);
                        }
                    } else {
                        input[i] = (char) (input[i] - key);
                        if (input[i] < 'а') {
                            input[i] = (char) (input[i] + 32);
                        }
                    }
                }

            }
            System.out.println("Key =  " + key + " Розшифрований рядок: " + String.valueOf(input));
            input = ip.toCharArray();
        }
    }
}
