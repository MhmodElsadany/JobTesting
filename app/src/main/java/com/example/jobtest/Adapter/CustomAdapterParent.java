package com.example.jobtest.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobtest.Model.HomeBodyResponse;
import com.example.jobtest.R;

public class CustomAdapterParent extends RecyclerView.Adapter<CustomAdapterParent.ViewHolderProduct> {
    Context mContext;
    HomeBodyResponse mData;
    Typeface typefaceuser;
    CustomAdapterChild mCustomAdapter;

    public CustomAdapterParent() {
    }

    public CustomAdapterParent(Context mContext, HomeBodyResponse mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolderProduct onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sub_recyler, viewGroup, false);
        return new ViewHolderProduct(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProduct viewHolderProduct, int i) {

        viewHolderProduct.recyclerView.setLayoutManager(new LinearLayoutManager
                (mContext, LinearLayoutManager.HORIZONTAL, false));
        Log.i("mmm", i + "");


        switch (i) {
            case 0:
                viewHolderProduct.name.setText("Hotspos");
                viewHolderProduct.icon.setImageResource(R.drawable.hotspot_icon);
                mCustomAdapter = new CustomAdapterChild(mContext, mData.data, 0);
                viewHolderProduct.recyclerView.setAdapter(mCustomAdapter);
                break;
            case 1:
                viewHolderProduct.name.setText("Events");
                viewHolderProduct.icon.setImageResource(R.drawable.events_icon);
                mCustomAdapter = new CustomAdapterChild(mContext, mData.data, 1);
                viewHolderProduct.recyclerView.setAdapter(mCustomAdapter);

                break;
            case 2:
                viewHolderProduct.name.setText("Attraction");
                viewHolderProduct.icon.setImageResource(R.drawable.attarctions_icon);
                mCustomAdapter = new CustomAdapterChild(mContext, mData.data, 2);
                viewHolderProduct.recyclerView.setAdapter(mCustomAdapter);

                break;
            default:
                Log.i("TAG", "error");

        }


    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolderProduct extends RecyclerView.ViewHolder {
        TextView name;
        RecyclerView recyclerView;
        ImageView icon;

        public ViewHolderProduct(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameCategory);
            recyclerView = itemView.findViewById(R.id.home_recycler_view_horizontal);
            icon = itemView.findViewById(R.id.iconn);
            typefaceuser = Typeface.createFromAsset(mContext.getAssets(), "fonts/Xerox Serif Wide Bold Italic.ttf");
            name.setTypeface(typefaceuser);

        }

    }
}
