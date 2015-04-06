package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String string = "";
            String buffer;
            while ((buffer = fileReader.readLine()) != null) {
                string += buffer;
            }
            String str = string.replaceAll("\r\n","");;
            fileReader.close();
            if (!str.contains("CDATA"))
            {
                //find(str, args[0]);
                findTags(args[0], str, 0);
            }

        }
    }

    public static void find(String s, String param) {

        while (!s.equals("")) {
            int first = s.indexOf(param);
            if (first > 0) {
                int count = 0;
                int last = s.indexOf(param, first + param.length());

                if (last != -1 && s.charAt(last - 1) != '/') {
                    count++;
                }
                int temp = last;
                while (count > 0) {

                    if (temp != -1 && s.charAt(temp - 1) != '/') {
                        count++;
                    } else {
                        count--;
                        last = temp;
                    }
                    temp = s.indexOf(param, temp + param.length());
                }
                temp = s.indexOf("<" + param, last-1);
                if (temp > 0) {
                    find(s.substring(temp), param);

                }
                s = s.substring(first - 1, last + param.length() + 1);
                System.out.println(s);
                last = s.indexOf(param, first + param.length());
                if (last != -1 && s.charAt(last - 1) != '/') {
                    find(s.substring(param.length(), s.length() - param.length()), param);
                    s = "";
                } else s = "";
            } else {
                s = "";
            }
        }

    }
    public static void findTags(String tag, String x, int q)
    {
        int howManyTag = 0, lastTagsIndex = 0;
        int i = q;
        while (i < (x.length() - tag.length() - 1))
        {
            if (x.substring(i, i + tag.length() + 1).equals("<" + tag))
            {
                if (howManyTag == 0) lastTagsIndex = i;
                howManyTag++;
            }
            else if (x.substring(i, i + tag.length() + 2).equals("</" + tag))
            {
                howManyTag--;
                if (howManyTag == 0)
                {
                    String newString = x.substring(lastTagsIndex, i + tag.length() +3);
                    System.out.println(newString);
                    findTags(tag, newString, 1);
                }
            }
            i++;
        }
    }
}
