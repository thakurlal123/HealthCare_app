package com.thakur.customer_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticlesDetailsActivity extends AppCompatActivity {

    TextView tv1;
    ImageView img;
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles_details);
        tv1 = findViewById(R.id.textViewHADCarttitle);
        img = findViewById(R.id.imageViewHAD);
        btnback = findViewById(R.id.buttonHADBack);
        Intent intent = getIntent();
        tv1.setText(intent.getStringExtra("text1"));

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            int resId = bundle.getInt("text2");
            img.setImageResource(resId);
        }
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthArticlesDetailsActivity.this,HealthArticlesActivity.class));
            }
        });
    }
}