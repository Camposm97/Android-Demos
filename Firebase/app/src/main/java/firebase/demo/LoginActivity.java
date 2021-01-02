package firebase.demo;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class LoginActivity extends AppCompatActivity {
    public static FirebaseAuth mAuth;
    public static FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
    }

    public void login(View v) {
        EditText tfEmail = findViewById(R.id.tfEmail);
        EditText tfPassword = findViewById(R.id.tfPassword);
        String email = tfEmail.getText().toString();
        String password = tfPassword.getText().toString();
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(e -> {
            currentUser = mAuth.getCurrentUser();
            FirebaseUserMetadata metadata = currentUser.getMetadata();
            String displayName = currentUser.getDisplayName();
            boolean isVerified = currentUser.isEmailVerified();
            System.out.println();
            System.out.println("created on: " + new Date(metadata.getCreationTimestamp()));
            System.out.println("last login: " + new Date(metadata.getLastSignInTimestamp()));
            System.out.println("Email: " + currentUser.getEmail());
            System.out.println("displayName=" + displayName);
            System.out.println("isVerified=" + isVerified);
            Toast.makeText(LoginActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
            displayMain();
        }).addOnFailureListener(e -> {
           Toast.makeText(LoginActivity.this, "Failed to login!", Toast.LENGTH_SHORT).show();
        });
    }

    public void signUp(View v) {
        View view = View.inflate(this, R.layout.dialog_sign_up, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sign Up");
        builder.setView(view);
        builder.setNegativeButton("Cancel", null);
        builder.setPositiveButton("Sign Up", (dialog, which) -> {
            EditText tfEmail = view.findViewById(R.id.tfEmail);
            EditText tfPassword = view.findViewById(R.id.tfPassword);
            String email = tfEmail.getText().toString();
            String password = tfPassword.getText().toString();
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                return;
            }
            System.out.println("User entered: " + email + " | " + password);
            mAuth.createUserWithEmailAndPassword(email, password).addOnFailureListener(e -> {
                Toast.makeText(LoginActivity.this, "Failed to create account!", Toast.LENGTH_SHORT).show();
            }).addOnSuccessListener(authResult -> {
                Toast.makeText(LoginActivity.this, "Created account!", Toast.LENGTH_SHORT).show();
            });
        });
        builder.show();
    }

    public void displayMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}