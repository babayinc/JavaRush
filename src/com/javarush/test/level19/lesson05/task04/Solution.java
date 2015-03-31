package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        DataOutputStream fileWriter = new DataOutputStream(new FileOutputStream(bufferedReader.readLine()));
        bufferedReader.close();
        String str;
        while (fileReader.ready()) {
            str = fileReader.readLine().replaceAll("\\.","!");
            fileWriter.write(str.getBytes());
        }
        fileReader.close();
        fileWriter.close();
    }
}
