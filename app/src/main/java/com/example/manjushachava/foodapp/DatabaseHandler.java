package com.example.manjushachava.foodapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Manjusha Chava on 6/1/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "VegetableFruit.db";
    public static final String TABLE_NAME = "VegetableFruit ";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "DESCRIPTION";
    public static final String COL_3 = "WATER";
    public static final String COL_4 = "ENERGY";
    public static final String COL_5 = "PROTEIN";
    public static final String COL_6 = "LIPID";
    public static final String COL_7 = "ASH";
    public static final String COL_8 = "CARBOHYDRATE";
    public static final String COL_9 = "FIBER";
    public static final String COL_10 = "SUGAR";
    public static final String COL_11 = "CALCIUM";
    public static final String COL_12 = "IRON";
    public static final String COL_13 = "MAGNESIUM";
    public static final String COL_14 = "PHOSPHORUS";
    public static final String COL_15 = "POTASSIUM";
    public static final String COL_16 = "SODIUM";
    public static final String COL_17 = "ZINC";
    public static final String COL_18 = "COPPER";
    public static final String COL_19 = "MANGANESE";
    public static final String COL_20 = "SELENIUM";
    public static final String COL_21 = "VITAMIN_C";
    public static final String COL_22 = "THIAMIN";
    public static final String COL_23 = "RIBOFLAVIN";
    public static final String COL_24 = "NIACIN";
    public static final String COL_25 = "PANTO_ACID";
    public static final String COL_26 = "VITAMIN_B6";
    public static final String COL_27 = "FOLATE";
    public static final String COL_28 = "FOLIC_ACID";
    public static final String COL_29 = "FOOD_FOLATE";
    public static final String COL_30 = "FOLATE_DFE";
    public static final String COL_31 = "CHOLINE";
    public static final String COL_32 = "VITAMIN_B12";
    public static final String COL_33 = "VITAMIN_A_IU";
    public static final String COL_34 = "VITAMIN_A_RAE";
    public static final String COL_35 = "RETINOL";
    public static final String COL_36 = "ALPHA_CAROT";
    public static final String COL_37 = "BETA_CAROT";
    public static final String COL_38 = "BETA_CRYPT";
    public static final String COL_39 = "LYCOPENE";
    public static final String COL_40 = "LUT_ZEA";
    public static final String COL_41 = "VITAMIN_E";
    public static final String COL_42 = "VITAMIN_D";
    public static final String COL_43 = "VITAMIN_D_IU";
    public static final String COL_44 = "VITAMIN_K";
    public static final String COL_45 = "FAT_SAT";
    public static final String COL_46 = "FAT_MONO";
    public static final String COL_47 = "FAT_POLY";
    public static final String COL_48 = "CHOLESTEROL";

    private SQLiteDatabase database;


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, DESCRIPTION TEXT, WATER DOUBLE, ENERGY DOUBLE, PROTEIN DOUBLE, LIPID DOUBLE, ASH DOUBLE, CARBOHYDRATE DOUBLE, FIBER DOUBLE, SUGAR DOUBLE, CALCIUM DOUBLE, IRON DOUBLE, MAGNESIUM DOUBLE, PHOSPHORUS DOUBLE, POTASSIUM DOUBLE, SODIUM DOUBLE, ZINC DOUBLE, COPPER DOUBLE, MANGANESE DOUBLE, SELENIUM DOUBLE, VITAMIN_C DOUBLE, THIAMIN DOUBLE, RIBOFLAVIN DOUBLE, NIACIN DOUBLE, PANTO_ACID DOUBLE, VITAMIN_B6 DOUBLE, FOLATE DOUBLE, FOLIC_ACID DOUBLE, FOLATE_DFE DOUBLE, CHOLINE DOUBLE, VITAMIN_B12 DOUBLE, VITAMIN_A_IU DOUBLE, VITAMIN_A_RAE DOUBLE, RETINOL DOUBLE, ALPHA_CAROT DOUBLE, BETA_CAROT DOUBLE, LYCOPENE DOUBLE, LUT_ZEA DOUBLE, VITAMIN_E DOUBLE, VITAMIN_D DOUBLE, VITAMIN_D_IU DOUBLE, VITAMIN_K DOUBLE, FAT_SAT DOUBLE, FAT_MONO DOUBLE, FAT_POLY DOUBLE, CHOLESTEROL DOUBLE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


