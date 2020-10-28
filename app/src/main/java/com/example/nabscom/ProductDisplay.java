package com.example.nabscom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductDisplay extends AppCompatActivity {
    Product product;
    ImageView product_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_display);
        TextView txtTitle = findViewById(R.id.product_title);
        TextView txtPrice = findViewById(R.id.price);
        TextView txt = findViewById(R.id.product_price);
        TextView txtDescription = findViewById(R.id.product_description);

        product_image = findViewById(R.id.product_image);
        Intent intent = getIntent();
        Product product1 = intent.getParcelableExtra("product");
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

        if (product1 == null) {
            product = new Product();
        }
        this.product = product1;

        txtTitle.setText(product.getTitle());
        txtPrice.setText(product.getPrice());
        txtDescription.setText(product.getDescription());
        showImage(product.getImageUrl());

    }

    private void showImage(String url) {
        if (url != null && url.isEmpty() == false) {
            Picasso.get()
                    .load(url)
                    .resize(160, 160)
                    .centerCrop()
                    .into(product_image);
        }
    }
}