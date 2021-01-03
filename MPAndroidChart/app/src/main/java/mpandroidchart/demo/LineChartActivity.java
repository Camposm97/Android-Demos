package mpandroidchart.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.LinkedList;
import java.util.List;

public class LineChartActivity extends AppCompatActivity {
    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);
        lineChart = findViewById(R.id.line_chart);
        List<Entry> list = loadData();
        LineDataSet lineDataSet1 = new LineDataSet(list, "Set 1");
        List<ILineDataSet> dataSetList = new LinkedList<>();
        dataSetList.add(lineDataSet1);
        LineData lineData = new LineData(dataSetList);
        lineChart.setData(lineData);
    }

    public List<Entry> loadData() {
        List<Entry> list = new LinkedList<>();
        list.add(new Entry(1, 10));
        list.add(new Entry(2, 7));
        list.add(new Entry(3, 4));
        list.add(new Entry(4, 6));
        list.add(new Entry(5, 8));
        list.add(new Entry(6, 14));
        list.add(new Entry(7, 5));
        list.add(new Entry(8, 7));
        list.add(new Entry(9, 11));
        list.add(new Entry(10, 1));
        return list;
    }
}