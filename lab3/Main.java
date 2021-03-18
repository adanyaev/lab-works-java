package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void countLetters(String inputPath, String outputPath) {
        int[] counts = new int[26];

        try {
            FileReader input = null;
            input = new FileReader(inputPath);
            int ch = input.read();
            while(ch !=-1){
                if ( ch >= 97 && ch <= 122){
                    counts[ch-97] += 1;
                }
                if ( ch >= 65 && ch <= 90){
                    counts[ch-65] += 1;
                }
                ch = input.read();
            }
            input.close();
        } catch(IOException ex){
            System.out.println(ex.getMessage());
            return;
        }

        try {
            FileWriter output = null;
            output = new FileWriter(outputPath);
            for (int i = 0; i < counts.length; i++){
                output.write((char)(i+65) + ": " + counts[i] + '\n');
            }
            output.close();
        } catch(IOException ex){
            System.out.println(ex.getMessage());
            return;
        }
        System.out.println("Success");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Enter path of input file:");
            input = sc.nextLine();
            File f = new File(input);
            if(f.exists() && !f.isDirectory()) {
                break;
            } else {
                System.out.println("File does not exist. Try again");
                continue;
            }
        }
        System.out.println("Enter path of output file:");
        String output = sc.nextLine();
        countLetters(input, output);
    }
}
