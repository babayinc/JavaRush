package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName1);
        byte[] buffer = new byte[fileInputStream.available()];
        int count = fileInputStream.read(buffer);
        String str = "";
        char[] chars = new String(buffer, "UTF-8").toCharArray();
        ArrayList<Float> list = new ArrayList<Float>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                list.add(Float.parseFloat(str));
                str = "";
            } else {
                str += String.valueOf(chars[i]);
            }
        }
        list.add(Float.parseFloat(str));
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        Integer n = Math.round(list.get(0));
        fileOutputStream.write(n.toString().getBytes());
        for (int i = 1; i < list.size(); i++) {
            n = Math.round(list.get(i));
            fileOutputStream.write(" ".getBytes());
            fileOutputStream.write(n.toString().getBytes());
        }
    }
}
