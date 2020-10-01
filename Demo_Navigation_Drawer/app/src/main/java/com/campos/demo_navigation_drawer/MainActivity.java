package com.campos.demo_navigation_drawer;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private FragmentManager manager;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "savedInstanceState=" + savedInstanceState);
        initControls();
        initDisplay(savedInstanceState);
    }

    public void initControls() {
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        manager = getSupportFragmentManager();
        setSupportActionBar(toolbar); // Displays toolbar
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this); // Listener for OnNavigationItemSelected
        // Notice that this class implements NavigationView.OnNavigationItemSelectedListener, so
        // Java is ok with you passing "this" as the parameter
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_open, R.string.navigation_close);
//        drawer.addDrawerListener(toggle); // Not sure what this does, but program runs fine without it
        toggle.syncState(); // Displays toggle switch on toolbar
    }

    public void initDisplay(Bundle savedInstanceState) {
        /*
        Having this code makes it so when the app starts it sets the
        FrameLayout (fragment_container) to fragment A.  That way, there's content displayed
         */
        if (savedInstanceState == null) {
            manager.beginTransaction().replace(R.id.fragment_container, new FragmentA()).commit();
            navigationView.setCheckedItem(R.id.fragment_a);
        }
    }

    @Override // Do something if an item is clicked in drawer
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fragment_a:
                Log.d(TAG, "Switching to Fragment A");
                manager.beginTransaction().replace(R.id.fragment_container, new FragmentA()).commit();
                break;
            case R.id.fragment_b:
                Log.d(TAG, "Switching to Fragment B");
                manager.beginTransaction().replace(R.id.fragment_container, new FragmentB()).commit();
                break;
            case R.id.fragment_c:
                Log.d(TAG, "Switching to Fragment C");
                manager.beginTransaction().replace(R.id.fragment_container, new FragmentC()).commit();
                break;
            case R.id.appearance:
                Toast.makeText(this, "Apperance", Toast.LENGTH_SHORT).show();
                break;
            case R.id.advanced:
                Toast.makeText(this, "Advanced", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START); // Closes drawer after an item is selected
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
        /*
        Having this code makes it so that if the user has the drawer open, and presses
        the back button, then it will close the drawer instead of the app.
         */
    }
}