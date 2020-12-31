package recycler_view.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public List<String> loadData() {
        List<String> list = new LinkedList<>();
        list.add("Stony Brook University");
        list.add("Suffolk County Community College");
        list.add("Farmingdale State College");
        list.add("University at Albany");
        list.add("University of Buffalo");
        list.add("Queen's College");
        list.add("Hunter's College");
        list.add("St. Joesph's College");
        list.add("Long Island University");
        return list;
    }
}