package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(args[1]));
            String str;
            String result = "";
            while ((str = reader.readLine()) != null){
                String[] strings = str.split(" ");
                for (String string : strings) {
                    if (string.length() > 6) {
                        result += string + ",";
                    }
                }
            }
            result = result.substring(0, result.length()-1);
            outputStream.write(result.getBytes());
        }
    }
}
