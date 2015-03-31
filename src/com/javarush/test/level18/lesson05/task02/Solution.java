package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int count = 0;
        while (fileInputStream.available() > 0) {
            if (fileInputStream.read() == 44) count++;

        }
        fileInputStream.close();
        System.out.println(count);
    }
}
