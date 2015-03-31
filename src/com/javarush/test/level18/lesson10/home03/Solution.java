package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        String fileName3 = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName2);
        FileInputStream fileInputStream1 = new FileInputStream(fileName3);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        if (fileInputStream.available() > 0) {
            byte[] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            fileOutputStream.write(buffer, 0, count);
        }
        while (fileInputStream1.available() > 0) {
            byte[] buffer = new byte[fileInputStream1.available()];
            int count = fileInputStream1.read(buffer);
            fileOutputStream.write(buffer, 0, count);
        }
        fileInputStream.close();
        fileInputStream1.close();
        fileOutputStream.close();
    }
}
