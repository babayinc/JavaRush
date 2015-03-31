package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();
        ArrayList<Integer> list = new ArrayList<Integer>();
        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        while (fileInputStream.available() > 0) {
            list.add(fileInputStream.read());
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            fileOutputStream.write(list.get(i));
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
