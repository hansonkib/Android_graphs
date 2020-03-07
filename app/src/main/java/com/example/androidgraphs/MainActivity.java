package com.example.androidgraphs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PieChart pieChart;
    private BarChart groupedChart;
    private LineChart lineChart;
    private ScatterChart scatterChart;
    float barWidth;
    float barSpace;
    float groupSpace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart=findViewById(R.id.piechart);
        lineChart=findViewById(R.id.line_chart);
        scatterChart=findViewById(R.id.scatterchart);
        groupedChart=findViewById(R.id.groupedChart);
        addPieChart();
        addlineChart();
        addScatterChart();
        addGroupedChart();
    }
    private void addlineChart(){
        float s1,s2,s3,s4,s5;
        s1=45;
        s2=78;
        s3=48;
        s4=23;
        s5=72;
        ArrayList yVals=new ArrayList();
        yVals.add(new Entry(1, s1));
        yVals.add(new Entry(2, s2));
        yVals.add(new Entry(3, s3));
        yVals.add(new Entry(4, s4));
        yVals.add(new Entry(5, s5));
        String xData[]={"hanson","kip","sank","john","jb"};
//        lineChart.setDescription("this is line chart");
//        ArrayList<Entry> yEntrys=new ArrayList<>();
//        ArrayList<String> xEntrys=new ArrayList<>();
//        for (int i =0; i < yData.length; i++){
//            yEntrys.add(new Entry(yData[i],i));
//        }
//        for (int i =0; i < xData.length; i++){
//            xEntrys.add(xData[i]);
//        }
        //creating datasets
        LineDataSet lineDataSet=new LineDataSet(yVals,"bar data summary");
        lineDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //creating line data
        LineData lineData=new LineData(lineDataSet);
        lineData.setValueTextSize(13f);
        lineData.setValueTextColor(Color.BLACK);
        lineChart.setData(lineData);

        lineChart.getAxisLeft().setAxisMaximum(100f);
        lineChart.getAxisRight().setEnabled(false);
        XAxis xAxis=lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(true);
//        xAxis.setLabelRotationAngle(-90);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(
                xData));
        lineChart.invalidate();
    }
    private void addScatterChart() {
        scatterChart.setDescription(null);
        scatterChart.setPinchZoom(false);
        scatterChart.setScaleEnabled(false);
        scatterChart.setDrawGridBackground(false);
        ArrayList xVals=new ArrayList();
        xVals.add("chapati");
        xVals.add("bread");
        xVals.add("beef");
        xVals.add("rice");
        xVals.add("coffee");
        float s1,s2,s3,s4,s5;
        s1=12;
        s2=37;
        s3=48;
        s4=65;
        s5=77;

        ArrayList yVals=new ArrayList();
        yVals.add(new Entry(1, s1));
        yVals.add(new Entry(2, s2));
        yVals.add(new Entry(3, s3));
        yVals.add(new Entry(4, s4));
        yVals.add(new Entry(5, s5));
        //creating datasets
        ScatterDataSet scatterDataSet =new ScatterDataSet(yVals,"diseases encountered");
        scatterDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //creating line data
        ScatterData scatterData =new ScatterData(scatterDataSet);
        scatterData.setValueTextSize(13f);
        scatterData.setValueTextColor(Color.BLACK);
        scatterChart.setData(scatterData);
        scatterChart.getAxisLeft().setAxisMaximum(100f);
        scatterChart.getAxisRight().setEnabled(false);
//        s.getXAxis().setAxisMinimum(0f);
        //        Xaxis
        XAxis xAxis=scatterChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(true);
//        xAxis.setLabelRotationAngle(-90);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(
                xVals));


        scatterChart.invalidate();
    }

    private void addPieChart() {
        int s1=22;
        int s2=42;
        int s3=89;
        int s4=48;
        int s5=52;
        final float yData[]={s1,s2,s3,s4,s5};
        final String xData[]={"hanson","kip","snk","john","jb"};
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("meals summary");
        pieChart.setCenterTextSize(10);
        pieChart.setDrawEntryLabels(true);


        //pie chart onclick starts here
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                int pos1=e.toString().indexOf("(sum): ");
                String summary=e.toString().substring(pos1 + 7);
                for (int i = 0;i < yData.length; i++){
                    if (yData[i] == Float.parseFloat(summary)){
                        pos1 = i;
                        break;
                    }
                }
                String lunch=xData[pos1 + 1];
                Toast.makeText(MainActivity.this,"food type:\t"+lunch+"\n"+summary+"\tstudents takes this type of food",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
        //pie chart onclick starts here

        ArrayList<PieEntry> yEntrys=new ArrayList<>();
        ArrayList<String> xEntrys =new ArrayList<>();
        for (int i = 0 ;i < yData.length; i++){
            yEntrys.add(new PieEntry(yData[i],xData[i]));
        }
        for (int i = 0 ;i < xData.length; i++){
            xEntrys.add(xData[i]);
        }
//        creating datasets
        PieDataSet pieDataSet=new PieDataSet(yEntrys,"meals summary");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);
        //adding colors to the dataset
        ArrayList<Integer> color=new ArrayList<>();
        color.add(Color.BLUE);
        color.add(Color.GREEN);
        color.add(Color.GRAY);
        color.add(Color.RED);
        color.add(Color.YELLOW);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //adding legend to the chart
        Legend legend=pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        ArrayList<String> items=new ArrayList<>();
        items.add("chapati");
        items.add("bread");
        items.add("beef");
        items.add("rice");
        items.add("coffee");
//    legend.setComputedLabels(items);
//    legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);
        //creating pie data
        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.animateXY(5000,5000);
        pieChart.invalidate();
    }

    private void addGroupedChart(){
        barWidth=0.3f;
        barSpace=0f;
        groupSpace=0.4f;
        groupedChart.setDescription(null);
        groupedChart.setPinchZoom(false);
        groupedChart.setScaleEnabled(false);
        groupedChart.setDrawBarShadow(false);
        groupedChart.setDrawGridBackground(false);
        int grouCount=5;
        ArrayList xVals=new ArrayList();
        xVals.add("hanson");
        xVals.add("kip");
        xVals.add("sang");
        xVals.add("john");
        xVals.add("jm");
        float s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
        s1=10;
        s2=23;
        s3=12;
        s4=25;
        s5=74;
        s6=34;
        s7=15;
        s8=78;
        s9=10;
        s10=44;

        ArrayList yVals1=new ArrayList();
        ArrayList yVals2=new ArrayList();
        yVals1.add(new BarEntry(1,(float) s1));
        yVals2.add(new BarEntry(1,(float) s6));
        yVals1.add(new BarEntry(2,(float) s2));
        yVals2.add(new BarEntry(2,(float) s7));
        yVals1.add(new BarEntry(3,(float) s3));
        yVals2.add(new BarEntry(3,(float) s8));
        yVals1.add(new BarEntry(4,(float) s4));
        yVals2.add(new BarEntry(4,(float) s9));
        yVals1.add(new BarEntry(5,(float) s5));
        yVals2.add(new BarEntry(5,(float) s10));
        BarDataSet set1,set2;
        set1=new BarDataSet(yVals1,"names");
        set1.setColor(Color.RED);
        set2=new BarDataSet(yVals2,"frequency");
        set2.setColor(Color.BLUE);
        BarData data=new BarData(set1,set2);
        data.setValueFormatter(new LargeValueFormatter());
        groupedChart.setData(data);
        groupedChart.getBarData().setBarWidth(barWidth);
        groupedChart.getXAxis().setAxisMinimum(0);
        groupedChart.getXAxis().setAxisMaximum(0 + groupedChart.getBarData().getGroupWidth(groupSpace,barSpace) * grouCount);
        groupedChart.groupBars(0, groupSpace, barSpace);
        Legend l = groupedChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(true);
        l.setYOffset(20f);
        l.setXOffset(0f);
        l.setYEntrySpace(0f);
        l.setTextSize(8f);
//        x-axia
        XAxis xAxis=groupedChart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisMaximum(5);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));
//        y-xAxis
        groupedChart.getAxisRight().setEnabled(false);
        YAxis leftAxis=groupedChart.getAxisLeft();
        leftAxis.setValueFormatter(new LargeValueFormatter());
        leftAxis.setDrawGridLines(true);
        leftAxis.setSpaceTop(35f);
        leftAxis.setAxisMinimum(0f);
        groupedChart.animateY(5000);
    }
}
