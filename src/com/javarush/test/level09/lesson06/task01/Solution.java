package com.javarush.test.level09.lesson06.task01;

public class Solution
{
    public static void main(String[] args) throws NullPointerException, ArithmeticException
    {
        try{
            int a = 42/0;
        }
        catch (NullPointerException e){
            System.out.println("NullPointerException: " + e.getMessage());
        }
        catch (ArithmeticException e){
            System.out.println("ArithmeticException: " + e.getMessage());
        }
    }
}