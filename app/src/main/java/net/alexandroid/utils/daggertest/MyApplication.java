package net.alexandroid.utils.daggertest;

import android.app.Application;
import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import net.alexandroid.utils.mylog.MyLog;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MyLog.init(this);
        MyLog.setTag("ZAQ");

        // TODO Continue from here: https://www.youtube.com/watch?v=gg1zxoVStBM

        Context context = this;

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                MyLog.d(message);
            }
        });

        File file = new File(context.getCacheDir(), "okhttp_cache");
        Cache cache = new Cache(file, 10 * 1024 * 1024); // 10 MB)

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();


        Picasso picasso = new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
    }
}
