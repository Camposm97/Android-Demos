package com.campos.demo_shared_pref;

import android.app.Application;

public class App extends Application {
    private static final String PREF_FILE = "settings";

    public static String getPrefFile() {
        return PREF_FILE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
