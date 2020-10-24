package com.example.nabscom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ProductDisplay extends AppCompatActivity {
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_product);

        Intent intent = getIntent();
        Product product1 =  intent.getParcelableExtra("product");
        this.product = product1;
    }
}