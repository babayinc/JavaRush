package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

            System.out.println(ivanov.isSame(somePerson));
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {

            PrintWriter printWriter = new PrintWriter(outputStream);

            printWriter.println(name);
            for (Asset asset : assets) {
                printWriter.println(asset.getName());
                printWriter.println(asset.getPrice());
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String buffer;
            String string = "";
            int i = 0;
            while ((buffer = bufferedReader.readLine()) != null) {
                string += buffer + " ";
            }
            bufferedReader.close();
            String[] str = string.split(" ");
            int count = 1;
            name = str[0];
            if (str.length > 2) {
                while (count < str.length - 1) {
                    if (isDouble(str[count+1])) {
                        Asset asset = new Asset(str[count]);
                        asset.setPrice(Double.parseDouble(str[count + 1]));
                        assets.add(asset);
                        count += 2;
                    } else break;
                }
            }
        }

        public static boolean isDouble(String s) {
            try {
                double d = Double.parseDouble(s);
                return true;
            }catch (NumberFormatException e) {
                return false;
            }
        }

        public boolean isSame(Human human){
            boolean result = true;
            if (!name.equals(human.name)) {
                return false;
            }
            if (assets.size() != human.assets.size()){
                return false;
            }
            for (int i = 0; i < assets.size(); i++) {
                Asset asset1 = assets.get(i);
                Asset asset2 = human.assets.get(i);
                if (!asset1.getName().equals(asset2.getName())){
                    return false;
                }
                if (asset1.getPrice()!=asset2.getPrice()) {
                    return false;
                }
            }

            return result;
        }

    }
}
