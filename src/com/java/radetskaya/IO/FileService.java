package com.java.radetskaya.IO;

import com.java.radetskaya.crypto.BruteForce;
import com.java.radetskaya.crypto.Decrypt;
import com.java.radetskaya.crypto.Encrypt;

import java.util.Scanner;

public class FileService {

        public static void main(String... s) {
            String message, encryptedMessage, username = "";
            int key;
            char ch;
            Scanner sc = new Scanner(System.in);

            System.out.println("Вас вітає компанія \"Ceasar Cipher\"");
            System.out.println("Введіть Ваше ім'я: ");
            Scanner scan = new Scanner(System.in);
            username = scan.nextLine();
            System.out.println("Доброго дня, " + username + "!" );


            int c;
            do {
                System.out.println("Виберіть дію для опрацювання вашого тексту:\n1:Encryption\n2:Decryption\n3:Bruteforce\n4:Exit");
                c = sc.nextInt();
                switch (c) {
                    case 1:
                       Encrypt.encrypt();
                        break;
                    case 2:
                        Decrypt.decrypt();
                        break;
                    case 3:
                        BruteForce.bruteforce();
                        break;
                    case 4:
                        break;
                }
            } while (c != 4);
        }
    }


