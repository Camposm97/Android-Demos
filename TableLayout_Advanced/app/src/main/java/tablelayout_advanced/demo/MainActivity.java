package tablelayout_advanced.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TableLayout myTableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.myTableLayout = findViewById(R.id.my_table_layout); // assign TableLayout
    }

    public void addStudent(View v) {
        // Get input from text fields in GUI
        EditText fieldName = findViewById(R.id.field_student_name);
        EditText fieldMajor = findViewById(R.id.field_student_major);
        String name = fieldName.getText().toString();
        String major = fieldMajor.getText().toString();

        // Create Student Object
        Student student = new Student(name, major);

        // Create a TableRow object from layout source folder
        TableRow tableRow = (TableRow) LayoutInflater.from(this).inflate(R.layout.student_row, null);

        // Get TextView objects from TableRow
        TextView tvId = tableRow.findViewById(R.id.tv_id);
        TextView tvName = tableRow.findViewById(R.id.tv_name);
        TextView tvMajor = tableRow.findViewById(R.id.tv_major);

        // Set texts for the respective TextView object
        tvId.setText(student.getId());
        tvName.setText(student.getName());
        tvMajor.setText(student.getMajor());

        // Add a listener when table row is clicked
        tableRow.setOnClickListener(event -> {
            Toast.makeText(MainActivity.this, name + "(" + major + ")", Toast.LENGTH_SHORT).show();
        });

        // Add TableRow object to myTableLayout
        myTableLayout.addView(tableRow);
    }
}