package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.*;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String s = null;
            s = this.scanner.nextLine();
            String[] list = s.split(" ");
            Calendar date = new GregorianCalendar(Integer.parseInt(list[5]), Integer.parseInt(list[4])-1, Integer.parseInt(list[3]));
            return new Person(list[1], list[2], list[0], date.getTime());
        }

        @Override
        public void close() throws IOException {
            this.scanner.close();
        }
    }
}
