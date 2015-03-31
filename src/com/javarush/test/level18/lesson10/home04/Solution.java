package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileInputStream fileInputStream1 = new FileInputStream(fileName2);
        int count = 0;
        int count1 = 0;
        byte[] buffer = new byte[0];
        byte[] buffer1 = new byte[0];
        if (fileInputStream.available() > 0) {
            buffer = new byte[fileInputStream.available()];
            count = fileInputStream.read(buffer);
            fileInputStream.close();
        }
        if (fileInputStream1.available() > 0) {
            buffer1 = new byte[fileInputStream1.available()];
            count1 = fileInputStream1.read(buffer1);
            fileInputStream1.close();
        }

        byte[] buffer2 = new byte[buffer.length + buffer1.length];

        for (int i = 0; i < buffer1.length; i++) {
            buffer2[i] = buffer1[i];
        }
        for (int i = buffer1.length; i < buffer.length + buffer1.length; i++){
            buffer2[i] = buffer[i- buffer1.length];
        }

        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        fileOutputStream.write(buffer2, 0, count+count1);
        fileOutputStream.close();

    }
}
