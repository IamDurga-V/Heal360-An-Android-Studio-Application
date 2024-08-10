package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LabTestDetailsActivity extends AppCompatActivity {

    private TextView tvPackageName, tvTotalCost;
    private EditText edDetails;
    private Button btnAddToCart, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab_test_details);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();

        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        setIntentData(intent);

        btnBack.setOnClickListener(v -> startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class)));

        btnAddToCart.setOnClickListener(v -> addToCart(intent));
    }

    private void initializeViews() {
        tvPackageName = findViewById(R.id.textViewLDPackageName);
        tvTotalCost = findViewById(R.id.textViewLDTotalCost);
        edDetails = findViewById(R.id.editTextLDTextMultiLine);
        btnBack = findViewById(R.id.buttonLDBack);
        btnAddToCart = findViewById(R.id.buttonLDAddToCart);
    }

    private void setIntentData(Intent intent) {
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost : " + intent.getStringExtra("text3") + "/-");
    }

    private void addToCart(Intent intent) {
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String product = tvPackageName.getText().toString();

        float price;
        try {
            price = Float.parseFloat(intent.getStringExtra("text3"));
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Invalid price format", Toast.LENGTH_SHORT).show();
            return;
        }

        Database db = new Database(getApplicationContext(), "heal360", null, 1);
        if (db.checkCart(username, product) == 1) {
            Toast.makeText(getApplicationContext(), "Product Already Inserted", Toast.LENGTH_SHORT).show();
        } else {
            db.addCart(username, product, price, "lab");
            Toast.makeText(getApplicationContext(), "Record Inserted To cart", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
        }
    }
}
