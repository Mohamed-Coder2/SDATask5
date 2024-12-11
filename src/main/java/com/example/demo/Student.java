package com.example.demo;

public class Student {
    private int id;      // Renamed from ID
    private String name; // Renamed from Name

    public Student() {
        // Default constructor
    }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getters and Setters
    public int getId() {
        return id; // Matches the field name
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name; // Matches the field name
    }

    public void setName(String name) {
        this.name = name;
    }
}
