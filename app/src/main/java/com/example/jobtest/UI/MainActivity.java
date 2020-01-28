package com.example.jobtest.UI;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jobtest.Adapter.CustomAdapterParent;
import com.example.jobtest.ViewModel.DetailViewModel;
import com.example.jobtest.Model.HomeBodyResponse;
import com.example.jobtest.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.home)
    ImageView home;
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.profile)
    ImageView profile;
    @BindView(R.id.cup)
    ImageView cup;
    @BindView(R.id.fab_1)
    FloatingActionButton fab_1;
    @BindView(R.id.fab_2)
    FloatingActionButton fab_2;
    @BindView(R.id.fab_3)
    FloatingActionButton fab_3;
    @BindView(R.id.fab_4)
    FloatingActionButton fab_4;
    @BindView(R.id.fab)
    ImageView bellman;
    @BindView(R.id.rv_parent)
    RecyclerView recyclerView;

    boolean flag = false;
    DetailViewModel model;
    CustomAdapterParent mCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        model = ViewModelProviders.of(this).get(DetailViewModel.class);
        model.getResult(this).observe(this, new Observer<HomeBodyResponse>() {
            @Override
            public void onChanged(@Nullable HomeBodyResponse s) {
                mCustomAdapter = new CustomAdapterParent(MainActivity.this, s);
                recyclerView.setAdapter(mCustomAdapter);
            }


        });


        bellman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == false) {
                    showAnim();
                } else {
                    hideAnim();
                }
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home.setImageResource(getResources().getIdentifier("home_bottom_icon", "drawable", getPackageName()));
                search.setImageResource(getResources().getIdentifier("search_grey_bottom_icon", "drawable", getPackageName()));
                profile.setImageResource(getResources().getIdentifier("profile_grey_bottom_icon", "drawable", getPackageName()));
                cup.setImageResource(getResources().getIdentifier("notification_grey_bottom_icon", "drawable", getPackageName()));

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home.setImageResource(getResources().getIdentifier("home_grey_bottom_icon", "drawable", getPackageName()));
                search.setImageResource(getResources().getIdentifier("search_bottom_icon", "drawable", getPackageName()));
                profile.setImageResource(getResources().getIdentifier("profile_grey_bottom_icon", "drawable", getPackageName()));
                cup.setImageResource(getResources().getIdentifier("notification_grey_bottom_icon", "drawable", getPackageName()));

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home.setImageResource(getResources().getIdentifier("home_grey_bottom_icon", "drawable", getPackageName()));
                search.setImageResource(getResources().getIdentifier("search_grey_bottom_icon", "drawable", getPackageName()));
                profile.setImageResource(getResources().getIdentifier("profile_bottom_icon", "drawable", getPackageName()));
                cup.setImageResource(getResources().getIdentifier("notification_grey_bottom_icon", "drawable", getPackageName()));

            }
        });

        cup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home.setImageResource(getResources().getIdentifier("home_grey_bottom_icon", "drawable", getPackageName()));
                search.setImageResource(getResources().getIdentifier("search_grey_bottom_icon", "drawable", getPackageName()));
                profile.setImageResource(getResources().getIdentifier("profile_grey_bottom_icon", "drawable", getPackageName()));
                cup.setImageResource(getResources().getIdentifier("notification_bottom_icon", "drawable", getPackageName()));

            }
        });
    }


    public void showAnim() {
        Animation show_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.inside_show1);

        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fab_1.getLayoutParams();
        layoutParams.rightMargin += (int) (fab_1.getWidth() * 1.7);
        layoutParams.bottomMargin += (int) (fab_1.getHeight() * 0.25);
        fab_1.setLayoutParams(layoutParams);
        fab_1.startAnimation(show_fab_1);
        fab_1.setClickable(true);

        Animation show_fab_2 = AnimationUtils.loadAnimation(getApplication(), R.anim.inside_show1);
        FrameLayout.LayoutParams layoutParamst = (FrameLayout.LayoutParams) fab_2.getLayoutParams();
        layoutParamst.rightMargin += (int) (fab_2.getWidth() * 1.7);
        layoutParamst.bottomMargin += (int) (fab_2.getHeight() * 0.25);
        fab_2.setLayoutParams(layoutParamst);
        fab_2.startAnimation(show_fab_2);
        fab_2.setClickable(true);

        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) fab_3.getLayoutParams();
        layoutParams3.rightMargin += (int) (fab_3.getWidth() * 1.7);
        layoutParams3.bottomMargin += (int) (fab_3.getHeight() * 0.25);
        fab_3.setLayoutParams(layoutParams3);
        fab_3.startAnimation(show_fab_1);
        fab_3.setClickable(true);

        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) fab_4.getLayoutParams();
        layoutParams4.rightMargin += (int) (fab_3.getWidth() * 1.7);
        layoutParams4.bottomMargin += (int) (fab_3.getHeight() * 0.25);
        fab_4.setLayoutParams(layoutParams4);
        fab_4.startAnimation(show_fab_1);
        fab_4.setClickable(true);

        flag = true;
    }

    public void hideAnim() {
        Animation hide_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.inside_hide1);

        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fab_1.getLayoutParams();
        layoutParams.rightMargin -= (int) (fab_1.getWidth() * 1.7);
        layoutParams.bottomMargin -= (int) (fab_1.getHeight() * 0.25);
        fab_1.setLayoutParams(layoutParams);
        fab_1.startAnimation(hide_fab_1);
        fab_1.setClickable(false);

        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) fab_2.getLayoutParams();
        layoutParams2.rightMargin -= (int) (fab_2.getWidth() * 1.7);
        layoutParams2.bottomMargin -= (int) (fab_2.getHeight() * 0.25);
        fab_2.setLayoutParams(layoutParams2);
        fab_2.startAnimation(hide_fab_1);
        fab_2.setClickable(false);

        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) fab_3.getLayoutParams();
        layoutParams3.rightMargin -= (int) (fab_3.getWidth() * 1.7);
        layoutParams3.bottomMargin -= (int) (fab_3.getHeight() * 0.25);
        fab_3.setLayoutParams(layoutParams3);
        fab_3.startAnimation(hide_fab_1);
        fab_3.setClickable(false);

        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) fab_4.getLayoutParams();
        layoutParams4.rightMargin -= (int) (fab_4.getWidth() * 1.7);
        layoutParams4.bottomMargin -= (int) (fab_4.getHeight() * 0.25);
        fab_4.setLayoutParams(layoutParams4);
        fab_4.startAnimation(hide_fab_1);
        fab_4.setClickable(false);

        flag = false;
    }
}