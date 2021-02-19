package com.company;

public class Matrix {
    private int n; // number of rows
    private int m; // number of columns
    private ComplexNumber[][] matrix;


    public int getRowsNumber() {
        return n;
    }

    public int getColumnsNumber() {
        return m;
    }

    public Matrix(ComplexNumber[][] matrix){
        this.matrix = matrix;
        n = matrix.length;
        m = matrix[0].length;
    }

    public Matrix add(Matrix mat) throws ArithmeticException{
        if (mat.n != n || mat.m != m){
            throw new ArithmeticException("Incompatible dimensions");
        }
        ComplexNumber[][] newmat = new ComplexNumber[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                newmat[i][j] = mat.matrix[i][j].add(matrix[i][j]);
            }
        }
        return new Matrix(newmat);
    }

    public Matrix mul(double num) {
        ComplexNumber[][] newmat = new ComplexNumber[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                newmat[i][j] = matrix[i][j].mul(num);
            }
        }
        return new Matrix(newmat);
    }

    public Matrix sub(Matrix mat){
        return this.add(mat.mul(-1.0));
    }

    public Matrix mul(Matrix mat) throws ArithmeticException{
        if (m != mat.n){
            throw new ArithmeticException("Incompatible dimensions");
        }
        ComplexNumber[][] newmat = new ComplexNumber[n][mat.m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < mat.m; j++){
                ComplexNumber sum = new ComplexNumber(0,0);
                for (int k = 0; k < m; k++){
                    sum = sum.add(matrix[i][k].mul(mat.matrix[k][j]));
                }
                newmat[i][j] = sum;
            }
        }
        return new Matrix(newmat);
    }

    public ComplexNumber countDet() throws ArithmeticException{
        if (m != n){
            throw new ArithmeticException("Incompatible dimensions");
        }
        if (m > 2){
            ComplexNumber sum = new ComplexNumber(0,0);
            for (int i = 0; i < m; i++){
                ComplexNumber[][] newmat = new ComplexNumber[m-1][m-1];
                int c = 0;
                for (int j = 1; j < m; j++){
                    for (int k = 0; k < m; k++){
                        if (k != i){
                            newmat[c/(m-1)][c%((m-1))] = matrix[j][k];
                            c++;
                        }
                    }
                }
                Matrix m = new Matrix(newmat);
                if (i%2 == 0) {
                    sum = sum.add(m.countDet().mul(matrix[0][i]));
                } else {
                    sum = sum.sub(m.countDet().mul(matrix[0][i]));
                }
            }
            return sum;

        } else if (m == 1) {
            return matrix[0][0];
        } else {
            return matrix[0][0].mul(matrix[1][1]).sub(matrix[0][1].mul(matrix[1][0]));
        }
    }

    public Matrix transpose(){
        ComplexNumber[][] mat = new ComplexNumber[m][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
               mat[j][i] = matrix[i][j];
            }
        }
        return new Matrix(mat);
    }

    public void printMatrix(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                matrix[i][j].printAlgForm();
                System.out.print(' ');
            }
            System.out.println();
        }
    }

}
