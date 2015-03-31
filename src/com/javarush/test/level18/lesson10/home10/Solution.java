package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        String temp;
        while (true) {
            temp = bufferedReader.readLine();
            if (temp.equals("end")) {
                break;

            } else {
                list.add(temp);
            }
        }
        bufferedReader.close();

        Collections.sort(list);

        String outputFileName = list.get(0).substring(0, list.get(0).length() - 6);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
        for (String s : list){
            FileInputStream fileInputStream = new FileInputStream(s);
            if (fileInputStream.available() > 0 ) {
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                fileOutputStream.write(buffer);
            }
            fileInputStream.close();
        }
        fileOutputStream.close();
    }
}
