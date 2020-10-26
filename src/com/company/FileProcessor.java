package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileProcessor {

    private List<String> fileSplitIntoLines;
    private int numberOfElephants;
    private Elephant[] elephants;
    private String[] elephantMasses;
    private String[] elephantEntrySetup;
    private String[] elephantDesiredSetup;


    public FileProcessor(String filename) {
        readFileToAList(filename);
        getElephantParameters();
    }

    public void readFileToAList(String filename) {
        BufferedReader reader = null;
        String line;
        List<String> file = new LinkedList<>();

        try {
            reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                file.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.fileSplitIntoLines = file;

    }

    public void getElephantParameters() {
        numberOfElephants = Integer.parseInt(fileSplitIntoLines.get(0));
        elephants = new Elephant[numberOfElephants];
        elephantMasses = fileSplitIntoLines.get(1).split(" ");
        elephantEntrySetup = fileSplitIntoLines.get(2).split(" ");
        elephantDesiredSetup = fileSplitIntoLines.get(3).split(" ");
    }

    public Zoo createZoo() {
        for (int i = 0; i < numberOfElephants; i++) {
            Elephant elephant = new Elephant(Integer.parseInt(elephantEntrySetup[i]) - 1, 0, Integer.parseInt(elephantMasses[i]));
            elephants[i] = elephant;
        }
//        elephant that originated at the position i needs to move to elephantDesiredSetup[i]
        for (int i = 0; i < numberOfElephants; i++) {
            elephants[Integer.parseInt(elephantDesiredSetup[i]) - 1].setDestination(elephants[i].getOrigin());
        }
        Zoo zoo = new Zoo(numberOfElephants, elephants);
        return zoo;

    }
}
