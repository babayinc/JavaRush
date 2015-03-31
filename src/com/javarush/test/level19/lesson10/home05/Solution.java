package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(args[1]));
            String str;
            while ((str = reader.readLine()) != null) {
                String[] strings = str.split(" ");
                for (String s : strings) {
                    char[] chars = s.toCharArray();
                    for (char c : chars) {
                        if (isDigit(c)) {
                            String temp = s + " ";
                            outputStream.write(temp.getBytes());
                            break;
                        }
                    }

                }
            }
            reader.close();
            outputStream.close();
        }
    }

    private static boolean isDigit(char c) {
        try {
            Integer.parseInt(String.valueOf(c));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
