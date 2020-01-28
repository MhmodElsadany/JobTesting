package com.example.jobtest.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import com.example.jobtest.Data.APIData;
import com.example.jobtest.Data.ClientRetrofit;
import com.example.jobtest.Model.HomeBodyResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import retrofit2.HttpException;

public class DetailViewModel extends ViewModel {
    Context mContext;
    private MutableLiveData<HomeBodyResponse> mproductMutableLiveData;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public LiveData<HomeBodyResponse> getResult(Context mContext) {
        this.mContext = mContext;
        if (mproductMutableLiveData == null) {
            mproductMutableLiveData = new MutableLiveData<HomeBodyResponse>();
            loadData();

        }
        return mproductMutableLiveData;

    }

    private void loadData() {
        APIData apiData = ClientRetrofit.getInstance()
                .create(APIData.class);
        compositeDisposable.add(apiData.getData()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeBodyResponse>() {
                    @Override
                    public void accept(HomeBodyResponse mdata) throws Exception {
                        mproductMutableLiveData.setValue(mdata);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(mContext, "plz check your internet", Toast.LENGTH_SHORT).show();
                        throwable.printStackTrace();

                        if (throwable instanceof HttpException) {
                            int responseCode = ((HttpException) throwable).code();
                            Log.i("TAG", responseCode + "");
                        }

                    }
                }));


    }
}

