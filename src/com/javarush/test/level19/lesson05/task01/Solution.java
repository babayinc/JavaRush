package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedreader.readLine();
        String fileName2 = bufferedreader.readLine();
        bufferedreader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        int count = 0;
        while (fileInputStream.available() > 0) {
            int i = fileInputStream.read();
            if (count % 2 != 0) {
                fileOutputStream.write(i);
            }
            count++;
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
