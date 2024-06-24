package com.java.radetskaya.crypto;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Decrypt {


    public static void decrypt()
    {
        char[] input;
        int key;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть шлях до файлу, де є текст для розшифрування: ");

        String ip = sc.nextLine();



        List<String> arrayList = new ArrayList<>();
        String string = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ip))) {


            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringBuilder stringBuilder = new StringBuilder(line);
                StringBuilder stringBuilderCopy = new StringBuilder(line);
                String stringReverse = stringBuilder.toString();
                string = stringBuilderCopy.toString();
                if (stringReverse.equals(string)) {
                    arrayList.add(string);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        input = string.toCharArray();

        System.out.println("Строки в массив символов: " + Arrays.toString(input));



        System.out.println("Введіть ключ: ");
        key = sc.nextInt();
        for (int i = 0; i < input.length; i++)
        {
            if(input[i]==' ')
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

            try {
                FileOutputStream fos = new FileOutputStream("Text3.txt");
                String text = String.valueOf(input);
                byte[] textBytes = text.getBytes();
                fos.write(textBytes);
                fos.close();
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл: " + e.getMessage());
            }

        }
        System.out.println("Розшифрований рядок: "+String.valueOf(input)+ "\n");

    }
}



