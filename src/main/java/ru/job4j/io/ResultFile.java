package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                str.append(i * j).append(" ");
            }
            str.append(System.lineSeparator());
        }
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(str.toString().getBytes());
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
}