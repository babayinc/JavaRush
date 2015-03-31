package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 127; i++) {
            list.add(0);
        }
        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0) {
            int temp = fileInputStream.read();
            list.set(temp, list.get(temp) + 1);
        }
        int min = 2147483647;
        for (int i = 0; i < 127; i++) {
            if (min > list.get(i) && list.get(i) != 0) {
                min = list.get(i);
            }
        }
        String s = "";
        for (int i = 0; i < 127; i++) {
            if (list.get(i) == min) {
                s = s + " " + i;
            }
        }
        fileInputStream.close();
        System.out.println(s);
    }
}
