package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader fileReader =  new BufferedReader(new FileReader(fileName1));
        DataOutputStream fileWriter = new DataOutputStream(new FileOutputStream(fileName2));

        while (fileReader.ready()) {
            String[] str = fileReader.readLine().replaceAll("[\\p{Punct}]"," ").split(" ");
            for (String s : str) {
                if (isDigit(s)) {
                    String s1 = s + " ";
                    fileWriter.write(s1.getBytes());
                }
            }
        }
        fileReader.close();
        fileWriter.close();
    }

    public static boolean isDigit(String c) {
        try{
            Integer.parseInt(String.valueOf(c));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

}
