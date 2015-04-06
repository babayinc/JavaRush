package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine();
        String filename2 = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader fileReader1 = new BufferedReader(new FileReader(filename1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(filename2));
        ArrayList<String> list1 = new ArrayList<String>();
        String buffer;
        while ((buffer = fileReader1.readLine()) != null) list1.add(buffer);
        ArrayList<String> list2 = new ArrayList<String>();
        while ((buffer = fileReader2.readLine()) != null) list2.add(buffer);
//        for (String temp : list1) {
//            lines.add(new LineItem(Type.REMOVED, temp));
//        }
//        for (String temp : list2){
//            boolean added = true;
//            for(LineItem lineItem : lines) {
//                if (temp.equals(lineItem.line)){
//                    lineItem.type = Type.SAME;
//                    added = false;
//                }
//            }
//            if (added) lines.add(new LineItem(Type.ADDED, temp));

        int count1 = 0;
        int count2 = 0;

        while (true) {
            if (list1.get(count1).equals(list2.get(count2))){
                lines.add(new LineItem(Type.SAME, list1.get(count1)));
                if (count1 < list1.size() - 1) count1 ++;
                if (count2 < list2.size() - 1) count2 ++;
            } else {
                if (count1 < list1.size() - 1 && list1.get(count1 +1).equals(list2.get(count2))) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(count1)));
                    count1 ++;
                } else if (count2 < list2.size() - 1 && list1.get(count1).equals(list2.get(count2 + 1))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(count2)));
                    count2++;
                } else if (count1 == list1.size() -1) {
                    lines.add(new LineItem(Type.ADDED, list2.get(count2)));
                    if (count2 < list2.size() - 1) count2 ++;
                    else break;
                }else break;
            }
        }

       // for (LineItem line : lines) System.out.println(line.line + " " + line.type);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
