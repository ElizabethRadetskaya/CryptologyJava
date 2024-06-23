package com.java.radetskaya.crypto;

import java.util.Scanner;

public class Decrypt {


    public static void decrypt()
    {
        char[] input;
        int key;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть текст для розшифрування: ");
        String ip = sc.nextLine();
        input = ip.toCharArray();
        System.out.println("Введіть ключ: ");
        key = sc.nextInt();
        for (int i = 0; i < input.length; i++)
        {
            if(input[i]==' ')
                continue;
            else
            {
                if(input[i]>= 'А' && input[i]<='Я')
                {
                    input[i]=(char) (input[i]-key);
                    if(input[i]<'А')
                    {
                        input[i] = (char) (input[i]+32);
                    }
                }
                else
                {
                    input[i]=(char) (input[i]-key);
                    if (input[i]<'а')
                    {
                        input[i] = (char) (input[i]+32);
                    }
                }
            }
        }
        System.out.println("Розшифрований рядок: "+String.valueOf(input)+ "\n");
    }
}
