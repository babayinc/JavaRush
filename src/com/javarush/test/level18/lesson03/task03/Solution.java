package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 127; i++) {
            list.add(i, 0);
        }
        while (fileInputStream.available() > 0) {
            int temp = fileInputStream.read();
            list.set(temp, list.get(temp) + 1);
        }
        int max = 0;
        for (int i = 0; i < 127; i++) {
            max = (max < list.get(i)) ? list.get(i) : max;
        }
        String s = "";
        for (int i = 0; i < 127; i++) {
            if (list.get(i) == max) {
                s = s + " " + i;
            }
        }
        fileInputStream.close();
        System.out.println(s);
    }
}
