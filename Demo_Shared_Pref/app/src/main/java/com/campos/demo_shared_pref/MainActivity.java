package com.campos.demo_shared_pref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.campos.demo_shared_pref.Tag.T;

/**
 * NOTE:
 * SharedPreference.Editor can only save primitive types, but can can save strings and
 * a set of strings.
 * It is possible to save Objects using Gson, but the operation is expensive.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public SharedPreferences.Editor getPrefEditor() {
        return getSharedPreferences(App.getPrefFile(), MODE_PRIVATE).edit();
    }

    public String getKey() {
        return ((EditText) findViewById(R.id.edit_text_name)).getText().toString();
    }

    public String getValue() {
        return ((EditText) findViewById(R.id.edit_text_value)).getText().toString();
    }

    public void save(View v) {
        Log.d(T, "Saving...");
        String key = getKey();
        String value = getValue();
        Log.d(T, "key=" + key);
        Log.d(T, "value=" + value);
        SharedPreferences.Editor editor = getPrefEditor();
        editor.putString(key, value);
        editor.apply();
        Log.d(T, "Saved!");
    }

    public void load(View v) {
        Log.d(T, "Loading...");
        TextView tvResults = findViewById(R.id.tv_results);
        String key = getKey();
        String value = getSharedPreferences(App.getPrefFile(), MODE_PRIVATE).getString(key, "");
        if (!value.isEmpty()) {
            tvResults.setText("key=" + key + ", value=" + value);
        } else {
            tvResults.setText("Invalid key!");
        }
    }
}