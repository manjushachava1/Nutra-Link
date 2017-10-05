//package com.example.manjushachava.foodapp;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import java.util.ResourceBundle;
//
///**
// * Created by Manjusha Chava on 6/1/2017.
// */
//
//public class DatabaseHandler extends SQLiteOpenHelper {
//
//    public static final String DATABASE_NAME = "Vegetable_Fruit";
//    public static final String TABLE_NAME = "VegetableFruit ";
//    public static final String ID = "ID";
//    public static final String DESCRIPTION = "DESCRIPTION";
//    public static final String WATER = "WATER";
//    public static final String ENERGY = "ENERGY";
//    public static final String PROTEIN = "PROTEIN";
//    public static final String LIPID = "LIPID";
//    public static final String ASH = "ASH";
//    public static final String CARBOHYDRATE = "CARBOHYDRATE";
//    public static final String FIBER = "FIBER";
//    public static final String SUGAR = "SUGAR";
//    public static final String CALCIUM = "CALCIUM";
//    public static final String IRON = "IRON";
//    public static final String MAGNESIUM = "MAGNESIUM";
//    public static final String PHOSPHORUS = "PHOSPHORUS";
//    public static final String POTASSIUM = "POTASSIUM";
//    public static final String SODIUM = "SODIUM";
//    public static final String ZINC = "ZINC";
//    public static final String COPPER = "COPPER";
//    public static final String MANGANESE = "MANGANESE";
//    public static final String SELENIUM = "SELENIUM";
//    public static final String VITAMIN_C = "VITAMIN_C";
//    public static final String THIAMIN = "THIAMIN";
//    public static final String RIBOFLAVIN = "RIBOFLAVIN";
//    public static final String NIACIN = "NIACIN";
//    public static final String PANTO_ACID = "PANTO_ACID";
//    public static final String VITAMIN_B6 = "VITAMIN_B6";
//    public static final String FOLATE = "FOLATE";
//    public static final String FOLIC_ACID = "FOLIC_ACID";
//    public static final String FOOD_FOLATE = "FOOD_FOLATE";
//    public static final String FOLATE_DFE = "FOLATE_DFE";
//    public static final String CHOLINE = "CHOLINE";
//    public static final String VITAMIN_B12 = "VITAMIN_B12";
//    public static final String VITAMIN_A_IU = "VITAMIN_A_IU";
//    public static final String VITAMIN_A_RAE = "VITAMIN_A_RAE";
//    public static final String RETINOL = "RETINOL";
//    public static final String ALPHA_CAROT = "ALPHA_CAROT";
//    public static final String BETA_CAROT = "BETA_CAROT";
//    public static final String BETA_CRYPT = "BETA_CRYPT";
//    public static final String LYCOPENE = "LYCOPENE";
//    public static final String LUT_ZEA = "LUT_ZEA";
//    public static final String VITAMIN_E = "VITAMIN_E";
//    public static final String VITAMIN_D = "VITAMIN_D";
//    public static final String VITAMIN_D_IU = "VITAMIN_D_IU";
//    public static final String VITAMIN_K = "VITAMIN_K";
//    public static final String FAT_SAT = "FAT_SAT";
//    public static final String FAT_MONO = "FAT_MONO";
//    public static final String FAT_POLY = "FAT_POLY";
//    public static final String CHOLESTEROL = "CHOLESTEROL";
//
//    private SQLiteDatabase database;
//    private String nameNutrient;
//
//    final Controller controller = new Controller();
//
//    public DatabaseHandler(Context context) {
//        super(context, DATABASE_NAME, null, 1);
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        //gets the name of the nutrient so that it can be used to find the correlating nutrient in SQL table
//        //Ex. bundle = iron... iron goes to nameNutrient... input into SQL Query
//        nameNutrient = controller.getNutrientName();
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE " + TABLE_NAME + "("
//                +ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"
//                +DESCRIPTION + "TEXT,"
//                +WATER+ "DOUBLE,"
//                +ENERGY+ "DOUBLE,"
//                +PROTEIN + "DOUBLE,"
//                +LIPID + "DOUBLE,"
//                +ASH + "DOUBLE,"
//                +CARBOHYDRATE + "DOUBLE,"
//                +FIBER + "DOUBLE,"
//                +SUGAR + "DOUBLE,"
//                +CALCIUM + "DOUBLE,"
//                +IRON + "DOUBLE,"
//                +MAGNESIUM + "DOUBLE,"
//                +PHOSPHORUS + "DOUBLE,"
//                +POTASSIUM + "DOUBLE,"
//                +SODIUM + "DOUBLE,"
//                +ZINC + "DOUBLE,"
//                +COPPER + "DOUBLE,"
//                +MANGANESE + "DOUBLE,"
//                +SELENIUM + "DOUBLE,"
//                +VITAMIN_C + "DOUBLE,"
//                +THIAMIN + "DOUBLE,"
//                +RIBOFLAVIN + "DOUBLE,"
//                +NIACIN + "DOUBLE,"
//                +PANTO_ACID + "DOUBLE,"
//                +VITAMIN_B6 + "DOUBLE,"
//                +FOLATE + "DOUBLE,"
//                +FOLIC_ACID + "DOUBLE,"
//                +FOLATE_DFE + "DOUBLE,"
//                +CHOLINE + "DOUBLE,"
//                +VITAMIN_B12 + "DOUBLE,"
//                +VITAMIN_A_IU + "DOUBLE,"
//                +VITAMIN_A_RAE + "DOUBLE,"
//                +RETINOL + "DOUBLE,"
//                +ALPHA_CAROT + "DOUBLE,"
//                +BETA_CAROT + "DOUBLE,"
//                +LYCOPENE + "DOUBLE,"
//                +LUT_ZEA + "DOUBLE,"
//                +VITAMIN_E + "DOUBLE,"
//                +VITAMIN_D + "DOUBLE,"
//                +VITAMIN_D_IU + "DOUBLE,"
//                +VITAMIN_K + "DOUBLE,"
//                +FAT_SAT + "DOUBLE,"
//                +FAT_MONO + "DOUBLE,"
//                +FAT_POLY + "DOUBLE,"
//                +CHOLESTEROL + "DOUBLE,"+")");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//    }
//
//    String topTenQuery = "SELECT * FROM "+ TABLE_NAME +"ORDER BY" + nameNutrient + "DESC LIMIT 10";
////
////    // Getting food Count
////    public int getFoodCount() {
////        String countQuery = "SELECT  * FROM " + TABLE_NAME;
////        SQLiteDatabase db = this.getReadableDatabase();
////        Cursor cursor = db.rawQuery(countQuery, null);
////        cursor.close();
////
////        // return count
////        return cursor.getCount();
////    }
////
////    // Updating single food object
////    public int updateFood(Food1 food) {
////        SQLiteDatabase db = this.getWritableDatabase();
////
////        ContentValues values = new ContentValues();
////        values.put(COL_2, food.getName()); // Food Name
////        values.put(COL_3, food.getProximates().getWater());
////        values.put(COL_4, food.getProximates().getEnergy());
////        values.put(COL_5, food.getProximates().getProtein());
////        values.put(COL_6, food.getProximates().getLipid1());
////        values.put(COL_7, food.getProximates().getAsh());
////        values.put(COL_8, food.getProximates().getCarbohydrate());
////        values.put(COL_9, food.getProximates().getSugar());
////        values.put(COL_10, food.getMinerals().getCalcium());
////        values.put(COL_11, food.getMinerals().getIron());
////        values.put(COL_12, food.getMinerals().getMagnesium());
////        values.put(COL_13, food.getMinerals().getPhosphorus());
////        values.put(COL_14, food.getMinerals().getPotassium());
////        values.put(COL_15, food.getMinerals().getSodium());
////        values.put(COL_16, food.getMinerals().getZinc());
////        values.put(COL_17, food.getMinerals().getCopper());
////        values.put(COL_18, food.getMinerals().getManganese());
////        values.put(COL_19, food.getMinerals().getSelenium());
////        values.put(COL_20, food.getVitamins().getVit_c());
////        values.put(COL_21, food.getVitamins().getThiamin());
////        values.put(COL_22, food.getVitamins().getRiboflavin());
////        values.put(COL_23, food.getVitamins().getNiacin());
////        values.put(COL_24, food.getVitamins().getPanto_acid());
////        values.put(COL_25, food.getVitamins().getVit_b6());
////        values.put(COL_26, food.getVitamins().getFolate_tot());
////        values.put(COL_27, food.getVitamins().getFolic_acid());
////        values.put(COL_28, food.getVitamins().getFood_folate());
////        values.put(COL_29, food.getVitamins().getFood_folate_dfe());
////        values.put(COL_30, food.getVitamins().getCholine_tot());
////        values.put(COL_31, food.getVitamins().getVit_b12());
////        values.put(COL_32, food.getVitamins().getVit_a_iu());
////        values.put(COL_33, food.getVitamins().getVit_a_rae());
////        values.put(COL_34, food.getVitamins().getRetinol());
////        values.put(COL_35, food.getVitamins().getNiacin());
////        values.put(COL_36, food.getVitamins().getApha_carot());
////        values.put(COL_37, food.getVitamins().getBeta_carot());
////        values.put(COL_38, food.getVitamins().getBeta_crypt());
////        values.put(COL_39, food.getVitamins().getLycopene());
////        values.put(COL_40, food.getVitamins().getLut_zea());
////        values.put(COL_41, food.getVitamins().getVit_e());
////        values.put(COL_42, food.getVitamins().getVit_d_ug());
////        values.put(COL_43, food.getVitamins().getVit_d_iu());
////        values.put(COL_44, food.getVitamins().getVit_k());
////        values.put(COL_45, food.getLipids().getFat_sat());
////        values.put(COL_46, food.getLipids().getFat_mono());
////        values.put(COL_47, food.getLipids().getFat_poly());
////        values.put(COL_48, food.getLipids().getCholestrl());
////
////         // updating row
//////        return db.update(TABLE_NAME, values, COL_1 + " = ?",
//////                new String[] { String.valueOf(food.getID()) });
////
////       //placeholder value "1"
////        return 1;
////    }
//}
