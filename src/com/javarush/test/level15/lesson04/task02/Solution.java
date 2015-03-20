package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }


    public static void printMatrix(int m, int n, Integer value) {
        printMatrix(m,n, value.toString());
    }

    public static void printMatrix(int m, int n, int value) {
        Integer i = (Integer) value;
        printMatrix(m, n, i.toString());
    }

    public static void printMatrix(int m, int n, byte value) {
        Byte i = (Byte) value;
        printMatrix(m, n, i.toString());
    }

    public static void printMatrix(int m, int n, short value) {
        Short i = (Short) value;
        printMatrix(m, n, i.toString());
    }

    public static void printMatrix(int m, int n, long value) {
        Long i = (Long) value;
        printMatrix(m, n, i.toString());
    }


    public static void printMatrix(int m, int n, Byte value) {
        printMatrix(m, n, value.toString());
    }

    public static void printMatrix(int m, int n, Short value) {
        printMatrix(m, n, value.toString());
    }

    public static void printMatrix(int m, int n, Long value) {
        printMatrix(m, n, value.toString());
    }

}