//    // Adding new food object
//    public void addFood(Food1 food) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COL_2, food.getName()); // Food Name
//        values.put(COL_3, food.getProximates().getWater());
//        values.put(COL_4, food.getProximates().getEnergy());
//        values.put(COL_5, food.getProximates().getProtein());
//        values.put(COL_6, food.getProximates().getLipid1());
//        values.put(COL_7, food.getProximates().getAsh());
//        values.put(COL_8, food.getProximates().getCarbohydrate());
//        values.put(COL_9, food.getProximates().getSugar());
//        values.put(COL_10, food.getMinerals().getCalcium());
//        values.put(COL_11, food.getMinerals().getIron());
//        values.put(COL_12, food.getMinerals().getMagnesium());
//        values.put(COL_13, food.getMinerals().getPhosphorus());
//        values.put(COL_14, food.getMinerals().getPotassium());
//        values.put(COL_15, food.getMinerals().getSodium());
//        values.put(COL_16, food.getMinerals().getZinc());
//        values.put(COL_17, food.getMinerals().getCopper());
//        values.put(COL_18, food.getMinerals().getManganese());
//        values.put(COL_19, food.getMinerals().getSelenium());
//        values.put(COL_20, food.getVitamins().getVit_c());
//        values.put(COL_21, food.getVitamins().getThiamin());
//        values.put(COL_22, food.getVitamins().getRiboflavin());
//        values.put(COL_23, food.getVitamins().getNiacin());
//        values.put(COL_24, food.getVitamins().getPanto_acid());
//        values.put(COL_25, food.getVitamins().getVit_b6());
//        values.put(COL_26, food.getVitamins().getFolate_tot());
//        values.put(COL_27, food.getVitamins().getFolic_acid());
//        values.put(COL_28, food.getVitamins().getFood_folate());
//        values.put(COL_29, food.getVitamins().getFood_folate_dfe());
//        values.put(COL_30, food.getVitamins().getCholine_tot());
//        values.put(COL_31, food.getVitamins().getVit_b12());
//        values.put(COL_32, food.getVitamins().getVit_a_iu());
//        values.put(COL_33, food.getVitamins().getVit_a_rae());
//        values.put(COL_34, food.getVitamins().getRetinol());
//        values.put(COL_35, food.getVitamins().getNiacin());
//        values.put(COL_36, food.getVitamins().getApha_carot());
//        values.put(COL_37, food.getVitamins().getBeta_carot());
//        values.put(COL_38, food.getVitamins().getBeta_crypt());
//        values.put(COL_39, food.getVitamins().getLycopene());
//        values.put(COL_40, food.getVitamins().getLut_zea());
//        values.put(COL_41, food.getVitamins().getVit_e());
//        values.put(COL_42, food.getVitamins().getVit_d_ug());
//        values.put(COL_43, food.getVitamins().getVit_d_iu());
//        values.put(COL_44, food.getVitamins().getVit_k());
//        values.put(COL_45, food.getLipids().getFat_sat());
//        values.put(COL_46, food.getLipids().getFat_mono());
//        values.put(COL_47, food.getLipids().getFat_poly());
//        values.put(COL_48, food.getLipids().getCholestrl());
//
//
//        // Inserting Row
//        db.insert(TABLE_NAME, null, values);
//        db.close(); // Closing database connection
//    }
//
//    public List<Food1> getFoodObjects() {
//        List<Food1> foodList = new ArrayList<Food1>();
//        // Select All Query
//        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                Food1 food = new Food1();
//                food.setName(cursor.getString(1));
//
////                food.setID(Integer.parseInt(cursor.getString(0)));
////                food.getProximates().getWater();
////                food.getProximates().getEnergy();
////                food.getProximates().getProtein();
////                food.getProximates().getLipid1();
////                food.getProximates().getAsh();
////                food.getProximates().getCarbohydrate();
////                food.getProximates().getSugar();
////                food.getMinerals().getCalcium();
////                food.getMinerals().getIron();
////                food.getMinerals().getMagnesium();
////                food.getMinerals().getPhosphorus();
////                food.getMinerals().getPotassium();
////                food.getMinerals().getSodium();
////                food.getMinerals().getZinc();
////                food.getMinerals().getCopper();
////                food.getMinerals().getManganese();
////                food.getMinerals().getSelenium();
////                food.getVitamins().getVit_c();
////                food.getVitamins().getThiamin();
////                food.getVitamins().getRiboflavin();
////                food.getVitamins().getNiacin();
////                food.getVitamins().getPanto_acid();
////                food.getVitamins().getVit_b6();
////                food.getVitamins().getFolate_tot();
////                food.getVitamins().getFolic_acid();
////                food.getVitamins().getFood_folate();
////                food.getVitamins().getFood_folate_dfe();
////                food.getVitamins().getCholine_tot();
////                food.getVitamins().getVit_b12();
////                food.getVitamins().getVit_a_iu();
////                food.getVitamins().getVit_a_rae();
////                food.getVitamins().getRetinol();
////                food.getVitamins().getNiacin();
////                food.getVitamins().getApha_carot();
////                food.getVitamins().getBeta_carot();
////                food.getVitamins().getBeta_crypt();
////                food.getVitamins().getLycopene();
////                food.getVitamins().getLut_zea();
////                food.getVitamins().getVit_e();
////                food.getVitamins().getVit_d_ug();
////                food.getVitamins().getVit_d_iu();
////                food.getVitamins().getVit_k();
////                food.getLipids().getFat_sat();
////                food.getLipids().getFat_mono();
////                food.getLipids().getFat_poly();
////                food.getLipids().getCholestrl();
//
//                // Adding food to list
//                foodList.add(food);
//            } while (cursor.moveToNext());
//        }
//
//        // return food list
//        return foodList;
//    }
//
//    // Getting food Count
//    public int getFoodCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_NAME;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();
//
//        // return count
//        return cursor.getCount();
//    }
//
//    // Updating single food object
//    public int updateFood(Food1 food) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COL_2, food.getName()); // Food Name
//        values.put(COL_3, food.getProximates().getWater());
//        values.put(COL_4, food.getProximates().getEnergy());
//        values.put(COL_5, food.getProximates().getProtein());
//        values.put(COL_6, food.getProximates().getLipid1());
//        values.put(COL_7, food.getProximates().getAsh());
//        values.put(COL_8, food.getProximates().getCarbohydrate());
//        values.put(COL_9, food.getProximates().getSugar());
//        values.put(COL_10, food.getMinerals().getCalcium());
//        values.put(COL_11, food.getMinerals().getIron());
//        values.put(COL_12, food.getMinerals().getMagnesium());
//        values.put(COL_13, food.getMinerals().getPhosphorus());
//        values.put(COL_14, food.getMinerals().getPotassium());
//        values.put(COL_15, food.getMinerals().getSodium());
//        values.put(COL_16, food.getMinerals().getZinc());
//        values.put(COL_17, food.getMinerals().getCopper());
//        values.put(COL_18, food.getMinerals().getManganese());
//        values.put(COL_19, food.getMinerals().getSelenium());
//        values.put(COL_20, food.getVitamins().getVit_c());
//        values.put(COL_21, food.getVitamins().getThiamin());
//        values.put(COL_22, food.getVitamins().getRiboflavin());
//        values.put(COL_23, food.getVitamins().getNiacin());
//        values.put(COL_24, food.getVitamins().getPanto_acid());
//        values.put(COL_25, food.getVitamins().getVit_b6());
//        values.put(COL_26, food.getVitamins().getFolate_tot());
//        values.put(COL_27, food.getVitamins().getFolic_acid());
//        values.put(COL_28, food.getVitamins().getFood_folate());
//        values.put(COL_29, food.getVitamins().getFood_folate_dfe());
//        values.put(COL_30, food.getVitamins().getCholine_tot());
//        values.put(COL_31, food.getVitamins().getVit_b12());
//        values.put(COL_32, food.getVitamins().getVit_a_iu());
//        values.put(COL_33, food.getVitamins().getVit_a_rae());
//        values.put(COL_34, food.getVitamins().getRetinol());
//        values.put(COL_35, food.getVitamins().getNiacin());
//        values.put(COL_36, food.getVitamins().getApha_carot());
//        values.put(COL_37, food.getVitamins().getBeta_carot());
//        values.put(COL_38, food.getVitamins().getBeta_crypt());
//        values.put(COL_39, food.getVitamins().getLycopene());
//        values.put(COL_40, food.getVitamins().getLut_zea());
//        values.put(COL_41, food.getVitamins().getVit_e());
//        values.put(COL_42, food.getVitamins().getVit_d_ug());
//        values.put(COL_43, food.getVitamins().getVit_d_iu());
//        values.put(COL_44, food.getVitamins().getVit_k());
//        values.put(COL_45, food.getLipids().getFat_sat());
//        values.put(COL_46, food.getLipids().getFat_mono());
//        values.put(COL_47, food.getLipids().getFat_poly());
//        values.put(COL_48, food.getLipids().getCholestrl());
//
//         // updating row
////        return db.update(TABLE_NAME, values, COL_1 + " = ?",
////                new String[] { String.valueOf(food.getID()) });
//
//       //placeholder value "1"
//        return 1;
//    }
}
