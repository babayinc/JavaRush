package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by ukr-maksimyak on 16.03.2015.
 */
public class Singleton
{
    private static Singleton instance = null;

    private Singleton()
    {

    }

    public static Singleton getInstance()
    {
        if ( instance == null )
        {
            instance = new Singleton();
        }

        return instance;
    }
}

