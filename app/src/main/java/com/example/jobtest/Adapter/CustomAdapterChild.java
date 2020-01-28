package com.example.jobtest.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.jobtest.Model.Data;
import com.example.jobtest.R;

class CustomAdapterChild extends RecyclerView.Adapter<CustomAdapterChild.ViewHolderCategory> {
    Context mContext;
    Typeface typefaceuser;
    Data mData;
    int position;

    public CustomAdapterChild() {
    }

    public CustomAdapterChild(Context mContext, Data mData, int position) {
        this.mContext = mContext;
        this.mData = mData;
        this.position = position;
    }

    @NonNull
    @Override
    public CustomAdapterChild.ViewHolderCategory onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.child_info, viewGroup, false);
        return new CustomAdapterChild.ViewHolderCategory(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterChild.ViewHolderCategory viewHolderCategory, int i) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.noimage);
        requestOptions.error(R.drawable.noimage);

        if (position == 0) {
            if (mData.getHotSpots().size() > 0) {
                viewHolderCategory.name.setText(mData.getHotSpots().get(i).getName());
            }
            if (mData.getHotSpots().get(i).getCategories().size() > 0) {
                viewHolderCategory.genre.setText(mData.getHotSpots().get(i).getCategories().get(0).getName());
            }

            if (mData.getHotSpots().get(i).getPhotos().size() > 0) {
                Glide.with(mContext).setDefaultRequestOptions(requestOptions).load(mData.getHotSpots().get(i).getPhotos().get(0)).into(viewHolderCategory.image_view_category);
            }

        }
        if (position == 1) {

        }
        if (position == 2) {

            if (mData.getAttractions().size() > 0) {
                viewHolderCategory.name.setText(mData.getAttractions().get(i).getName());
            }
            if (mData.getAttractions().get(i).getCategories().size() > 0) {
                viewHolderCategory.genre.setText(mData.getAttractions().get(i).getCategories().get(0).getName());
            }

            if (mData.getAttractions().get(i).getPhotos().size() > 0) {
                Glide.with(mContext).load(mData.getAttractions().get(i).getPhotos().get(0)).into(viewHolderCategory.image_view_category);
            }
        }

    }

    @Override
    public int getItemCount() {
        return mData.getAttractions().size();
    }

    public class ViewHolderCategory extends RecyclerView.ViewHolder {
        TextView name;
        TextView genre;
        ImageView image_view_category;

        public ViewHolderCategory(@NonNull View itemView) {
            super(itemView);
            genre = itemView.findViewById(R.id.genre);
            name = itemView.findViewById(R.id.title);
            image_view_category = itemView.findViewById(R.id.image_view_category);

            typefaceuser = Typeface.createFromAsset(mContext.getAssets(), "fonts/RobotoCondensed-Regular.ttf");
            name.setTypeface(typefaceuser);

        }

    }
}

