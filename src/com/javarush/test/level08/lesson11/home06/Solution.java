package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human ch1 = new Human();
        ch1.name = "ch1";
        ch1.sex = true;
        ch1.age = 1;

        Human ch2 = new Human();
        ch2.name = "ch2";
        ch2.sex = false;
        ch2.age = 2;

        Human ch3 = new Human();
        ch3.name = "ch3";
        ch3.sex = true;
        ch3.age = 3;

        Human mot = new Human();
        mot.name = "mot";
        mot.sex = false;
        mot.age = 30;
        mot.children.add(ch1);
        mot.children.add(ch2);
        mot.children.add(ch3);

        Human fat = new Human();
        fat.name = "fat";
        fat.sex = true;
        fat.age = 30;
        fat.children.add(ch1);
        fat.children.add(ch2);
        fat.children.add(ch3);

        Human gp1 = new Human();
        gp1.name = "gp1";
        gp1.sex = true;
        gp1.age = 100;
        gp1.children.add(mot);

        Human gm1 = new Human();
        gm1.name = "gm1";
        gm1.sex = false;
        gm1.age = 90;
        gm1.children.add(mot);

        Human gp2 = new Human();
        gp2.name = "gp2";
        gp2.sex = true;
        gp2.age = 90;
        gp2.children.add(fat);

        Human gm2 = new Human();
        gm2.name = "gm2";
        gm2.sex = false;
        gm2.age = 80;
        gm2.children.add(fat);

        System.out.println(gp1.toString());
        System.out.println(gm1.toString());
        System.out.println(gp2.toString());
        System.out.println(gm2.toString());
        System.out.println(fat.toString());
        System.out.println(mot.toString());
        System.out.println(ch1.toString());
        System.out.println(ch2.toString());
        System.out.println(ch3.toString());



    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
