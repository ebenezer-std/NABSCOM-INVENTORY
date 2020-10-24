package com.example.nabscom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProductDisplay extends AppCompatActivity {
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_display);
        TextView txtTitle = findViewById(R.id.product_price);
        TextView txtPrice = findViewById(R.id.product_price);
        Intent intent = getIntent();
        Product product1 =  intent.getParcelableExtra("product");

        if (product1==null) {
            product = new Product();
        }
        this.product = product1;

        txtTitle.setText(product.getTitle());
        txtPrice.setText(product.getPrice());

    }
}