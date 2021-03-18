package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Enter data:");
            Scanner sc = new Scanner(System.in);
            String surname = sc.next();
            String name = sc.next();
            String secname = sc.next();
            String dateStr = sc.nextLine();
            char gender;
            if (secname.substring(secname.length() - 2).equals("на")) {
                gender = 'Ж';
            } else {
                gender = 'М';
            }
            SimpleDateFormat formatter = new SimpleDateFormat("d.M.yyyy");
            Date dateOfBirth = null;
            try {
                dateOfBirth = formatter.parse(dateStr);
            } catch (ParseException e) {
                System.out.println("Wrong date. Try again");
                return;
            }
            Date today = new Date();
            if (dateOfBirth.after(today)) {
                System.out.println("Wrong date. Try again");
                return;
            }
            int years = (int) ((long) (today.getTime() - dateOfBirth.getTime()) / (1000 * 60 * 60 * 24 * 365.25));
            System.out.printf("%s %c.%c. %c %d лет", surname, name.charAt(0), secname.charAt(0), gender, years);
        } catch (Exception e){
            System.out.println("Wrong input. Try again");
        }
    }
}
