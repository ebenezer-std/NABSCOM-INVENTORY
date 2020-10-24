package com.example.nabscom;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * created by joseph mulingwa kithome on
 */
public class ProductAdapter extends  RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> mProductList = new ArrayList<>();
    private Context mContext;

    public ProductAdapter(Context mContext, List<Product> myProductList) {
        this.mContext = mContext;
        this.mProductList = myProductList;

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = mProductList.get(position);
        holder.bind(product);


    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        TextView tvTitle;
        TextView tvDescription;
        TextView tvPrice;
        ImageView imageItem;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.title);
            tvDescription = itemView.findViewById(R.id.description);
            imageItem = (ImageView) itemView.findViewById(R.id.itemImage);
            tvPrice = itemView.findViewById(R.id.price);

            itemView.setOnClickListener(this);

        }

        public void bind(Product product) {
            tvTitle.setText(product.getTitle());
            tvDescription.setText(product.getDescription());
            tvPrice.setText(product.getPrice());
            showImage(product.getImageUrl());


        }

        private void showImage(String url) {
            if (url != null && url.isEmpty() == false) {
                Picasso.get()
                        .load(url)
                        .resize(160, 160)
                        .centerCrop()
                        .into(imageItem);
            }
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Log.d("Click", String.valueOf(position));
            Product selectedProduct = mProductList.get(position);
            Intent intent = new Intent(view.getContext(), ProductDisplay.class);
            intent.putExtra("product", selectedProduct);
            view.getContext().startActivity(intent);
        }
    }
}
