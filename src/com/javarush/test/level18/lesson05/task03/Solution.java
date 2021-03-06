package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        String fileName3 = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName3);

        byte[] o1 = new byte[fileInputStream.available() - fileInputStream.available()/2];
        byte[] o2 = new byte[fileInputStream.available()/2];
        int count1 = fileInputStream.read(o1);
        int count2 = fileInputStream.read(o2);
        fileOutputStream.write(o1, 0, count1);
        fileOutputStream1.write(o2, 0, count2);

        fileInputStream.close();
        fileOutputStream1.close();
    }
}
