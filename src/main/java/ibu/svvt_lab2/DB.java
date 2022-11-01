package ibu.svvt_lab2;

import java.util.ArrayList;

public class DB {
    
    private ArrayList<String> db;
    
    /*
     * DB connection.
     */
    public void connect() {
        db = new ArrayList<String>();
    }
    
    /**
     * Insert to DB.
     */
    public void insert(String s) {
        db.add(s);
    }
    
    /**
     * Get from DB.
     */
    public String get(int i) {
        return db.get(i);
    }
    
    /**
     * DB size.
     */
    public int count() {
        return db.size();
    }
    
    /**
     * Remove from DB.
     */
    public void clear() {
        db.clear();
    }
    
    /**
     * Disconnect from DB.
     */
    public void disconnect() {
        db = null;
    }
}