package com.example.manjushachava.foodapp;

import com.example.manjushachava.foodapp.Lipids1;
import com.example.manjushachava.foodapp.Minerals1;
import com.example.manjushachava.foodapp.Proximates1;
import com.example.manjushachava.foodapp.Vitamins1;

public class Food1 {

    private String name;
    private Proximates1 proximates;
    private Minerals1 minerals;
    private Vitamins1 vitamins;
    private Lipids1 lipids;

    /**
     * an object that can contain a name, proximates, minerals, vitamins, and lipids
     */
    public Food1() {

    }

    /**
     *
     * @return the name of the food
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the Food1 object
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the Proximate1 object
     */
    public Proximates1 getProximates() {
        return proximates;
    }

    /**
     * sets the Proximates1 object
     * @param proximates
     */
    public void setProximates(Proximates1 proximates) {
        this.proximates = proximates;
    }

    /**
     *
     * @return the Minerals1 object
     */
    public Minerals1 getMinerals() {
        return minerals;
    }

    /**
     * sets the Minerals1 object
     * @param minerals
     */
    public void setMinerals(Minerals1 minerals) {
        this.minerals = minerals;
    }

    /**
     *
     * @return the Vitamins1 object
     */
    public Vitamins1 getVitamins() {
        return vitamins;
    }

    /**
     * sets the Vitamins1 object
     * @param vitamins
     */
    public void setVitamins(Vitamins1 vitamins) {
        this.vitamins = vitamins;
    }

    /**
     *
     * @return the Lipids1 object
     */
    public Lipids1 getLipids() {
        return lipids;
    }

    /**
     * sets the Lipids1 object
     * @param lipids
     */
    public void setLipids(Lipids1 lipids) {
        this.lipids = lipids;
    }
}

