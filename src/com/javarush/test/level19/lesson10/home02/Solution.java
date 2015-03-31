package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String str;
            Map<String, Double> map = new HashMap<String, Double>();
            while ((str = reader.readLine()) != null) {
                String name = str.split(" ")[0];
                Double value = Double.parseDouble(str.split(" ")[1]);
                if (map.containsKey(name)) {
                    map.put(name, map.get(name) + value);
                } else {
                    map.put(name, value);
                }
            }
            double max = Double.MIN_VALUE;
            String maxName = "";
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    maxName = entry.getKey();
                }
            }
            System.out.println(maxName);
            reader.close();
        }
    }
}
