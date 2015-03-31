package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            bufferedReader.close();
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName));
            String str;
            while ((str = bufferedReader1.readLine()) != null) {
                String id = str.substring(0, str.indexOf(' '));
                if (args[0].equals(id)) System.out.println(str);
            }
        }
    }
}
