package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            int count = 0;
            while (fileInputStream.available()> 0) {
                int temp = fileInputStream.read();
                if ((65 <= temp && temp <= 90)||(97 <= temp && temp <= 122)) count++;
            }
            System.out.println(count);
            fileInputStream.close();
        }
    }
}
