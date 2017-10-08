    package com.example.manjushachava.foodapp;

public class StringValue {

    private String name;
    private double value;

    /**
     * an object that can contain a name and double
     */
    public StringValue(String name, double value ) {
        this.name = name;
        this.value = value;
    }

    /**
     *
     * @return the name of the food
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the StringValue object
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the name of the food
     */
    public double getVal() {
        return value;
    }

    /**
     * sets the name of the Food1 object
     * @param val
     */
    public void setVal(double val) {
        this.value = val;
    }
}

