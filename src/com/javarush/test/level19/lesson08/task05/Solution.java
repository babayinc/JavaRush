package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName));
        PrintStream consoleSream = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        testString.printSomething();
        String result = output.toString();
        System.setOut(consoleSream);
        System.out.println(result);
        outputStream.write(result.getBytes());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

