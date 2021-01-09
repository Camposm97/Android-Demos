package tablelayout_advanced.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TableLayout myTableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.myTableLayout = findViewById(R.id.my_table_layout);
    }

    public void addStudent(View v) {
        EditText fieldName = findViewById(R.id.field_student_name);
        EditText fieldMajor = findViewById(R.id.field_student_major);
        String name = fieldName.getText().toString();
        String major = fieldMajor.getText().toString();
        Student student = new Student(name, major);

        TableRow tableRow = (TableRow) LayoutInflater.from(this).inflate(R.layout.student_row, null);
        TextView tvId = tableRow.findViewById(R.id.tv_id);
        TextView tvName = tableRow.findViewById(R.id.tv_name);
        TextView tvMajor = tableRow.findViewById(R.id.tv_major);
        tvId.setText(student.getId());
        tvName.setText(student.getName());
        tvMajor.setText(student.getMajor());

        myTableLayout.addView(tableRow);
    }
}