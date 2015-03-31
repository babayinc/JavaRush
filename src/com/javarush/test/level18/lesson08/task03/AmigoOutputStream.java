package com.javarush.test.level18.lesson08.task03;

import java.io.*;
import java.nio.channels.FileChannel;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream {

    private FileOutputStream component;

    public AmigoOutputStream(FileOutputStream component) throws FileNotFoundException {
        super(fileName);
        this.component = component;
    }

    @Override
    public FileChannel getChannel() {
        return super.getChannel();
    }

    @Override
    protected void finalize() throws IOException {
        super.finalize();
    }

    @Override
    public void close() throws IOException {
        flush();
        String s = "JavaRush © 2012-2013 All rights reserved.";
        write(s.getBytes());
        component.close();
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    public static String fileName = "C:/tmp/result.txt";
    //public static String fileName = "C:/temp/result.txt";

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }
}

