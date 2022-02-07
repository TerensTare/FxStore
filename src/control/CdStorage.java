package control;

import java.util.ArrayList;

import models.Cd;

// TODO:
// use hash map here

public class CdStorage {
    private static CdStorage instance = new CdStorage();

    private ArrayList<Cd> cds;
    private ArrayList<Integer> count;

    private CdStorage() {
        cds = new ArrayList<>();
        count = new ArrayList<>();

        // File file = new File("Stock.ser");
        // Buffer
    }

    public void finalize() throws Throwable {
        // TODO:
        // write data to file
    }
}
