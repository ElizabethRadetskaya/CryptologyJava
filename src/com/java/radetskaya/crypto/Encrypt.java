package com.java.radetskaya.crypto;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Encrypt {


        public static void encrypt() {
            char[] input;
            int key;
            Scanner sc = new Scanner(System.in);
            System.out.println("Введіть текст для шифрування: ");


            List<String> arrayList = new ArrayList<>();
            String string = null;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Text.txt"))) {


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

            System.out.println("Строку в массив символов: " + Arrays.toString(input));


            System.out.println("Введіть ключ для шифрування: ");
            key = sc.nextInt();
            for (int i = 0; i < input.length; i++) {
                if (input[i] == ' ')
                    continue;
                else {
                    if (input[i] >= 'А' && input[i] <= 'Я') {
                        input[i] = (char) (key + input[i]);
                        if (input[i] > 'Я') {
                            input[i] = (char) (input[i] - 32);
                        }
                    } else {
                        input[i] = (char) (key + input[i]);
                        if (input[i] > 'я') {
                            input[i] = (char) (input[i] - 32);
                        }
                    }

                }

                try {
                    FileOutputStream fos = new FileOutputStream("Text2.txt");
                    String text = String.valueOf(input);
                    byte[] textBytes = text.getBytes();
                    fos.write(textBytes);
                    fos.close();
                } catch (IOException e) {
                    System.out.println("Ошибка записи в файл: " + e.getMessage());
                }

            }

        }
    }







