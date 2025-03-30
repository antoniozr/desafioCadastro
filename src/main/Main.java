package main;

import repository.Filerepository;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Filerepository file = new Filerepository();
        file.criarFile();
        file.lerFile();
    }
}