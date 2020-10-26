package com.company;

public class Main {

    public static void main(String[] args) {
        String filename = args[0];
        FileProcessor fileProcessor = new FileProcessor(filename);
        Zoo zoo = fileProcessor.createZoo();
        zoo.calculateTheLightestElephant();
        long result = zoo.reorderElephants();
        System.out.println(result);
    }
}
