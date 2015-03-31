package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import sun.java2d.pipe.BufferedBufImgOps;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = bufferedReader.readLine();
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                fileInputStream.close();

            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                bufferedReader.close();
                break;
            }
        }
    }
}
