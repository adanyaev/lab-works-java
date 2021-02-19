package com.company;

public class ComplexNumber {
    private double a; // действительная часть
    private double b; // мнимая часть

    public double getRealPart() {
        return a;
    }

    public void setRealPart(int a) {
        this.a = a;
    }

    public double getImPart() {
        return b;
    }

    public void setImPart(int b) {
        this.b = b;
    }

    public ComplexNumber(double a, double b){
        this.a = a;
        this.b = b;
    }
    public ComplexNumber(double a){
        this.a = a;
        this.b = 0;
    }
    public ComplexNumber add(ComplexNumber n){
        return new ComplexNumber(this.a + n.a, this.b + n.b);
    }

    public ComplexNumber sub(ComplexNumber n){
        return new ComplexNumber(this.a - n.a, this.b - n.b);
    }

    public ComplexNumber mul(ComplexNumber n){
        return new ComplexNumber(this.a*n.a - this.b*n.b, this.a*n.b + this.b*n.a);
    }

    public ComplexNumber mul(double n){
        return new ComplexNumber(a*n,b*n);
    }

    public ComplexNumber div(double n){
        return new ComplexNumber(a/n,b/n);
    }

    public ComplexNumber div(ComplexNumber n){
        ComplexNumber num = new ComplexNumber(n.a, -n.b);
        num = num.mul(this);
        double den = n.a*n.a + n.b*n.b;
        return num.div(den);
    }

    public void printAlgForm(){
        System.out.print(a + " + (" + b + "i)");
    }

    public void printTrigForm(){
        double r = Math.sqrt(a*a + b*b);
        double fi = Math.atan(b/a);
        System.out.println(r + " * (cos(" + fi + ") + i*sin(" + fi + "))");
    }


}
