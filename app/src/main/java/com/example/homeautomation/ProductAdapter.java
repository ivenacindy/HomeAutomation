package com.example.recycleandcard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private Context mCtx;
    private List<Product> productList;

    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_view, null);
        ProductViewHolder holder = new ProductViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        Product product = productList.get(i);
        productViewHolder.textViewtTitle.setText(product.getTitle());
        productViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewtTitle;

        public ProductViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewtTitle = itemView.findViewById(R.id.textViewTitle);
        }
    }
}
