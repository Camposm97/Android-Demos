package table_layout.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Student objects (not really necessary)
        Student s1 = new Student("Jon Doe", "CSE");
        Student s2 = new Student("Jacob Smith", "ACC");
        Student s3 = new Student("Clayton Vars", "PHY");

        // Grab all the text views from the layout
        TextView tvId1 = findViewById(R.id.field_id1);
        TextView tvName1 = findViewById(R.id.field_name1);
        TextView tvMajor1 = findViewById(R.id.field_major1);
        TextView tvId2 = findViewById(R.id.field_id2);
        TextView tvName2 = findViewById(R.id.field_name2);
        TextView tvMajor2 = findViewById(R.id.field_major2);
        TextView tvId3 = findViewById(R.id.field_id3);
        TextView tvName3 = findViewById(R.id.field_name3);
        TextView tvMajor3 = findViewById(R.id.field_major3);

        // Set the text for the respective text view
        tvId1.setText(s1.getId());
        tvName1.setText(s1.getName());
        tvMajor1.setText(s1.getMajor());
        tvId2.setText(s2.getId());
        tvName2.setText(s2.getName());
        tvMajor2.setText(s2.getMajor());
        tvId3.setText(s3.getId());
        tvName3.setText(s3.getName());
        tvMajor3.setText(s3.getMajor());
    }
}