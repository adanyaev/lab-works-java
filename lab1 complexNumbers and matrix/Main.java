package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true){
            Matrix[] arr = new Matrix[2];
            for (int i = 0; i < 2; i++) {
                System.out.println("Enter dimensions of "+ (i+1) + " matrix in this format \"m n\"");
                int m, n;
                try {
                    m = sc.nextInt();
                    n = sc.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Wrong input. try again");
                    sc.nextLine();
                    i = -1;
                    continue;
                }
                ComplexNumber[][] a = new ComplexNumber[m][n];
                System.out.println("Enter matrix of complex numbers row by row. Each number consists of Real part and Imaginary part");
                for (int j = 0; j < m; j++){
                    for (int k = 0; k < n; k++){
                        try {
                            double num1 = sc.nextDouble();
                            double num2 = sc.nextDouble();
                            a[j][k] = new ComplexNumber(num1, num2);
                        } catch (java.util.InputMismatchException e){
                            System.out.println("Wrong input. try again");
                            System.out.println("Enter matrix of complex numbers row by row");
                            sc.nextLine();
                            j = -1;
                            break;
                        }
                    }
                }
                arr[i] = new Matrix(a);
            }
            String op;
            Matrix res = arr[0];
            sc.nextLine();
            boolean f = false;
            while (true) {
                System.out.println("Enter operation (* for mul, + for sum, - for sub) or skip");
                op = sc.nextLine();
                try {
                    switch (op) {
                        case ("*") -> res = arr[0].mul(arr[1]);
                        case ("+") -> res = arr[0].add(arr[1]);
                        case ("-") -> res = arr[0].sub(arr[1]);
                        case ("skip") -> f = true;
                        default -> {
                            System.out.println("Unknown operation. Try again another operation");
                            continue;
                        }
                    }
                } catch (ArithmeticException e) {
                    System.out.println("Incompatible dimensions. Try again another operation");
                    continue;
                }
                break;
            }
            arr[0].printMatrix();
            if (!f){
                System.out.println(op);
            }
            arr[1].printMatrix();
            if (f){
                continue;
            }
            System.out.println("=");
            res.printMatrix();
            System.out.println("Print T to transpose or D to count Determinant");
            op = sc.nextLine();
            try {
                switch (op) {
                    case ("T") -> res.transpose().printMatrix();
                    case ("D") -> { res.countDet().printAlgForm();
                                    System.out.println();}
                }
            } catch (ArithmeticException e) {
                System.out.println("Incompatible dimensions. Try again another operation");
                continue;
            }
        }

    }
}
