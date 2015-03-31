package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> shortList = new ArrayList<Integer>();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0) {
            list.add(fileInputStream.read());
        }
        fileInputStream.close();
        Collections.sort(list);
        shortList.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (shortList.get(shortList.size()-1) != list.get(i)) {
                shortList.add(list.get(i));
            }
        }
        System.out.print(shortList.get(0));
        for (int i = 1; i < shortList.size(); i++){
            System.out.print(" " + shortList.get(i));
        }

    }
}
