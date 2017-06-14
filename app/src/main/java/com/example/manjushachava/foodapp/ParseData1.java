package com.example.manjushachava.foodapp;

import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.io.FileNotFoundException;

public class ParseData1 {

    private InputStream is;


    /**
     * creates an instance of the ParseData1 object,
     * which reads a csv file via InputStream
     * @param in
     * @throws FileNotFoundException
     */
    public ParseData1(InputStream in) throws FileNotFoundException {
        is = in;
    }

    /**
     *
     * @return an arraylist of the foods described in the csv file
     * @throws FileNotFoundException
     */
    public ArrayList<Food1> allFoods() throws FileNotFoundException {

        Log.i("Jack", "Entered While loop");
        ArrayList<Food1> foods = new ArrayList<Food1>();
        Scanner scan = new Scanner(is);
        scan.nextLine();
        String nextLine;
        Food1 food;
        StringTokenizer tokenizer;
        String[] split;
        while (scan.hasNextLine()) {

            nextLine = scan.nextLine();

            food = new Food1();

            tokenizer = new StringTokenizer(nextLine, "\"");

            tokenizer.nextToken();
            food.setName(tokenizer.nextToken());

            split = tokenizer.nextToken().split(",");

            food.setProximates(buildProximates(split));
            food.setMinerals(buildMinerals(split));
            food.setVitamins(buildVitamins(split));
            food.setLipids(buildLipids(split));
            foods.add(food);
        }

        scan.close();
        return foods;
    }

    /**
     * used because the csv file might have empty fields
     * @param split
     * @param i
     * @return the original number or 0 if the original is null
     */
    	private double setData(String[] split, int i) {
		double number;
		if (split[i].isEmpty()) {
			number = 0;
		} else {
			number = Double.parseDouble(split[i]);
		}

		return number;
	}

    /**
     * reads the csv and finds the data for the Proximates1 object
     * @param split
     * @return the Proximate1 object of a respective food
     */
    private Proximates1 buildProximates(String[] split) {
        Proximates1 proximate = new Proximates1();

        proximate.setWater(setData(split, 1));
        proximate.setEnergy(setData(split, 2));
        proximate.setProtein(setData(split, 3));
        proximate.setLipid(setData(split, 4));
        proximate.setAsh(setData(split, 5));
        proximate.setCarbohydrate(setData(split, 6));
        proximate.setFiber(setData(split, 7));
        proximate.setSugar(setData(split, 8));

        return proximate;
    }

    /**
     * reads the csv and finds the data for the Minerals1 object
     * @param split
     * @return the Minerasl1 object of a respective food
     */
    private Minerals1 buildMinerals(String[] split) {
        Minerals1 minerals = new Minerals1();

        minerals.setCalcium(setData(split, 9));
        minerals.setIron(setData(split, 10));
        minerals.setMagnesium(setData(split, 11));
        minerals.setPhosphorus(setData(split, 12));
        minerals.setPotassium(setData(split, 13));
        minerals.setSodium(setData(split, 14));
        minerals.setZinc(setData(split, 15));
        minerals.setCopper(setData(split, 16));
        minerals.setManganese(setData(split, 17));
        minerals.setSelenium(setData(split, 18));
        return minerals;
    }

    /**
     * reads the csv and finds the data for the Vitamins1 object
     * @param split
     * @return the Vitamins1 object of a respective food
     */
    private Vitamins1 buildVitamins(String[] split) {
        Vitamins1 vitamins = new Vitamins1();

        vitamins.setVit_c(setData(split, 19));
        vitamins.setThiamin(setData(split, 20));
        vitamins.setRiboflavin(setData(split, 21));
        vitamins.setNiacin(setData(split, 22));
        vitamins.setPanto_acid(setData(split, 23));
        vitamins.setVit_b6(setData(split, 24));
        vitamins.setFolate_tot(setData(split, 25));
        vitamins.setFolic_acid(setData(split, 26));
        vitamins.setFood_folate(setData(split, 27));
        vitamins.setFood_folate_dfe(setData(split, 28));
        vitamins.setCholine_tot(setData(split, 29));
        vitamins.setVit_b12(setData(split, 30));
        vitamins.setVit_a_iu(setData(split, 31));
        vitamins.setVit_a_rae(setData(split, 32));
        vitamins.setRetinol(setData(split, 33));
        vitamins.setApha_carot(setData(split, 34));
        vitamins.setBeta_carot(setData(split, 35));
        vitamins.setBeta_crypt(setData(split, 36));
        vitamins.setLycopene(setData(split, 37));
        vitamins.setLut_zea(setData(split, 38));
        vitamins.setVit_e(setData(split, 39));
        vitamins.setVit_d_ug(setData(split, 40));
        vitamins.setVit_d_iu(setData(split, 41));
        vitamins.setVit_k(setData(split, 42));

        return vitamins;
    }

    /**
     * reads the csv and finds the data for the Lipids1 object
     * @param split
     * @return the Lipids1 object of a respective food
     */
    private Lipids1 buildLipids(String[] split) {
        Lipids1 lipid = new Lipids1();

        lipid.setFat_sat(setData(split, 43));
        lipid.setFat_mono(setData(split, 44));
        lipid.setFat_poly(setData(split, 45));
        lipid.setCholestrl(setData(split, 46));

        return lipid;
    }
}
