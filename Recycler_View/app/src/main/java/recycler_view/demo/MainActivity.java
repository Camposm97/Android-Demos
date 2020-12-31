package recycler_view.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.SearchView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import recycler_view.demo.model.MyRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {
    private static List<String> list = new LinkedList<>();
    private static final String TAG = MainActivity.class.getName();
    private RecyclerView.LayoutManager layoutManager; // A RecyclerView needs to have a LayoutManager in order to display the contents, without, nothing will display on the RecyclerView
    private RecyclerView rv;
    private SearchView searchView; // Look at XML (activity_main.xml) to see what attributes I gave search view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData(list); // Pass list to fill with data
        layoutManager = new LinearLayoutManager(this); // init LayoutManager using LinearLayoutManager
        rv = findViewById(R.id.recycler_view); // get the view and set it equal to rv
        rv.setLayoutManager(layoutManager); // set layout manager
        searchView = findViewById(R.id.searchView); // get the view and set it equal to searchview
        addListeners();
    }

    public void addListeners() {
        // add listener for searchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { // Occurs when the blue button on the keyboard is pressed
                Log.d(TAG, "Search Clicked");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) { // Occurs when text in the SearchView is changed
                if (!newText.isEmpty()) { // check if the text is empty
                    List<String> resultList = filterList(newText); // filter list calling method I wrote
                    Log.d(TAG, resultList.toString()); // Print results to Logcat
                    rv.setAdapter(new MyRecyclerViewAdapter(resultList)); // Set new adapter
                }
                return false;
            }
        });
    }

    public List<String> filterList(String phrase) {
        // It's not the best filter method, since we can only use Java 7 which has no streams.
        // This is because this project's minimum Android SDK version is not 26.  Android SDK 26 let's use use Java 8 features
        List<String> resultList = new LinkedList<>();
        for (String string : list) {
            if (string.toLowerCase().contains(phrase.toLowerCase())) {
                if (!resultList.contains(string)) {
                    resultList.add(string);
                }
            }
        }
        return resultList;
    }

    public void loadData(List<String> list) { // data to be filterd when user starts searching
        list.add("Stony Brook University");
        list.add("Suffolk County Community College");
        list.add("Farmingdale State College");
        list.add("University at Albany");
        list.add("University of Buffalo");
        list.add("Queen's College");
        list.add("Hunter's College");
        list.add("St. Joesph's College");
        list.add("Long Island University");
    }
}