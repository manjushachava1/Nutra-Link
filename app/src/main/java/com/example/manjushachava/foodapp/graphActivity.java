//package com.example.manjushachava.foodapp;
//
//import android.content.Intent;
//import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//
//import com.github.mikephil.charting.charts.BarChart;
//import com.github.mikephil.charting.charts.PieChart;
//import com.github.mikephil.charting.components.Legend;
//import com.github.mikephil.charting.data.BarEntry;
//import com.github.mikephil.charting.data.Entry;
//import com.github.mikephil.charting.data.PieData;
//import com.github.mikephil.charting.data.PieDataSet;
//import com.github.mikephil.charting.data.PieEntry;
//import com.github.mikephil.charting.highlight.Highlight;
//import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
//
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Random;
//
//import static com.example.manjushachava.foodapp.R.id.toolbar;
//
//
//public class graphActivity extends AppCompatActivity {
//
//
//    ArrayList<Float> aphaCarot = new ArrayList<Float>();
//    ArrayList<Float> betaCarot = new ArrayList<Float>();
//    ArrayList<Float> betaCrypt = new ArrayList<Float>();
//    ArrayList<Float> cholineTot = new ArrayList<Float>();
//    ArrayList<Float> folicAcid = new ArrayList<Float>();
//    ArrayList<Float> folateTot = new ArrayList<Float>();
//    ArrayList<Float> foodFolate = new ArrayList<Float>();
//    ArrayList<Float> foodFolateDFE = new ArrayList<Float>();
//    ArrayList<Float> lutZea = new ArrayList<Float>();
//    ArrayList<Float> pantoAcid = new ArrayList<Float>();
//    ArrayList<Float> vitAIu = new ArrayList<Float>();
//    ArrayList<Float> vitARae = new ArrayList<Float>();
//    ArrayList<Float> lycopene = new ArrayList<Float>();
//    ArrayList<Float> niacin = new ArrayList<Float>();
//    ArrayList<Float> retinol = new ArrayList<Float>();
//    ArrayList<Float> vitB6 = new ArrayList<Float>();
//    ArrayList<Float> vitB12 = new ArrayList<Float>();
//    ArrayList<Float> vitC = new ArrayList<Float>();
//    ArrayList<Float> vitDIu = new ArrayList<Float>();
//    ArrayList<Float> riboflavin = new ArrayList<Float>();
//    ArrayList<Float> vitDUg = new ArrayList<Float>();
//    ArrayList<Float> vitE = new ArrayList<Float>();
//    ArrayList<Float> vitK = new ArrayList<Float>();
//    ArrayList<Float> thiamin = new ArrayList<Float>();
//
//    float[] aphaCarot1;
//    float[] betaCarot1;
//    float[] betaCrypt1;
//    float[] cholineTot1 ;
//    float[] folicAcid1  ;
//    float[] folateTot1  ;
//    float[] foodFolate1  ;
//    float[] foodFolateDFE1 ;
//    float[] lutZea1 ;
//    float[] pantoAcid1 ;
//    float[] vitAIu1 ;
//    float[] vitARae1 ;
//    float[] lycopene1 ;
//    float[] niacin1 ;
//    float[] retinol1 ;
//    float[] vitB61 ;
//    float[] vitB121 ;
//    float[] vitC1 ;
//    float[] vitDIu1 ;
//    float[] riboflavin1 ;
//    float[] vitDUg1 ;
//    float[] vitE1 ;
//    float[] vitK1 ;
//    float[] thiamin1 ;
//
//    private static String TAG = "graphActivity";
//
//    //private Float[][] yData;
//    ArrayList<Food1> foodList = new ArrayList<>();
//
//     private float[] yData = {1f,2f,3f,4f,5f,6f,7f,8f,9f,10f,11f,12f,13f,14f,15f,16f,17f,18f,19f,20f,21f,22f,23f};
//
//
//
//    PieChart pieChart;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_graph);
//
////        InputStream input = getAssets().open("TestVegFruits.csv");
////        ParseData1 parsedFile = new ParseData1(input);
////        foodList = parsedFile.allFoods();
//
//        //controller
////        final Controller aController = (Controller) getApplicationContext();
////        ArrayList<Food1> foodList = aController.getFoodList();
////     //   Integer size = foodList.size();
////
////
////        for(int i = 0; i < foodList.size(); i++){
////            Log.i("Jack :", "Food Name : " + foodList.get(i).getName());
////            Log.i("Jack : ", "foodList value : "+  foodList.get(i).getVitamins().getVit_c());
////            Log.i("Jack : ", "foodList value : "+  foodList.get(i).getVitamins().getVit_a_iu());
////            aphaCarot.add(foodList.get(i).getVitamins().getApha_carot());
////
////            betaCarot.add(foodList.get(i).getVitamins().getBeta_carot());
////            betaCrypt.add(foodList.get(i).getVitamins().getBeta_crypt());
////            cholineTot.add(foodList.get(i).getVitamins().getCholine_tot());
////            folateTot.add(foodList.get(i).getVitamins().getFolate_tot());
////            folicAcid.add(foodList.get(i).getVitamins().getFolic_acid());
////            foodFolate.add(foodList.get(i).getVitamins().getFood_folate());
////            foodFolateDFE.add(foodList.get(i).getVitamins().getFood_folate_dfe());
////            lutZea.add(foodList.get(i).getVitamins().getLut_zea());
////            pantoAcid.add(foodList.get(i).getVitamins().getPanto_acid());
////            vitAIu.add(foodList.get(i).getVitamins().getVit_a_iu());
////            vitARae.add(foodList.get(i).getVitamins().getVit_a_rae());
////            lycopene.add(foodList.get(i).getVitamins().getLycopene());
////            niacin.add(foodList.get(i).getVitamins().getNiacin());
////            retinol.add(foodList.get(i).getVitamins().getRetinol());
////            vitB6.add(foodList.get(i).getVitamins().getVit_b6());
////            vitB12.add(foodList.get(i).getVitamins().getVit_b12());
////            vitC.add(foodList.get(i).getVitamins().getVit_c());
////            vitDIu.add(foodList.get(i).getVitamins().getVit_d_iu());
////            riboflavin.add(foodList.get(i).getVitamins().getRiboflavin());
////            vitDUg.add(foodList.get(i).getVitamins().getVit_d_ug());
////            vitE.add(foodList.get(i).getVitamins().getVit_e());
////            vitK.add(foodList.get(i).getVitamins().getVit_k());
////            thiamin.add(foodList.get(i).getVitamins().getThiamin());
////
////        }
////      //  createArrayVitData();
////        ArrayList<String> vitamin = new ArrayList<>();
////        vitamin.add("Vitamin C");
////        vitamin.add("Thiamin");
////        vitamin.add("Riboflavin");
////        vitamin.add("Niacin");
////        vitamin.add("Pantothenic Acid");
////        vitamin.add("Vitamin B-6");
////        vitamin.add("Foltate, total");
////        vitamin.add("Folic Acid");
////        vitamin.add("Folate, Food");
////        vitamin.add("Folate, DFE");
////        vitamin.add("Choline");
////        vitamin.add("Vitamin B-12");
////        vitamin.add("Vitamin A, IU");
////        vitamin.add("Retinol");
////        vitamin.add("Vitamin A, RAE");
////        vitamin.add("Protein");
////        vitamin.add("Carotene, alpha");
////        vitamin.add("Carotene, beta");
////        vitamin.add("Cryptoxanthin, beta");
////        vitamin.add("Lycopene");
////        vitamin.add("Lutein + Zeaxanthin");
////        vitamin.add("Vitamin E");
////        vitamin.add("Vitamin D, IU");
////        vitamin.add("Vitamin K");
////        Collections.sort(vitamin);
////
////
////      // yData = new Float[vitamin.size()];
////
////
////       Float[][] yData = {aphaCarot.toArray(new Float[0]),
////       betaCarot.toArray(new Float[0]),
////       betaCrypt.toArray(new Float[0]),
////       cholineTot.toArray(new Float[0]),
////       folicAcid.toArray(new Float[0]),
////       folateTot.toArray(new Float[0]),
////       foodFolate.toArray(new Float[0]),
////       foodFolateDFE.toArray(new Float[0]),
////       lutZea.toArray(new Float[0]),
////       pantoAcid.toArray(new Float[0]),
////       vitAIu.toArray(new Float[0]),
////       vitARae.toArray(new Float[0]),
////       lycopene.toArray(new Float[0]),
////       niacin.toArray(new Float[0]),
////       retinol.toArray(new Float[0]),
////       vitB6.toArray(new Float[0]),
////       vitB12.toArray(new Float[0]),
////       vitC.toArray(new Float[0]),
////       vitDIu.toArray(new Float[0]),
////       riboflavin.toArray(new Float[0]),
////       vitDUg.toArray(new Float[0]),
////       vitE.toArray(new Float[0]),
////       vitK.toArray(new Float[0]),
////       thiamin.toArray(new Float[0])};
//
//        pieChart = (PieChart) findViewById(R.id.idPieChart);
//
//        pieChart.setRotationEnabled(true);
//        pieChart.setHoleRadius(25f);
//        pieChart.setTransparentCircleAlpha(0);
//        pieChart.setCenterText("Graph of Vitamins");
//        pieChart.setCenterTextSize(10);
//        pieChart.setDrawEntryLabels(true);
//
//        addDataSet();
//
//        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
//            @Override
//            public void onValueSelected(Entry e, Highlight h) {
//                Log.d(TAG, "onValueSelected: Value selected from chart.");
//                Log.d(TAG, "onValueSelected: " + e.toString());
//                Log.d(TAG, "onValueSelected: " + h.toString());
//            }
//
//            @Override
//            public void onNothingSelected() {
//
//            }
//        });
//
//
////        toolbar = (Toolbar) findViewById(toolbar);
////
////        Bundle bundle = getIntent().getExtras();
////        if(bundle != null){
////            toolbar.setTitle(bundle.getString("FoodName"));
////        }
//
////        barChart = (BarChart) findViewById(R.id.bargraph);
////
////        ArrayList<String> vitamin = new ArrayList<>();
////        vitamin.add("Vitamin C");
////        vitamin.add("Thiamin");
////        vitamin.add("Riboflavin");
////        vitamin.add("Niacin");
////        vitamin.add("Pantothenic Acid");
////        vitamin.add("Vitamin B-6");
////        vitamin.add("Foltate, total");
////        vitamin.add("Folic Acid");
////        vitamin.add("Folate, Food");
////        vitamin.add("Folate, DFE");
////        vitamin.add("Choline");
////        vitamin.add("Vitamin B-12");
////        vitamin.add("Vitamin A, IU");
////        vitamin.add("Retinol");
////        vitamin.add("Vitamin A, RAE");
////        vitamin.add("Protein");
////        vitamin.add("Carotene, alpha");
////        vitamin.add("Carotene, beta");
////        vitamin.add("Cryptoxanthin, beta");
////        vitamin.add("Lycopene");
////        vitamin.add("Lutein + Zeaxanthin");
////        vitamin.add("Vitamin E");
////        vitamin.add("Vitamin D, IU");
////        vitamin.add("Vitamin K");
////        Collections.sort(vitamin);
//
////
////            barEntries.add(new BarEntry((float)aphaCarot, i));
////            barEntries.add(new BarEntry((float)betaCarot, i));
////            barEntries.add(new BarEntry((float)betaCrypt, i));
////            barEntries.add(new BarEntry((float)cholineTot, i));
////            barEntries.add(new BarEntry((float)folateTot, i));
////            barEntries.add(new BarEntry((float)folicAcid, i));
////            barEntries.add(new BarEntry((float)foodFolate, i));
////            barEntries.add(new BarEntry((float)foodFolateDfe, i));
////            barEntries.add(new BarEntry((float)lutZea, i));
////            barEntries.add(new BarEntry((float)lycopene, i));
////            barEntries.add(new BarEntry((float)niacin, i));
////            barEntries.add(new BarEntry((float)panto_acid, i));
////            barEntries.add(new BarEntry((float)retinol, i));
////            barEntries.add(new BarEntry((float)riboflavin, i));
////            barEntries.add(new BarEntry((float)thiamin, i));
////            barEntries.add(new BarEntry((float)vitAIu, i));
////            barEntries.add(new BarEntry((float)vitARae, i));
////            barEntries.add(new BarEntry((float)vitB6, i));
////            barEntries.add(new BarEntry((float)vitB12, i));
////            barEntries.add(new BarEntry((float)vitC, i));
////            barEntries.add(new BarEntry((float)vitDIu, i));
////            barEntries.add(new BarEntry((float)vitDUg, i));
////            barEntries.add(new BarEntry((float)vitE, i));
////            barEntries.add(new BarEntry((float)vitK, i));
////        }
////        BarDataSet barDataSet = new BarDataSet(barEntries,"data");
////
////        BarData theData = new BarData(barDataSet,barDataSet);
////        barChart.setData(theData);
////        barChart.setTouchEnabled(true);
//
////        barChart = (BarChart) findViewById(R.id.bargraph);
////
////        double calcium = foodList.get(0).getMinerals().getCalcium();
////        double copper = foodList.get(0).getMinerals().getCalcium();
////        double iron = foodList.get(0).getMinerals().getIron();
////        double magnesium = foodList.get(0).getMinerals().getMagnesium();
////        double manganese = foodList.get(0).getMinerals().getManganese();
////        double phosphorus = foodList.get(0).getMinerals().getPhosphorus();
////        double potassium = foodList.get(0).getMinerals().getPotassium();
////        double selenium = foodList.get(0).getMinerals().getSelenium();
////        double sodium = foodList.get(0).getMinerals().getSodium();
////        double zinc = foodList.get(0).getMinerals().getZinc();
//
////        float cal = (float) calcium;
////
////        ArrayList<BarEntry> barEntries = new ArrayList<>();
////
////
//////        barEntries.add(new BarEntry((float)calcium, 0));
//////        barEntries.add(new BarEntry((float)copper, 1));
//////        barEntries.add(new BarEntry((float)iron, 2));
//////        barEntries.add(new BarEntry((float)magnesium, 3));
//////        barEntries.add(new BarEntry((float)manganese, 4));
//////        barEntries.add(new BarEntry((float)phosphorus, 5));
//////        barEntries.add(new BarEntry((float)potassium, 6));
//////        barEntries.add(new BarEntry((float)selenium, 7));
//////        barEntries.add(new BarEntry((float)sodium, 8));
//////        barEntries.add(new BarEntry((float)zinc, 9));
////        barEntries.add(new BarEntry(44f, 0));
////
////
////        BarDataSet barDataSet = new BarDataSet(barEntries,"data");
////
////
////        BarData theData = new BarData(barDataSet,barDataSet);
////        barChart.setData(theData);
////        barChart.setTouchEnabled(true);
//
//
//
//
//      }
//      public void addDataSet(){
//          Log.d(TAG,"addDataSet started");
//          ArrayList<PieEntry> yEntry = new ArrayList<>();
//          ArrayList<PieEntry> xEntry = new ArrayList<>();
//
//          for(int i = 0; i < yData.length; i++){
//              yEntry.add(new PieEntry(yData[i],i));
//          }
////          for(int i = 0; i < xData.length; i++){
////              xEntry.add(xData[i]);
////          }
//
//          //create the data set
//          PieDataSet pieDataSet = new PieDataSet(yEntry,"Vitamins");
//          pieDataSet.setSliceSpace(1);
//          pieDataSet.setValueTextSize(12);
//
//          //add legend
//          Legend legend = pieChart.getLegend();
//          legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);
//
//          //create pie data object
//          PieData pieData = new PieData(pieDataSet);
//          pieChart.setData(pieData);
//          pieChart.invalidate();
//
//          //add color
//          ArrayList<Integer> colors = new ArrayList<>();
//          for(int i = 0; i < yData.length; i++ ) {
//              Random rand = new Random();
//              int r = rand.nextInt(255);
//              int g = rand.nextInt(255);
//              int b = rand.nextInt(255);
//              int randomColor = Color.rgb(r,g,b);
//              colors.add(randomColor);
//          }
//          pieDataSet.setColors(colors);
//      }
//
//    //takes in arraylists of vitamins and creates arrays
//    public void createArrayVitData(){
//
//        int sizeOfList = aphaCarot.size();
//        float[] a = new float[sizeOfList];
//        for(int i = 0; i < a.length; i++){
//            a[i] = aphaCarot.get(i);
//        }
//        aphaCarot1 = a;
//
//        float[] b = new float[sizeOfList];
//        for(int i = 0; i < b.length; i++){
//            b[i] = betaCarot.get(i);
//        }
//        betaCarot1 = b;
//
//        float[] c = new float[sizeOfList];
//        for(int i = 0; i < c.length; i++){
//            c[i] = betaCrypt.get(i);
//        }
//        betaCrypt1 = c;
//
//        float[] d = new float[sizeOfList];
//        for(int i = 0; i < d.length; i++){
//            d[i] = cholineTot.get(i);
//        }
//        cholineTot1 = d;
//
//        float[] e = new float[sizeOfList];
//        for(int i = 0; i < e.length; i++){
//            e[i] = folicAcid.get(i);
//        }
//        folicAcid1 = e;
//
//        float[] f = new float[sizeOfList];
//        for(int i = 0; i < f.length; i++){
//            f[i] = folateTot.get(i);
//        }
//        folateTot1 = f;
//
//        float[] g = new float[sizeOfList];
//        for(int i = 0; i < g.length; i++){
//            g[i] = foodFolate.get(i);
//        }
//        foodFolate1 = g;
//
//        float[] h = new float[sizeOfList];
//        for(int i = 0; i < h.length; i++){
//            h[i] = foodFolateDFE.get(i);
//        }
//        foodFolateDFE1 = h;
//
//        float[] j = new float[sizeOfList];
//        for(int i = 0; i < j.length; i++){
//            j[i] = lutZea.get(i);
//        }
//        lutZea1 = j;
//
//        float[] k = new float[sizeOfList];
//        for(int i = 0; i < k.length; i++){
//            k[i] = pantoAcid.get(i);
//        }
//        pantoAcid1 = k;
//
//        float[] l = new float[sizeOfList];
//        for(int i = 0; i < l.length; i++){
//            l[i] = vitAIu.get(i);
//        }
//        vitAIu1 = l;
//
//        float[] m = new float[sizeOfList];
//        for(int i = 0; i < m.length; i++){
//            m[i] = vitARae.get(i);
//        }
//        vitARae1 = m;
//
//        float[] n = new float[sizeOfList];
//        for(int i = 0; i < n.length; i++){
//            n[i] = lycopene.get(i);
//        }
//        lycopene1 = n;
//
//        float[] o = new float[sizeOfList];
//        for(int i = 0; i < o.length; i++){
//            o[i] = niacin.get(i);
//        }
//        niacin1 = o;
//
//        float[] p = new float[sizeOfList];
//        for(int i = 0; i < p.length; i++){
//            p[i] = retinol.get(i);
//        }
//        retinol1 = p;
//
//        float[] q = new float[sizeOfList];
//        for(int i = 0; i < q.length; i++){
//            q[i] = vitB6.get(i);
//        }
//        vitB61 = q;
//
//        float[] r = new float[sizeOfList];
//        for(int i = 0; i < r.length; i++){
//            r[i] = vitB12.get(i);
//        }
//        vitB121 = r;
//
//        float[] s = new float[sizeOfList];
//        for(int i = 0; i < s.length; i++){
//            s[i] = vitC.get(i);
//        }
//        vitC1 = s;
//
//        float[] t = new float[sizeOfList];
//        for(int i = 0; i < t.length; i++){
//            t[i] = vitDIu.get(i);
//        }
//        vitDIu1 = t;
//
//        float[] u = new float[sizeOfList];
//        for(int i = 0; i < u.length; i++){
//            u[i] = riboflavin.get(i);
//        }
//        riboflavin1 = u;
//
//        float[] v = new float[sizeOfList];
//        for(int i = 0; i < v.length; i++){
//            v[i] = vitDUg.get(i);
//        }
//        vitDUg1 = v;
//
//        float[] w = new float[sizeOfList];
//        for(int i = 0; i < w.length; i++){
//            w[i] = vitE.get(i);
//        }
//        vitE1 = w;
//
//        float[] x = new float[sizeOfList];
//        for(int i = 0; i < x.length; i++){
//            x[i] = vitK.get(i);
//        }
//        vitK1 = x;
//
//        float[] y = new float[sizeOfList];
//        for(int z = 0; z < y.length; z++){
//            y[z] = thiamin.get(z);
//        }
//        thiamin1 = y;
//    }
//}
