package com.elmaghraby.mvvmapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey (autoGenerate = true)
    private int id;
    private String title;

    private String des;

    private int priority;


    public Note(String title, String des, int priority) {
        this.title = title;
        this.des = des;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDes() {
        return des;
    }

    public int getPriority() {
        return priority;
    }
}
