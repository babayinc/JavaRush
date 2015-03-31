package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 4 && args[0].equals("-c")) {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String temp;
            String id = null;
            while ((temp = fileReader.readLine())!=null) {
                id = temp;
            }
            fileReader.close();

            id = id.substring(0, 7);
            id = String.valueOf(Integer.parseInt(id.trim()) + 1) + "        ";
            String result = id.substring(0, 7);
            temp = args[1] + "                                 ";
            result += temp.substring(0, 29);
            temp = args[2] + "        ";
            result += temp.substring(0, 7);
            temp = args[3] + "         ";
            result += temp.substring(0, 3);
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
            printWriter.println(result);
            printWriter.close();
        }
    }
}