package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList barArrayList;
    String[] labels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        labels = new String[] {"Tes1", "tes 2", "tes 3", "tes4", "tes 5"};


        final ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("Sun");
        xAxisLabel.add("Mon");
        xAxisLabel.add("Tue");
        xAxisLabel.add("Wed");
        xAxisLabel.add("Thu");
//        xAxisLabel.add("Fri");
//        xAxisLabel.add("Sat");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BarChart barChart = findViewById(R.id.tryBarchart);
        getData();
        BarDataSet barDataSet = new BarDataSet(barArrayList, "Trying out Bar Charts");

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);

        ValueFormatter formatter = new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return xAxisLabel.get((int) value);
            }
        };
         xAxis.setGranularity(1f);
         xAxis.setValueFormatter(formatter);

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextColor(android.R.color.black);
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(true);
        List<Integer> colors = new Lis
        barChart.setXAxisRenderer(new ColoredLabelXAxisRenderer(barChart.getViewPortHandler(), barChart.getXAxis(), barChart.getTransformer(YAxis.AxisDependency.LEFT), colors));

//        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));







    }

    private void getData(){
        barArrayList = new ArrayList();
        barArrayList.add((new BarEntry(0, 14, "hello")));
        barArrayList.add((new BarEntry(1, 18)));
        barArrayList.add((new BarEntry(2, 24)));
        barArrayList.add((new BarEntry(3, 22)));
        barArrayList.add((new BarEntry(4, 16)));
    }
}

