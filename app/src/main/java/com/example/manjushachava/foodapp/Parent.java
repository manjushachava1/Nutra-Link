package com.example.manjushachava.foodapp;

import java.util.ArrayList;

public class Parent {

    private String name;
    private ArrayList<Child> childList = new ArrayList<>();

    public Parent(String name, ArrayList<Child> childList) {
        super();
        this.name = name;
        this.childList = childList;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Child> getChildList() {
        return childList;
    }
}