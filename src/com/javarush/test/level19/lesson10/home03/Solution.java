package com.javarush.test.level19.lesson10.home03;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String str;
            while ((str = reader.readLine()) != null) {
                String[] s = str.split(" ");
                String name = "";
                for (int i = 0; i < s.length - 3; i++){
                    name += s[i];
                    if (i < s.length - 4) {
                        name += " ";
                    }
                }
                int year = Integer.parseInt(s[s.length - 1]);
                int month = Integer.parseInt(s[s.length - 2]) - 1;
                int day = Integer.parseInt(s[s.length - 3]);
                Calendar calendar = new GregorianCalendar();
                calendar.set(year, month, day);
                PEOPLE.add(new Person(name, calendar.getTime()));
            }
//            for (Person person : PEOPLE) {
//                System.out.println(person.getName() + " " + person.getBirthday());
//            }
        }
    }
}
