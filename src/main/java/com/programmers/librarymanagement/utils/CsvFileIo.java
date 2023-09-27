package com.programmers.librarymanagement.utils;

import com.programmers.librarymanagement.domain.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvFileIo {

    private final BufferedReader br;

    String PATH = System.getProperty("user.dir") + "/src/main/resources/data.csv";

    public CsvFileIo() {
        try {
            br = new BufferedReader(new FileReader(PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<List<String>> readCsv() {

        List<List<String>> dataList = new ArrayList<>();

        try {
            String data;

            while ((data = br.readLine()) != null) {

                String[] singleData = data.split(",");

                dataList.add(Arrays.asList(singleData));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return dataList;
    }

    public void writeCsv(Book book) {

        File csv = new File(PATH);
        BufferedWriter bw;

        try {
            bw = new BufferedWriter(new FileWriter(csv, true));

            String singleData = book.getId() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getPage();

            bw.write(singleData);
            bw.newLine();

            bw.flush();
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
