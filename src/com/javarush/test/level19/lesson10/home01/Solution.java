package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            HashMap<String, Double> map = new HashMap<String, Double>();
            String s;
            while ((s = reader.readLine()) != null) {
                String name = s.split(" ")[0];
                Double value = Double.parseDouble(s.split(" ")[1]);
                if (map.containsKey(name)){
                    map.put(name, map.get(name) + value);
                } else {
                    map.put(name, value);
                }
            }

            ArrayList<String> list = new ArrayList<String>();

            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Double> entry = (Map.Entry) iterator.next();
                list.add(entry.getKey());
            }
            reader.close();

            Collections.sort(list);

            for (String str : list) {
                System.out.println(str + " " + map.get(str));
            }
        }
    }
}
