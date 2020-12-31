package recycler_view.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SearchView;

import java.util.LinkedList;
import java.util.List;

import recycler_view.demo.model.MyRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {
    private List<String> list;
    private static final String TAG = MainActivity.class.getName();
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView rv;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutManager = new LinearLayoutManager(this);
        rv = findViewById(R.id.recycler_view);
        searchView = findViewById(R.id.searchView);
        list = loadData();
        addListeners();
    }

    public void addListeners() {
        rv.setLayoutManager(layoutManager);
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d(TAG, "Search clicked");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<String> resultList = new LinkedList<>();
                for (String string : list) {
                    if (string.toLowerCase().contains(newText.toLowerCase())) {
                        resultList.add(string);
                    }
                }
                Log.d(TAG, resultList.toString()); // Print results to Logcat
                rv.setAdapter(new MyRecyclerViewAdapter(resultList)); // Set new adapter
                return false;
            }
        });
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