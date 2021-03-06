package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            byte[] bytes = new byte[0];
            ArrayList<Integer> counts = new ArrayList<Integer>();
            int count;
            for (int i = 0; i < 128; i++) {
                counts.add(0);
            }
            if (fileInputStream.available()>0) {
                bytes = new byte[fileInputStream.available()];
                count = fileInputStream.read(bytes);
            }
            for (int i = 0; i < bytes.length; i++) {
                counts.set(bytes[i],counts.get(bytes[i]) + 1);
            }

            for (int i = 0; i < counts.size(); i++){
                if (counts.get(i) != 0)
                    System.out.println((char)i + " " + counts.get(i));
            }

        }
    }
}
